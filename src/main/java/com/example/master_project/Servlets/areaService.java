package com.example.master_project.Servlets;

import com.example.master_project.Models.Area;
import com.example.master_project.Repository.areaRepository;
import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

@Service
public class areaService {
    @Autowired
    private areaRepository areaRepository;

    public void Save(Area area){
        areaRepository.save(area);
    }

    public List<Area> GetAll(){
        return (List<Area>) areaRepository.findAll();
    }

    public List<Area> Getsomeby_project_id(int proid){
        return (List<Area>) areaRepository.findAllByProjectId(proid);
    }

    public Optional<Area> GetOne(int id){
        return  areaRepository.findById(id);
    }

    public void Delete(int id) {
        areaRepository.deleteById(id);
    }

    public List<String> Fitted(Area area){
        List<String> fit =new ArrayList<>();
        if(area.getHorizontal_Alignment().equals("small to medium curvature")&&area.getBridge_Span_length().equals("20-50 m"))
            fit.add("Precast Span by Span using launching Girder");
        if(!area.getSoil_condition().equals("weak")&&
                area.getBridge_Span_length().equals("20-50 m")&&
                area.getHorizontal_Alignment().equals("small to medium curvature"))
            fit.add("Full Span Launching Method");

        if(area.getNature_of_crossing().equals("Highway" )&& area.getAccessability_to_site().equals("ease access")&&!area.getSoil_condition().equals("weak")&&
        area.getVolume_of_Traffic_During_Construction().equals("Moderate" )&& !area.getLand_tepography_range().equals("more than 400 cm")&&
                !area.getBridge_hight_above_ground().equals("more than 20 m")&&area.getBridge_Span_length().equals("50-200 m")&&area.getCranes_capacity_and_maneuvering().equals("require area for maneuvering"))
            fit.add("Free Cantilever precast using  lifting frame and formwork ");

        if(!area.getNature_of_crossing().equals("Railway")&&(area.getBridge_Span_length().equals("50-200 m")||area.getBridge_Span_length().equals("more than 200 m")))
            fit.add("Balanced Cantilever cast in situ using two travelers");

        if(area.getBridge_Span_length().equals("50-200 m")||area.getBridge_Span_length().equals("more than 200 m"))
            fit.add("Balanced Cantilever precast using lifting frames ");

        if(area.getHorizontal_Alignment().equals("small to medium curvature")&&area.getBridge_Span_length().equals("20-50 m"))
            fit.add("Precast Incremental launching");


        if((area.getBridge_Span_length().equals("20-50 m")||area.getBridge_Span_length().equals("50-200 m"))&&area.getCranes_capacity_and_maneuvering().equals("require area for maneuvering")
                &&!area.getBridge_hight_above_ground().equals("more than 20 m")&&area.getLand_tepography_range().equals("0 - 200 cm")&&
        area.getVolume_of_Traffic_During_Construction().equals("Moderate")&&area.getNature_of_crossing().equals("Highway"))
            fit.add("Cast in Situ segment  using formwork supported on ground");
        if(area.getNature_of_crossing().equals("Highway")&&!area.getSoil_condition().equals("weak")&&area.getVolume_of_Traffic_During_Construction().equals("Moderate"
                )&&area.getLand_tepography_range().equals("0 - 200 cm")&&!area.getBridge_hight_above_ground().equals("more than 20 m")&&
                (area.getBridge_Span_length().equals("20-50 m")||area.getBridge_Span_length().equals("0-20 m"))&&area.getCranes_capacity_and_maneuvering().equals("require area for maneuvering"))
            fit.add("Reinforced Concrete (RC) cast in situ girder");

        if(!area.getNature_of_crossing().equals("Railway")&&(area.getBridge_Span_length().equals("20-50 m")||area.getBridge_Span_length().equals("0-20 m"))&&
                area.getCranes_capacity_and_maneuvering().equals("require area for maneuvering")&&area.getHorizontal_Alignment().equals("small to medium curvature")&&
                !area.getLand_tepography_range().equals("more than 400 cm")&& area.getAccessability_to_site().equals("ease access"))
            fit.add("precast post tension girder");
////////////////////////////////////////////////////////
        if(area.getNature_of_crossing().equals("Highway")&&(area.getBridge_Span_length().equals("20-50 m")||area.getBridge_Span_length().equals("0-20 m"))&&
                area.getCranes_capacity_and_maneuvering().equals("require area for maneuvering")&&!area.getBridge_hight_above_ground().equals("more than 20 m")
            &&area.getHorizontal_Alignment().equals("small to medium curvature")
        &&area.getVolume_of_Traffic_During_Construction().equals("Moderate")&&area.getLand_tepography_range().equals("0 - 200 cm")
        )
            fit.add("cast in situ post tension girde");


        if(area.getNature_of_crossing().equals("Highway")&&(area.getBridge_Span_length().equals("20-50 m")||area.getBridge_Span_length().equals("0-20 m"))&&
                area.getCranes_capacity_and_maneuvering().equals("require area for maneuvering")
                &&!area.getBridge_hight_above_ground().equals("more than 20 m")&&
                area.getLand_tepography_range().equals("0 - 200 cm")
                &&!area.getSoil_condition().equals("weak")&&area.getLand_tepography_range().equals("0 - 200 cm")
                &&area.getVolume_of_Traffic_During_Construction().equals("Moderate"))
            fit.add("Hollow core slab cast in situ");
        ////////////////////////////////////////////////////
        return fit;
    }

