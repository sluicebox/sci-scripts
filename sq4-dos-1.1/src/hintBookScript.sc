;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 708)
(include sci.sh)
(use Main)
(use Interface)
(use Feature)
(use User)
(use System)

(public
	hintBookScript 0
)

(local
	local0 = -1
	local1
	[local2 4]
	[local6 68] = [{Q.__I'm in a long tunnel with a light visible at the far end.__What should I do?} {Maybe you're having a near-death experience.} {Go for it!} {Haven't you ever seen POLTERGEIST?} {Go into the light, Carol Ann!} {Q.__The wound where the Tentacled Venomite ripped my larynx out keeps getting infected.__Help!} {Have you been picking at it again?__That'll only make it worse.} {Have you found the iodine dispenser?} {Have you found the bottle of peroxide?} {Have you found the salt shaker?} {Mix the iodine into the peroxide and shake some salt into it.__Apply the mixture to the wound. Scrape yourself off the ceiling and get on with the game.} {Q.__I can't seem to find the one-armed man anywhere.} {Ask Bob.} {Who do you think you're fooling?__There's no one-armed man.} {You made it all up, Kimball.__Turn yourself in.} {You can't find the one-armed man, so don't bother looking.} {Okay, okay, he's at the carnival.} {Q.__I can't hear what the two guys at the bar are saying.} {Have you tried typing LISTEN TO MEN?} {Oh, that's right, this is a parserless game.__Click the EAR icon on the men.} {Oh, that's right, there's no EAR icon.__Click the EYE icon on the men.} {That didn't help either, did it?__Did you think it would?} {Just fooling!__There's NO WAY to hear what they're saying.___That'll teach you to read ahead in this hint book!} {Q.__Strawberry is to Sky as Fire Engine is to...} {Blueberry.} {India.} {Good dental hygiene.} {Putting the keycard into the slot in the Drekometer and turning on the viewfinder.} {Q.__I'm in the stupid Time Pod.__Where else can I go?} {Where do you think?} {Someplace where the sun don't shine.} {Ulence Flats if you had the coordinates.} { \0e \0b \0c} {Q.__When I try to splice the vidlink cable to the Venutian Holo-Mat, I end up irradiating myself with deadly plutonium.__What do I do now?} {Good question.__So far, our best solution is to seal yourself in a 50x50ft. block of concrete.} {Then bury yourself at least 1500 feet deep, preferably in an unpopulated, undeveloped area.} {Avoid salt mines or areas where corrosion may breach the concrete.} {Try not to talk to or touch anybody or anything for the next 50,000 years.} {Q.__There's a large, slimy creature blocking the door to the custodian's room in the Magmethean Building.} {That's not even a question.} {Q.__Okay, how do I get past the large, slimy creature blocking the door to the custodian's room in the Magmethean Building?} {What do you think he's waiting for?} {He's undoubtedly waiting for a custodian.} {If he wants a custodian, he probably needs some of that awful pine-scented sawdust.} {GIVE PINE-SCENTED SAWDUST TO CREATURE.} {Q.__I've got the book on running the Suborbital Surrey.___What do I do with it?} {This one's easy.__READ it!} {Make note of any particularly important features and events.} {Did you enjoy the book?__Why or why not?__Explain your answer, giving examples from the text.__Be brief.} {Q.__I'm in a strange room inside the Super Computer.___Scary eyeball-looking things stare at me.__Bio-mechanical bones liven up the area nicely.__How do I get the door open?} {Use the Ovaltine, Roger.} {The Jaws of Life would be most helpful.} {Since neither of these items are in the game try this code: 5-4-3-2-1.} {Since that one didn't work try this one: 69-65-84-76-69.} {Q.__Help!__I've fallen, and I can't get up!} {We'll call your family and the hospital right away, Mrs. Fletcher.} {Q.__I've just started the game, and I've got the ampule of Megahol-256, the wad of chewing tobacco and the open can of Classic DNA.__What now?} {"What now?"__What more did you want?} {Have you tried inhaling the Megahol-256?} {Have you tried chewing the wad of tobacco?} {Have you tried sipping some Classic DNA?} {Gosh, those didn't work.__Put the tobacco and the ampule into the can and shake.__Go to the room with the defibrillator, pour the mixture into it and go three screens to the left.__After the explosion, go back into the room and take the ID chip from the dead guard.___Get into the pod, go to the Horse's Asteroid, fight the security drones and put the ID chip into the 2nd servobooth.___Climb into the SubSystem computer and use the laserrasp to access the vector panel.__Cut the green and lavender wires and step back.__You win.__congratulations!} {Q.__I install the game as per instructions and the game freezes up.__What am I doing wrong?} {Your computer room is too cold.__Make sure your thermostat is set above 32 degrees.} {Q.__Is there a fix available for this?__I walk into the first room and get the message, "Oops!__You tried something we didn't think of."} {Oops!__You asked something we didn't think of.} {Q.__My computer has a 5.25" drive and this game comes in 3.5" only.__How can I get a bigger disk?} {So far, there are no good methods.__Don't fall for ads depicting miracle methods such as "pumps," hormone pills or injections.__Your best bet is to tell yourself that it's not the size that counts.__Oh, wait, did you say DISK?}]
	[local74 12] = [99 0 9 18 26 34 41 49 56 61 63 68]
	local86
	local87 = 1
	local88 = 14
	[local89 14]
	local103 = -1
	local104
)

(procedure (localproc_0 param1 param2 &tmp temp0 temp1)
	(while
		(and
			(= temp0 (FirstNode (param1 elements:)))
			(IsObject (= temp1 (NodeValue temp0)))
		)
		(param2 add: temp1)
		(param1 delete: temp1)
	)
)

(procedure (localproc_1 param1 param2 &tmp temp0 temp1 temp2 temp3 temp4)
	(if (OneOf param1 0 5 11 17 23 28 33 38 40 45 49 54 56 62 64 66)
		(localproc_5 param1 param2 local86)
		(= temp0 0)
	else
		(TextSize @local2 [local6 param1] 30 140)
		(= temp1 (- (+ local86 [local2 0]) 3))
		(= temp2 (- (+ param2 [local2 1]) 3))
		(= temp4 (+ local86 [local2 2]))
		(= temp3 (+ param2 [local2 3]))
		(localproc_3 temp1 temp2 temp4 temp3)
		(Display {\04} dsFONT 30 dsCOORD (- param2 12) (- local86 1))
		(= [local89 (++ local103)]
			((Clone bulletFeat)
				x: (- param2 9)
				y: (+ local86 2)
				nsLeft: (- param2 13)
				nsTop: (- local86 1)
				nsRight: (- param2 5)
				nsBottom: (+ local86 5)
				who: param1
				whoX: param2
				whoY: local86
				yourself:
			)
		)
		([local89 local103] init:)
		(if (& [global163 (/ param1 16)] (>> $8000 (mod param1 16)))
			(localproc_5 param1 param2 local86)
		)
		(= temp0 2)
	)
	(TextSize @local2 [local6 param1] 30 140)
	(+= local86 (+ [local2 2] 3 temp0))
)

(procedure (localproc_2 &tmp temp0 temp1 [temp2 2])
	(Graph grFILL_BOX 11 0 175 157 3 global130 15)
	(Graph grUPDATE_BOX 11 0 175 157 1)
	(Graph grFILL_BOX 11 160 189 317 3 global130 15)
	(Graph grUPDATE_BOX 11 160 189 317 1)
	(for ((= temp0 0)) (< temp0 14) ((++ temp0))
		(if (IsObject [local89 temp0])
			([local89 temp0] dispose:)
		)
		(= [local89 temp0] 0)
	)
	(= local103 -1)
	(if (> local87 9)
		(Format @temp2 708 2 local87) ; "%d"
	else
		(Format @temp2 708 3 local87) ; "%d"
	)
	(Display @temp2 dsFONT 30 dsBACKGROUND global130 dsCOORD 25 3)
	(if (> local87 8)
		(Format @temp2 708 2 (+ local87 1)) ; "%d"
	else
		(Format @temp2 708 3 (+ local87 1)) ; "%d"
	)
	(Display @temp2 dsFONT 30 dsBACKGROUND global130 dsCOORD 310 3)
	(= local86 14)
	(for
		((= temp0 [local74 local87]))
		(< temp0 [local74 (+ local87 1)])
		((++ temp0))
		
		(localproc_1 temp0 14)
	)
	(++ local87)
	(= local86 14)
	(for
		((= temp0 [local74 local87]))
		(< temp0 [local74 (+ local87 1)])
		((++ temp0))
		
		(localproc_1 temp0 174)
	)
)

(procedure (localproc_3 param1 param2 param3 param4)
	(Graph grDRAW_LINE param1 param2 param1 param4 global129 -1 -1)
	(Graph grDRAW_LINE param1 param4 param3 param4 global129 -1 -1)
	(Graph grDRAW_LINE param3 param2 param3 param4 global129 -1 -1)
	(Graph grDRAW_LINE param1 param2 param3 param2 global129 -1 -1)
	(Graph grUPDATE_BOX param1 param2 (+ param3 1) (+ param4 1) 1)
)

(procedure (localproc_4 param1 param2 param3 param4 &tmp temp0 temp1 temp2 temp3)
	(= temp0 (param1 nsTop:))
	(= temp1 (param1 nsLeft:))
	(= temp2 (param1 nsBottom:))
	(= temp3 (param1 nsRight:))
	(localproc_3 temp0 temp1 temp2 temp3)
	(Display param4 dsFONT 30 dsCOORD param2 param3)
)

(procedure (localproc_5 param1 param2 param3)
	(Display [local6 param1] dsFONT 30 dsWIDTH 140 dsCOORD param2 param3)
)

(instance hintBookScript of Script
	(properties)

	(method (doit)
		(if (GameIsRestarting)
			(= start 2)
			(-- local87)
			(self init:)
		)
		(super doit:)
	)

	(method (changeState newState &tmp temp0 temp1)
		(switch (= state newState)
			(0
				(= local87 1)
				(= local86 0)
				(gEgo setMotion: 0)
				(= local1 (User controls:))
				(User canControl: 0)
				(= cycles 2)
			)
			(1
				(= register (gCurRoom picture:))
				(= local0 gOverlays)
				(localproc_0 gAddToPics aList)
				(localproc_0 gFeatures fList)
				(localproc_0 gCast cList)
				(gCurRoom drawPic: 699 30)
				(= cycles 2)
			)
			(2
				(bulletFeat init:)
				(= temp1 (GetPort))
				(Graph grDRAW_LINE 0 159 189 159 global129 -1 -1)
				(Graph grUPDATE_BOX 0 159 190 160 1)
				(Display 708 0 dsFONT 30 dsCOORD 50 3) ; "SQ IV Hint Book"
				(Display 708 0 dsFONT 30 dsCOORD 200 3) ; "SQ IV Hint Book"
				(Display 708 1 dsFONT 30 dsCOORD 5 3) ; "Page"
				(Display 708 1 dsFONT 30 dsCOORD 290 3) ; "Page"
				(SetPort temp1)
				(exitBut init:)
				(nextBut init:)
				(prevBut init:)
				(localproc_4
					exitBut
					(+ (exitBut nsLeft:) 1)
					(+ (exitBut nsTop:) 2)
					{exit}
				)
				(localproc_4
					nextBut
					(+ (nextBut nsLeft:) 1)
					(+ (nextBut nsTop:) 2)
					{next}
				)
				(localproc_4
					prevBut
					(+ (prevBut nsLeft:) 1)
					(+ (prevBut nsTop:) 2)
					{prev}
				)
				(localproc_2)
				(gGame setCursor: ((gInventory curIcon:) cursor:) 1)
			)
			(3
				(= local104 999)
				(self dispose:)
			)
		)
	)

	(method (dispose &tmp temp0)
		(gFeatures release:)
		(gCurRoom drawPic: register 30)
		(if (!= (= gOverlays local0) -1)
			(DrawPic gOverlays 30 0 global40)
		)
		(for ((= temp0 0)) (< temp0 14) ((++ temp0))
			(if (IsObject [local89 temp0])
				([local89 temp0] dispose:)
			)
			(= [local89 temp0] 0)
		)
		(if (== local104 999)
			(localproc_0 aList gAddToPics)
			(localproc_0 fList gFeatures)
			(localproc_0 cList gCast)
			(gAddToPics doit:)
		)
		(aList eachElementDo: #dispose eachElementDo: #delete release: dispose:)
		(fList eachElementDo: #perform fdc release: dispose:)
		(cList eachElementDo: #dispose eachElementDo: #delete dispose:)
		(User canControl: local1)
		(super dispose:)
	)
)

(instance fdc of Code
	(properties)

	(method (doit param1)
		(if (param1 respondsTo: #delete)
			(param1 signal: (& (param1 signal:) $ffdf) dispose: delete:)
		else
			(param1 dispose:)
		)
	)
)

(instance aList of Collect
	(properties)
)

(instance fList of Collect
	(properties)
)

(instance cList of Collect
	(properties)
)

(instance exitBut of Feature
	(properties
		x 14
		y 183
		nsTop 178
		nsLeft 4
		nsBottom 188
		nsRight 24
		description {exit button}
		sightAngle 180
		lookStr {Press this button to put the hint book away.}
	)

	(method (doVerb theVerb &tmp temp0)
		(switch theVerb
			(2 ; Do
				(= temp0 1)
			)
			(3 ; Inventory
				(= temp0 1)
			)
			(else
				(super doVerb: theVerb)
			)
		)
		(if temp0
			(hintBookScript cue:)
		)
	)
)

(instance prevBut of Feature
	(properties
		x 41
		y 183
		nsTop 178
		nsLeft 29
		nsBottom 188
		nsRight 49
		description {previous page button}
		sightAngle 180
		lookStr {Press this button to turn back one page.}
	)

	(method (doVerb theVerb &tmp temp0)
		(switch theVerb
			(2 ; Do
				(= temp0 1)
			)
			(3 ; Inventory
				(= temp0 1)
			)
			(else
				(super doVerb: theVerb)
			)
		)
		(if (and temp0 (> local87 3))
			(-= local87 3)
			(localproc_2)
		)
	)
)

(instance nextBut of Feature
	(properties
		x 54
		y 183
		nsTop 178
		nsLeft 54
		nsBottom 188
		nsRight 74
		description {next page button}
		sightAngle 180
		lookStr {Press this button to turn to the next page.}
	)

	(method (doVerb theVerb &tmp temp0)
		(switch theVerb
			(2 ; Do
				(= temp0 1)
			)
			(3 ; Inventory
				(= temp0 1)
			)
			(else
				(super doVerb: theVerb)
			)
		)
		(if (and temp0 (< local87 10))
			(++ local87)
			(localproc_2)
		)
	)
)

(class BulletFeat of Feature
	(properties
		who 0
		whoX 0
		whoY 0
	)
)

(instance bulletFeat of BulletFeat
	(properties
		description {hint activation button}
		lookStr {Press this with the Reveal-O-Matic Hint Revealer and a hint will be revealed.}
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(2 ; Do
				(Print 708 4) ; "You'll need the Reveal-O-Matic Hint Revealer."
			)
			(3 ; Inventory
				(cond
					((!= invItem 9) ; pen
						(super doVerb: theVerb invItem)
					)
					((> global168 100)
						(Print 708 5) ; "Sorry. Your Reveal-O-Matic seems to have exhausted its power supply. You'll have to contact the now defunct supplier for a replacement."
					)
					((& [global163 (/ who 16)] (>> $8000 (mod who 16))) 0)
					(else
						(|= [global163 (/ who 16)] (>> $8000 (mod who 16)))
						(localproc_5 who whoX whoY)
						(if (== who 32)
							(Animate (gCast elements:) 0)
							(Print 708 6) ; "Oh, great! Only half the answer showed! It must be a defective hint module."
						)
						(++ global168)
					)
				)
			)
			(else
				(super doVerb: theVerb invItem)
			)
		)
	)
)