    public String getDesc(String method){
        JSONParser parser = new JSONParser();
        try (Reader reader = new FileReader("methods.json")) {

            JSONObject jsonObject = (JSONObject) parser.parse(reader);
            System.out.println(jsonObject);

            String name = (String) jsonObject.get("method");
            System.out.println(name);

            long age = (Long) jsonObject.get("description");
            System.out.println(age);


        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }

    public String getDescription(String method){
        String desc="";
        if((method.trim().toLowerCase()).equals("Precast Span by Span using launching Girder".trim().toLowerCase()))desc="Span-by-span erection is the most common, simplest, and often most cost-effective construction method for precast segmental bridges. It is typically addressed to long bridges with a great number of 25-45m spans with large plan radius, and it is compatible with simply-supported and continuous spans. The maximum gradient of the bridge governs the design of the erection equipment, but a 4-5% gradient is rarely a major problem. The segment weight ranges between 30t and 150t, and the span weight ranges between 200t and more than 2000t. Although external post-tensioning facilitates segment production and enhances strand protection in the non-infrequent case of leaking joints, many span-by-span bridges have been post-tensioned with internal tendons. The span-by-span method has reached 50m spans; however, for spans longer than 45-50m or very wide, this method loses much of its appeal due to the cost and complexity of self-launching erection equipment designed to sustain the weight of an entire span of segments.";
        else if((method.trim().toLowerCase()).equals("Full Span Launching Method".trim().toLowerCase()))desc="Pre-casting The Full Span Construction Approach is a prevalent technique for bridge construction, particularly for High Speed Railways. It is intended for use in bridges with lengths of less than 50 meters. The full span approach entails installing one entire span of precast girders at a time when the beam launcher creates the bridge. In general, the full span technique is appropriate for bridges with spans of 20-50m and girder weights ranging from 30t to 900t; the following are major steps: The pre-cast full span method of construction (often known as FSM) is one of the quickest procedures used in bridge and viaduct building. The FSM entails casting the entire bridge span in the casting yard and delivering it to the bridge site on a specially constructed multi-axle Tire Trolley. An FSM purpose-built Launcher will be utilized at the bridge site to raise and install the entire span.";
        else if((method.trim().toLowerCase()).equals("Free Cantilever precast using lifting frame and formwork".trim().toLowerCase()))desc="Progressive placement or free cantilever with cranes or lifting frames is the most time-consuming erection technique for precast segmental bridges because of the single work location. The erection equipment can be particularly inexpensive, especially when ground cranes erect the segments throughout the length of the bridge and temporary towers support the front cantilever during erection. Progressive placement has been applied or considered for 30-90m spans in environmentally sensitive locations where construction access was restricted to one or both ends of the bridge.";
        else if((method.trim().toLowerCase()).equals("Balanced Cantilever cast in situ using two travelers".trim().toLowerCase()))desc="After the bottom infrastructure of the bridge has been built. Each pier is the starting point for bridge building. Special formwork is erected, and work on the cast-in-place pier piece begins. The entire pier length is then employed as an erection platform for cast-in-place portions, supporting a form traveller. Soffit shuttering, web shuttering, and deck shuttering are then installed on both sides of the pier. After that, both sides of the pier are concreted. For form travellers, the segment production rate is usually one segment every five days. Segments of cast-in-situ range in length from 3 to 5 meters, with formwork moving in tandem with each section. Construction of segments continues until a joining halfway is reached, at which time a balanced pair is closed.";
        else if((method.trim().toLowerCase()).equals("Balanced Cantilever precast using lifting frames".trim().toLowerCase()))desc="All permanent pier foundations and pier shafts in the main unit are built. The piers are utilized as an erection platform for precast parts once they are completed. First, put together and install the lifting frame. Install the first pair of precast segments, build the wet joints, cure the wet joints, and then install the second pair of precast segments. After that, you'll need to build and cure joints. This method is repeated until the construction project is completed, and then the lifting frame is removed.";
        else if((method.trim().toLowerCase()).equals("Precast Incremental launching".trim().toLowerCase()))desc="Incremental launching is a procedure that involves casting portions at the crossing's end and pushing them across with huge hydraulic rams. When the piers can be easily located at regular intervals, this strategy is most useful. Depending on the span length, temporary support bents may or may not be necessary at mid-spans. To control erection stresses, a steel launching nose is usually affixed to the end of the segments. The segments are usually between 15 and 30 meters long. Unless there are additional factors to consider, incremental launching is suitable for bridge lengths of (305 to 610 m). When working space is limited, for example, bridges up to 1220 meters in length can be built by launching from both ends. There are certain limitations to examine while considering incremental launching. The horizontal and vertical alignments must be either straight or have a constant radius of curvature, preferably (76 m) or more. In addition, there must be no transitions between the top slab's crown or super height.";
        else if((method.trim().toLowerCase()).equals("Cast in Situ segment using formwork supported on ground".trim().toLowerCase()))desc="Cast-in-place segmental construction is used when the precast segments are too heavy to be shipped or access is too restrictive. It has been used for span lengths up to 200 m. Stationary Falsework is the most basic method of constructing a bridge superstructure. One benefit is that stationary falsework can be built to any desired shape by less specialized labor. The use of modern standard elements from which the falsework is constructed allows for simple erection. However, there are significant drawbacks to stationary falsework. Stationary falsework necessitates a large amount of material, as well as considerable time and manual labour, in addition to the cost of purchasing or renting the materials itself. As a result, believing that it must be built several spans ahead of time in order to keep up with the speeds of concrete placing that can be achieved.";
        else if((method.trim().toLowerCase()).equals("Reinforced Concrete (RC) cast in situ girder".trim().toLowerCase()))desc="Stationary Falsework is the most basic method of constructing a bridge superstructure. One benefit is that stationary falsework can be built to any desired shape by less specialized labor. The use of modern standard elements from which the falsework is constructed allows for simple erection. However, there are significant drawbacks to stationary falsework. Stationary falsework necessitates a large amount of material, as well as considerable time and manual labour, in addition to the cost of purchasing or renting the materials itself. As a result, believing that it must be built several spans ahead of time in order to keep up with the speeds of concrete placing that can be achieved.";
        else if((method.trim().toLowerCase()).equals("precast post tension girder".trim().toLowerCase()))desc="Beam and slab bridges are the most common type used of concrete bridge nowadays. They offer simplicity, economy, a large number of standard elements, and speedy erection. The precast beams are often mounted on maintenance-free rubber bearings on the supporting piers or abutments. Then an in-situ reinforced concrete deck slab is cast on permanent shuttering that spans between the beams. In this method along with concrete and reinforcement, steel strands or tendons are also used to introduce post tensioning. the strands which have been passed through the concrete are pulled by the jack up to certain tensile force which was pre-determined. Now, the steel stands should be locked. This type of construction increases the load carrying capacity of bridge and improves the durability of bridge. Post tensioning eliminates the use of intermediate supports for long span bridges.";
        else if((method.trim().toLowerCase()).equals("cast in situ post tension girder".trim().toLowerCase()))desc="Cat-in-situ Post tensioning method of bridge construction is more demanding method because of its durability and applicability to complex bridge curves etc. In this method along with concrete and reinforcement, steel strands or tendons are also used to introduce post tensioning. When the formwork is prepared, strands are arranged with in the reinforcement and concrete is filled. After the hardening of concrete, the strands which have been passed through the concrete are pulled by the jack up to certain tensile force which was pre-determined. Now, the steel stands should be locked. This type of construction increases the load carrying capacity of bridge and improves the durability of bridge. Post tensioning eliminates the use of intermediate supports for long span bridges.";
        else if((method.trim().toLowerCase()).equals("Hollow core slab cast in situ".trim().toLowerCase()))desc="In terms of modernity, this bridge is akin to a suspension bridge. In this style, instead of dangling wires, cables are connected directly to the tower. The wires are always under tension due to their attachment to the roadway, which causes them to extend. There is just one tower to handle the stress on this type of bridge, and there are no anchorages to carry the compression. A cable supported bridge has a span length of 500 to 1000 meters. In this type of bridge, the cables are directly linked to the roadway at multiple radial points, and the compression forces are handled only by the towers. The benefits of a cable-stayed bridge are that it is less expensive than a suspension bridge, that it is good for medium spans, and that it can be easily constructed by cantilevering out from the tower, but the disadvantages are that maintenance and inspection are more difficult, and that this type of bridge is not suitable for long distances.";
        return desc;
    }

    public String Description(String method){
        String desc="";
        if((method.trim().toLowerCase()).equals("Precast Span by Span using launching Girder".trim().toLowerCase())) {
            desc = "Before the next span is erected, a full span is assembled, post-tensioned, and erected so that it is self-supporting. The technology is suitable for span lengths of up to 45 meters. The approach is less cost effective beyond 45 to 55 meters. Before the segments are post-tensioned together, all of the segments are supported by an erecting truss in one form of this procedure. The erecting truss can either be above or below the segments. The gantry's performance standards and configuration are directly influenced by the system for combining and activating segments into self-supporting spans. In order to order the correct gantry, the contractor must first have a complete understanding of how the bridge he or she is building will operate physically. The erection truss is transported to the next span once the segments have been post-tensioned together and the span has rested on its bearings. The segments can be built at ground level, post-tensioned together, and the full span installed on site when space permits.\n<br>" +
                    "The construction sequence : -\n<br><br>" +
                    "???\tEach segment will be transferred from its position in the storage area to the preparation area to be loaded on truck. The preparation of the segment consists in: Install connecting beam with blister and shear cone, Install the fastening system for transportation, install guardrails for gluing operation, and Install Top and bottom temporary Pre-stressing bars.\n<br><br><br><br>" +
                    "???\tSpan erection starts with the SOP lifting by mean of MWT placed at the center of the Truss between Rear Support and Front Support. The MWT spreader beam is lowered down to catch the segment from the truck. The operation is done by the Main Winch operator with the remote control.\n<br><br><br><br>" +
                    "???\tOnce the spreader beam is clamped (CLAMP ON), the road fastening is removed from the truck. Once controlled, the Segment is lifted and rotated by the MWT and bring to its Pre-hanging position. For the setting out of the SOP, Pre-adjustment span and Final adjustment of the span is under the responsibility of survey team.\n<br><br><br><br>" +
                    "???\tRepeat previous operation as per segment till lifting and hanging all the span segments\n<br><br><br><br>" +
                    "???\tBy man of MWT, engage the MWT spreader beam on SOPA, and once controlled and secured, release the hanging bars, one per one. To release the hanging bars, lift up of about 1,0m and lock the nut. The MWT is then used on slowly speed to settle the SOP.A on its temporary bearing or ???Erection position.\n<br><br><br><br>" +
                    "???\tWhen position accepted (X, Y, Z,) reengage the hanging bars and disconnect MWT. Final fine position in Z and deck slope is done by the mean of hanging bars and top jacks on girders. When position validated, engage the temporary bearing jack below the SOP.A \n<br><br><br><br>" +
                    "???\tSegment gluing and temporary stressing.\n<br><br><br><br>" +
                    "???\t Post-tensioning operation.\n<br><br><br><br>" +
                    "???\tLaunching to the next span.\n<br><br><br><br>";
        }
        else if((method.trim().toLowerCase()).equals("Full Span Launching Method".trim().toLowerCase())) {
            desc ="Pre-casting The Full Span Construction Approach is a prevalent technique for bridge construction, particularly for High Speed Railways. It is intended for use in bridges with lengths of less than 50 meters. The full span approach entails installing one entire span of precast girders at a time when the beam launcher creates the bridge. In general, the full span technique is appropriate for bridges with spans of 20-50m and girder weights ranging from 30t to 900t; the following are major steps: The pre-cast full span method of construction (often known as FSM) is one of the quickest procedures used in bridge and viaduct building. The FSM entails casting the entire bridge span in the casting yard and delivering it to the bridge site on a specially constructed multi-axle Tire Trolley. An FSM purpose-built Launcher will be utilized at the bridge site to raise and install the entire span.";
        }
        else if((method.trim().toLowerCase()).equals("Free Cantilever precast using lifting frame and formwork".trim().toLowerCase())) {
            desc ="The balanced cantilever principle is modified by progressive positioning. Progressive placement erects cantilevers in only one direction, rather than starting at a pier and proceeding in two directions. A crane capable of lifting and swinging around and lowering a segment transported along the previously finished portion of the bridge to be fastened to the end of the cantilever is required. This construction style is particularly well suited to environmentally sensitive places or areas with limited construction access. Because the substructure and superstructure may all be created from the superstructure, it's commonly referred to as \"top-down\" construction. To avoid overstresses, temporary piers are normally placed in the middle of each span. The method is ideal for span lengths of 30 to 90 meters. The Linn Cove Viaduct, near Grandfather Mountain in North Carolina, is a good example. This project will wrap the Blue Ridge Parkway around a mountain in a picturesque and environmentally sensitive location, making it the parkway's final link. In fact, the terrain is so rugged that heavy construction equipment cannot access to the pier locations without causing significant damage. The bridge's owner, the National Park Service, stated that a construction road could only run from the abutment to the first pier. The Linn Cove viaduct is being built using a progressive placement method, with temporary bents placed in the middle of the span between the permanent piers. The bents and piers are being built from the top down, with the precast parts being placed using a stiff leg derrick. The derrick lowers workers and equipment to drill and cast 9-in. micro shaft piles as the end of the cantilever approaches a pier location. The elliptical shaped footing is next cast and lowered with the derrick over the completed segment of the bridge The pier stems are made up of precast segments that are transported and installed in a similar fashion. Following the installation and stressing of the vertical pier post-tensioning tendons, the superstructure section placement resumes until the next pier location is reached. The procedure is then repeated.";
        }
        else if((method.trim().toLowerCase()).equals("Balanced Cantilever cast in situ using two travelers".trim().toLowerCase())) {
            desc ="The Balanced Cantilever Method is a bridge building technique that avoids the use of scaffolding beneath the bridge and instead completes the superstructure by successively joining the segments to form a span by post-tensioning and balancing them left and right from each pier with special erection equipment. Cast-in-Place Cantilever Method and Precast Cantilever Method are two types of balanced cantilever methods. When it comes to segmental building, balanced cantilever erection is increasingly becoming the \"traditional\" method. This strategy addresses a wide range of issues, including environmental constraints, existing traffic issues, inaccessible topography, and so on. The superstructure is built using the balanced cantilever method, which involves cantilevering out from opposite sides of the pier. To maintain a generally balanced system, the segments are added to each cantilever at the same time or alternately. To lessen the out-of-balance moment, segments are frequently offset by half a segment length. A cast-in-place closure segment is placed after the cantilevers from each adjacent pier reach mid-span, followed by additional post-tensioning. For span lengths of more than 48 m, the balanced cantilever approach is the most cost-effective. The weight of the segments near the piers limits the use of precast segments in balanced cantilever construction for span lengths greater than roughly 140 m. In the balanced cantilever method, Ground- or water-based cranes, deck-mounted lifters at the ends of each cantilever, or an overhead gantry are used to hoist segments into place. The method chosen is determined by the amount of spans, the contractor's desire, and the availability of access. Three piers are usually used to support an overhead gantry.\n" +
                    " Cantilever construction is a way of building a cantilever in segments and then sewing them to segments that have already been pre-stressed. The failure analysis of the bridge during the construction phase is critical; in a balanced cantilever construction of a continuous bridge, the bridge's bending moment increases with the addition of each new segment. When the cantilever segments are added to both sides of the pier, the bending moment in the pier becomes negative and grows with each successive segment added. The bridge is transformed from a cantilever to a continuous shape when the key blocks are inserted, and the negative bending moments on the pier are reduced, resulting in a positive moment. The bridge may fail during the intermediate stage if the design is based solely on the structural factors of the final construction stage.\n" +
                    "After the bottom infrastructure of the bridge has been built. Each pier is the starting point for bridge building. Special formwork is erected, and work on the cast-in-place pier piece begins. The entire pier length is then employed as an erection platform for cast-in-place portions, supporting a form traveller. Soffit shuttering, web shuttering, and deck shuttering are then installed on both sides of the pier. After that, both sides of the pier are concreted. For form travellers, the segment production rate is usually one segment every five days. Segments of cast-in-situ range in length from 3 to 5 meters, with formwork moving in tandem with each section. Construction of segments continues until a joining halfway is reached, at which time a balanced pair is closed.\n";
        }
        else if((method.trim().toLowerCase()).equals("Balanced Cantilever precast using lifting frames".trim().toLowerCase())) {
            desc = "The Balanced Cantilever Method is a bridge building technique that avoids the use of scaffolding beneath the bridge and instead completes the superstructure by successively joining the segments to form a span by post-tensioning and balancing them left and right from each pier with special erection equipment. Cast-in-Place Cantilever Method and Precast Cantilever Method are two types of balanced cantilever methods. When it comes to segmental building, balanced cantilever erection is increasingly becoming the \"traditional\" method. This strategy addresses a wide range of issues, including environmental constraints, existing traffic issues, inaccessible topography, and so on. The superstructure is built using the balanced cantilever method, which involves cantilevering out from opposite sides of the pier. To maintain a generally balanced system, the segments are added to each cantilever at the same time or alternately. To lessen the out-of-balance moment, segments are frequently offset by half a segment length. A cast-in-place closure segment is placed after the cantilevers from each adjacent pier reach mid-span, followed by additional post-tensioning. For span lengths of more than 48 m, the balanced cantilever approach is the most cost-effective. The weight of the segments near the piers limits the use of precast segments in balanced cantilever construction for span lengths greater than roughly 140 m. In the balanced cantilever method, Ground- or water-based cranes, deck-mounted lifters at the ends of each cantilever, or an overhead gantry are used to hoist segments into place. The method chosen is determined by the amount of spans, the contractor's desire, and the availability of access. Three piers are usually used to support an overhead gantry.\n" +
                    " Cantilever construction is a way of building a cantilever in segments and then sewing them to segments that have already been pre-stressed. The failure analysis of the bridge during the construction phase is critical; in a balanced cantilever construction of a continuous bridge, the bridge's bending moment increases with the addition of each new segment. When the cantilever segments are added to both sides of the pier, the bending moment in the pier becomes negative and grows with each successive segment added. The bridge is transformed from a cantilever to a continuous shape when the key blocks are inserted, and the negative bending moments on the pier are reduced, resulting in a positive moment. The bridge may fail during the intermediate stage if the design is based solely on the structural factors of the final construction stage.\n" +
                    "     All permanent pier foundations and pier shafts in the main unit are built. The piers are utilized as an erection platform for precast parts once they are completed. First, put together and install the lifting frame. Install the first pair of precast segments, build the wet joints, cure the wet joints, and then install the second pair of precast segments. After that, you'll need to build and cure joints. This method is repeated until the construction project is completed, and then the lifting frame is removed.\n";
        }
        else if((method.trim().toLowerCase()).equals("Precast Incremental launching".trim().toLowerCase())) {
            desc ="Incremental launching is a procedure that involves casting portions at the crossing's end and pushing them across with huge hydraulic rams. When the piers can be easily located at regular intervals, this strategy is most useful. Depending on the span length, temporary support bents may or may not be necessary at mid-spans. To control erection stresses, a steel launching nose is usually affixed to the end of the segments. The segments are usually between 15 and 30 meters long. Unless there are additional factors to consider, incremental launching is suitable for bridge lengths of (305 to 610 m). When working space is limited, for example, bridges up to 1220 meters in length can be built by launching from both ends.\n" +
                    "There are certain limitations to examine while considering incremental launching. The horizontal and vertical alignments must be either straight or have a constant radius of curvature, preferably (76 m) or more. In addition, there must be no transitions between the top slab's crown or super height. The Wabash River Bridge in Covington, Indiana, was the country's first incrementally launched bridge. The original design plans and requirements called for precast segmental construction to be erected using cranes and balanced cantilevers. The contractor used an option to change the building process, saving the state of Indiana money. Although the author is not aware of any projects that use this technology, it is possible that precast segments will be introduced. Similar constraints would most likely apply, but the basic principles may be employed to launch prefabricated segments to reach the required effect.\n";
        }
        else if((method.trim().toLowerCase()).equals("Cast in Situ segment using formwork supported on ground".trim().toLowerCase())) {
            desc = "Casting the segments in their final place on the framework is another option. When huge, heavy portions are encountered, cast-in-place construction proves to be quite useful. Instead of managing the segments, only the materials must be transported, which has an impact on the type and amount of equipment needed. The employment of form travellers is a popular way for casting parts into place. Steel cantilever trusses attached to previously built segments support moveable forms called form passengers. Wood or steel can be used to make the forms themselves. A minimum of two form travellers are required when using balanced cantilever erection. For form travellers, the segment production rate is usually one segment every five days. Therefore, to approach the common precast segment production rate previously discussed, at least four travelers are required Concrete admixtures that accelerate the early strength gain of concrete, as well as partial post-tensioning, can minimize the 5-day cycle time. However, a feasible minimum cycle duration per traveller is roughly 3 days. Cast-in-place manufacturing allows for more alignment variations and repairs, but more corrections will almost certainly be required. The difference in alignment corrections between cast-in-place and precast construction is directly proportional to the age of the concrete when loaded. When concrete is loaded in a cast-in-place structure, it is usually significantly younger. The values of the deformations due to creep and shrinkage fluctuate logarithmically with the age of the concrete, with the values falling as the age at loading increases. For instance, the ultimate creep deformation of concrete loaded seven days after casting will be about 1.5 times that of the same concrete poured 28 days later. When a whole cantilever is evaluated, the 5-day age difference for each segment results in a considerable variance in the creep rate. (Another reason to use a computer in any bridge job is because of its intricacy.)";
        }
        else if((method.trim().toLowerCase()).equals("Reinforced Concrete (RC) cast in situ girder".trim().toLowerCase())) {
            desc = "Stationary Falsework is the most basic method of constructing a bridge superstructure. One benefit is that stationary falsework can be built to any desired shape by less specialized labor. The use of modern standard elements from which the falsework is constructed allows for simple erection. However, there are significant drawbacks to stationary falsework. Stationary falsework necessitates a large amount of material, as well as considerable time and manual labour, in addition to the cost of purchasing or renting the materials itself. As a result, believing that it must be built several spans ahead of time in order to keep up with the speeds of concrete placing that can be achieved.";
        }
        else if((method.trim().toLowerCase()).equals("precast post tension girder".trim().toLowerCase())) {
            desc = "Beam and slab bridges are the most common type used of concrete bridge nowadays. They offer simplicity, economy, a large number of standard elements, and speedy erection. The precast beams are often mounted on maintenance-free rubber bearings on the supporting piers or abutments. Then an in-situ reinforced concrete deck slab is cast on permanent shuttering that spans between the beams. In this method along with concrete and reinforcement, steel strands or tendons are also used to introduce post tensioning. the strands which have been passed through the concrete are pulled by the jack up to certain tensile force which was pre-determined. Now, the steel stands should be locked. This type of construction increases the load carrying capacity of bridge and improves the durability of bridge. Post tensioning eliminates the use of intermediate supports for long span bridges.";
        }
        else if((method.trim().toLowerCase()).equals("cast in situ post tension girder".trim().toLowerCase())) {
            desc = "Cat-in-situ Post tensioning method of bridge construction is more demanding method because of its durability and applicability to complex bridge curves etc. In this method along with concrete and reinforcement, steel strands or tendons are also used to introduce post tensioning. When the formwork is prepared, strands are arranged with in the reinforcement and concrete is filled. After the hardening of concrete, the strands which have been passed through the concrete are pulled by the jack up to certain tensile force which was pre-determined. Now, the steel stands should be locked. This type of construction increases the load carrying capacity of bridge and improves the durability of bridge. Post tensioning eliminates the use of intermediate supports for long span bridges.";
        }
        else if((method.trim().toLowerCase()).equals("Hollow core slab cast in situ".trim().toLowerCase())) {
            desc = "Pre-stressed concrete hollow-core slabs have really been employed in a number of construction purposes ever since 1950s, include residential and commercial buildings, parking structures, and bridges. The slabs have voids that extend constantly down their length, which aids in reducing dead weight and material costs. Hollow-core slabs are cost-effective, have strong fire resistance and sound insulation capabilities, and may span greater distances with relatively modest depths. Common thicknesses of pre-stressed hollow-core slabs vary from (15 to 25 cm) for lengths of about (9 m). More recently, hollow-core slabs with thicknesses as great as (40 cm) have become produced, with the ability to reach more than (15 m). Hollow core concrete bridges are inexpensive and rapid to build. When compared to typical beam and decking construction project, the cost of a Hollow core bridge not just to compares favorably, but also offers a much faster construction period. To provide a smooth level finished surface, a concrete topping layer is frequently cast in place over the upper surface of hollow-core slabs. The upper layer is usually 2 in. thick. (5 cm) in depth If composite action is produced with the hollow-core sections, the topping may increase the flexural strength, shear strength, and bending stiffness of the slab.";
        }
        return desc;
    }

    public String get_image(String method){
        String img="";
        if((method.trim().toLowerCase()).equals("Precast Span by Span using launching Girder".trim().toLowerCase())) {
            img = "/pics/Precast_Span_by_Span_using_launching_Girder.png";
        }
        else if((method.trim().toLowerCase()).equals("Full Span Launching Method".trim().toLowerCase())) {
            img ="/pics/Full_Span_Launching_Method.png";
        }
        else if((method.trim().toLowerCase()).equals("Free Cantilever precast using lifting frame and formwork".trim().toLowerCase())) {
            img = "/pics/Free_Cantilever_precast_using_lifting_frame_and_formwork.png";
        }
        else if((method.trim().toLowerCase()).equals("Balanced Cantilever cast in situ using two travelers".trim().toLowerCase())) {
            img = "/pics/Balanced_Cantilever_cast_in_situ_using_two_travelers.png";
        }
        else if((method.trim().toLowerCase()).equals("Balanced Cantilever precast using lifting frames".trim().toLowerCase())) {
            img = "/pics/Balanced_Cantilever_precast_using_lifting_frames.png";
        }
        else if((method.trim().toLowerCase()).equals("Precast Incremental launching".trim().toLowerCase())) {
            img = "/pics/Precast_Incremental_launching.png";
        }
        else if((method.trim().toLowerCase()).equals("Cast in Situ segment using formwork supported on ground".trim().toLowerCase())) {
            img = "/pics/Cast_in_Situ_segment_using_formwork_supported_on_ground.png";
        }
        else if((method.trim().toLowerCase()).equals("Reinforced Concrete (RC) cast in situ girder".trim().toLowerCase())) {
            img = "/pics/Reinforced_Concrete_(RC)_cast_in_situ_girder.png";
        }
        else if((method.trim().toLowerCase()).equals("precast post tension girder".trim().toLowerCase())) {
            img = "/pics/precast_post_tension_girder.png";
        }
        else if((method.trim().toLowerCase()).equals("cast in situ post tension girder".trim().toLowerCase())) {
            img = "/pics/cast_in_situ_post_tension_girder.png" ;
        }
        else if((method.trim().toLowerCase()).equals("Hollow core slab cast in situ".trim().toLowerCase())) {
            img = "/pics/Hollow_core_slab_cast_in_situ.png";
        }
        return img;
    }
}
