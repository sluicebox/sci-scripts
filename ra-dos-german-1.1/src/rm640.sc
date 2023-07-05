;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 640)
(include sci.sh)
(use Main)
(use Door)
(use eRS)
(use Inset)
(use PolyPath)
(use Feature)
(use ForwardCounter)
(use LoadMany)
(use Timer)
(use Sound)
(use Motion)
(use Actor)
(use System)

(public
	rm640 0
	westDoor 4
)

(local
	local0
	local1
	local2
	local3
)

(instance rm640 of LBRoom
	(properties
		noun 29
		picture 640
		west 610
		vanishingY 85
	)

	(method (init)
		(gEgo init: normalize: 831 setScale: 155)
		(self setRegions: 90) ; MuseumRgn
		(switch gPrevRoomNum
			(west
				(gEgo edgeHit: EDGE_NONE setHeading: 90)
			)
			(else
				(gEgo wearingGown: 1 posn: 160 160)
				(SetFlag 4)
				(gGame handsOn:)
			)
		)
		(super init:)
		(LoadMany rsSOUND 640 641 643)
		(westDoor init:)
		(if (not (IsFlag 4))
			(Load rsVIEW 646)
			(cond
				((not (TimeCheck $b102)) ; has 11:15 pm occurred?
					(Load rsPIC 645)
					(gGameMusic2 number: 551 flags: 1 loop: -1 play:)
					(ernie_Yvette init: cycleSpeed: 42 setCycle: Fwd)
					(SetFlag 18)
					(toolBoxClosed init:)
					(desk init:)
					(underDesk init:)
					(intercom init:)
					(mopBucket init:)
					(bear init:)
					(skeleton init:)
					(brooms init:)
					(block init:)
					(blotchOnWall init:)
					(light init:)
					(nautilus init:)
					(nefertiti init:)
					(squirrel init:)
					(heads init:)
					(beam1 init:)
					(beam2 init:)
					(leftStuff init:)
					(rightStuff init:)
					(rightmostStuff init:)
					(blender init:)
					(snakeLasso approachVerbs: 4 1 8 init:) ; Do, Look, magnifier
				)
				((not (TimeCheck $1310)) ; has 1:45 am occurred?
					(gGameMusic2 number: 642 flags: 1 loop: -1 play:)
					(if (or (IsFlag 15) (Random 0 1))
						(LoadMany rsVIEW 642 643)
						(toolBoxClosed init: approachVerbs: 4) ; Do
						(toolBoxOpen init: approachVerbs: 4 1) ; Do, Look
						(if (not (IsFlag 19))
							(toolBoxOpen hide:)
						)
						(if (not (gEgo has: 19)) ; snakeLasso
							(snakeLasso approachVerbs: 4 1 8 init:) ; Do, Look, magnifier
						)
						(desk init: approachVerbs: 1 8) ; Look, magnifier
						(underDesk init: approachVerbs: 1 8) ; Look, magnifier
						(intercom init:)
						(mopBucket init:)
						(bear init:)
						(skeleton init:)
						(brooms init:)
						(block init:)
						(blotchOnWall
							setCel:
								(if (IsFlag 119)
									(blotchOnWall lastCel:)
								else
									0
								)
							approachVerbs: 4 ; Do
							init:
						)
						(light init:)
						(nautilus init:)
						(nefertiti init:)
						(squirrel init:)
						(heads init:)
						(beam1 init:)
						(beam2 init:)
						(leftStuff init:)
						(rightStuff init:)
						(rightmostStuff init:)
						(blender init:)
					else
						((ScriptID 31 0) ; aErnie
							init:
							view: 824
							room: gCurRoomNum
							setPri: 9
							posn: 108 140
							setHeading: 90
						)
						(SetFlag 18)
						(= local0 1)
					)
				)
				(else
					(Load rsPIC 645)
					(gGameMusic2 number: 551 flags: 1 loop: -1 play:)
					(ernie_Yvette init: setLoop: 1 cycleSpeed: 42 setCycle: Fwd)
					(SetFlag 18)
				)
			)
		else
			(LoadMany rsVIEW 642 643)
			(gGameMusic2 number: 642 flags: 1 loop: -1 play:)
			(toolBoxClosed init: approachVerbs: 4) ; Do
			(toolBoxOpen init: approachVerbs: 4 1) ; Do, Look
			(if (not (IsFlag 19))
				(toolBoxOpen hide:)
			)
			(desk init: approachVerbs: 1 8) ; Look, magnifier
			(underDesk init: approachVerbs: 1 8) ; Look, magnifier
			(if (not (gEgo has: 19)) ; snakeLasso
				(snakeLasso approachVerbs: 4 1 8 init:) ; Do, Look, magnifier
			)
			(intercom init:)
			(mopBucket init:)
			(bear init:)
			(skeleton init:)
			(brooms init:)
			(block init:)
			(blotchOnWall
				setCel:
					(if (IsFlag 119)
						(blotchOnWall lastCel:)
					else
						0
					)
				approachVerbs: 4 ; Do
				init:
			)
			(light init:)
			(nautilus init:)
			(nefertiti init:)
			(squirrel init:)
			(heads init:)
			(beam1 init:)
			(beam2 init:)
			(leftStuff init:)
			(rightStuff init:)
			(rightmostStuff init:)
			(blender init:)
		)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(3 ; Walk
				(if local3
					(roomActions doVerb:)
				else
					(gCurRoom setScript: sKickOut)
				)
			)
			(else
				(if local3
					(roomActions doVerb:)
				else
					(super doVerb: theVerb)
				)
			)
		)
	)

	(method (cue)
		(if (or script inset (westDoor cel:))
			(ernieTimer setReal: self 10)
		else
			(gCurRoom setScript: sErnieKickOut)
		)
	)

	(method (dispose)
		(if (gWalkHandler contains: gCurRoom)
			(gWalkHandler delete: gCurRoom)
		)
		(if (not (IsFlag 18))
			(SetFlag 15)
		else
			(ClearFlag 15)
		)
		(ernieTimer dispose: delete:)
		(gGameMusic2 fade:)
		(super dispose:)
	)
)

(instance sEnterErnie1 of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo setHeading: 46)
				(ernie_Yvette setCycle: ForwardCounter 2 self)
			)
			(1
				(gCast eachElementDo: #hide)
				(gCurRoom drawPic: 645 9)
				(= seconds 4)
			)
			(2
				(gCurRoom drawPic: 640 9)
				(gCast eachElementDo: #show)
				(= ticks 90)
			)
			(3
				(ernie_Yvette
					setLoop: 2
					setCel: 0
					cycleSpeed: 12
					setCycle: End self
				)
			)
			(4
				(gMessager say: 27 0 1) ; "Sacre bleu!"
				(= cycles 1)
			)
			(5
				(gWalkHandler addToFront: gCurRoom)
				(gCast eachElementDo: #actions roomActions)
				(westDoor actions: 0)
				(gFeatures eachElementDo: #actions roomActions)
				(= local3 1)
				(gGame handsOn:)
				(= seconds 15)
			)
			(6
				(gCurRoom setScript: sKickOut)
				(self dispose:)
			)
		)
	)
)

(instance sEnterErnie2 of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo setHeading: 0)
				(ernie_Yvette setCycle: ForwardCounter 2 self)
			)
			(1
				(gCast eachElementDo: #hide)
				(gCurRoom drawPic: 645 9)
				(= seconds 4)
			)
			(2
				(gCurRoom drawPic: 640 9)
				(gCast eachElementDo: #show)
				(= ticks 90)
			)
			(3
				(ernie_Yvette
					setLoop: 2
					setCel: 0
					cycleSpeed: 12
					setCycle: End self
				)
			)
			(4
				(gMessager say: 27 0 2) ; "Am I going to have to spank you? AMSCRAY!"
				(= ticks 60)
			)
			(5
				(gEgo setHeading: 180 self)
			)
			(6
				(gEgo
					view: 646
					setLoop: 0
					setCel: 0
					cycleSpeed: 12
					setCycle: End self
				)
			)
			(7
				(gEgo normalize: 831 loop: 2)
				(westDoor doVerb: 4)
				(self dispose:)
			)
		)
	)
)

(instance sErnieAloneKick of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				((ScriptID 31 0) setLoop: 7 setCel: 4) ; aErnie
				(= cycles 4)
			)
			(1
				((ScriptID 31 0) setCel: 2) ; aErnie
				(= cycles 1)
			)
			(2
				(if (Random 0 1)
					(gMessager say: 27 0 3) ; "Can't a man have any privacy in his own office? I've got a lot of problems right now, so I'd appreciate it if you'd go pester someone else."
				else
					(gMessager say: 27 0 6) ; "Miss Bow, I've got a lot of problems right now. Please leave me alone."
				)
				(= ticks 60)
			)
			(3
				(gEgo setHeading: 180 self)
			)
			(4
				(gEgo
					view: 646
					setLoop: 0
					setCel: 0
					cycleSpeed: 12
					setCycle: End self
				)
			)
			(5
				(gEgo normalize: 831 loop: 2)
				(SetFlag 18)
				(westDoor doVerb: 4)
				(self dispose:)
			)
		)
	)
)

(instance sErnieAloneAsk of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				((ScriptID 31 0) setLoop: 7 setCel: 4) ; aErnie
				(= cycles 4)
			)
			(1
				((ScriptID 31 0) setCel: 2) ; aErnie
				(= cycles 1)
			)
			(2
				(gMessager say: 30) ; "Something I can do for you, Miss Bow?"
				(= cycles 1)
			)
			(3
				(gWalkHandler addToFront: gCurRoom)
				(gCast eachElementDo: #actions roomActions)
				(westDoor actions: 0)
				((ScriptID 31 0) actions: ernieActions) ; aErnie
				(gFeatures eachElementDo: #actions roomActions)
				(= local3 1)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sErnieKickOut of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				((ScriptID 31 0) ; aErnie
					init:
					view: 824
					room: gCurRoomNum
					posn: (westDoor moveToX:) (westDoor moveToY:)
					setHeading: 90
				)
				(westDoor open:)
			)
			(1
				(if (and (< (gEgo x:) 127) (< (gEgo y:) 165))
					(gEgo setMotion: PolyPath 124 160 self)
				else
					(= cycles 1)
				)
			)
			(2
				(Face
					gEgo
					(+ (westDoor approachX:) 30)
					(westDoor approachY:)
				)
				((ScriptID 31 0) ; aErnie
					setMotion:
						PolyPath
						(+ (westDoor approachX:) 30)
						(westDoor approachY:)
						self
				)
			)
			(3
				(Face (ScriptID 31 0) gEgo) ; aErnie
				(westDoor close:)
			)
			(4
				(cond
					((IsFlag 96)
						(gMessager say: 27 0 10) ; "MISS BOW! Do I need to call SECURITY to get you out of here? AMSCRAY!"
					)
					((IsFlag 95)
						(gMessager say: 27 0 9) ; "Miss Bow! I've warned you before! This is my PRIVATE office! Understand?"
						(SetFlag 96)
					)
					(else
						(gMessager say: 27 0 8) ; "This is a private office, Miss Bow. Please leave."
						(SetFlag 95)
					)
				)
				(= cycles 1)
			)
			(5
				(gEgo
					setMotion:
						PolyPath
						(westDoor approachX:)
						(westDoor approachY:)
						self
				)
			)
			(6
				(SetFlag 18)
				(westDoor doVerb: 4)
				(self dispose:)
			)
		)
	)
)

(instance sKickOut of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo setHeading: 0)
				(= cycles 1)
			)
			(1
				(if local2
					(gMessager say: 27 0 6) ; "Miss Bow, I've got a lot of problems right now. Please leave me alone."
				else
					(gMessager say: 27 0 4) ; "Are you deaf? Read my lips! Get OUT!"
				)
				(= ticks 60)
			)
			(2
				(gEgo setHeading: 180 self)
			)
			(3
				(gEgo
					view: 646
					setLoop: 0
					setCel: 0
					cycleSpeed: 12
					setCycle: End self
				)
			)
			(4
				(gEgo normalize: 831 loop: 2)
				(westDoor doVerb: 4)
				(SetFlag 18)
				(self dispose:)
			)
		)
	)
)

(instance sPlayIntercom of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= seconds 3)
			)
			(1
				(gMessager say: 4 0 5) ; "The intercom crackles and you hear:"
				(= cycles 1)
			)
			(2
				(SetFlag 17)
				(self dispose:)
			)
		)
	)
)

(instance sGetWireCutters of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo
					view: 642
					setLoop: 0
					setCel: 0
					cycleSpeed: 12
					setCycle: End self
				)
			)
			(1
				(gEgo setLoop: 1 setCel: 0 setCycle: End self)
			)
			(2
				(gEgo setCycle: Beg self)
			)
			(3
				(gEgo
					setLoop: 0
					setCel: (gEgo lastCel:)
					setCycle: Beg self
				)
			)
			(4
				(gEgo get: 10 normalize: 831 loop: 1) ; wireCutters
				((ScriptID 21 0) doit: 779) ; addCluesCode, Wire Cutters
				(gGame points: 1 145)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sLookLasso of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo setHeading: 270 self)
			)
			(1
				(gEgo
					view: 643
					setLoop: 0
					setCel: 0
					cycleSpeed: 12
					setCycle: End self
				)
			)
			(2
				(= ticks 60)
			)
			(3
				(gEgo setCycle: Beg self)
			)
			(4
				(if (gEgo has: 19) ; snakeLasso
					(gMessager say: 24 1) ; "You see lots of dust. In fact, it looks like a colony of dust bunnies. The museum is currently financing a study of the mating habits and courtship rituals of the American Dust Bunny, Dustlepus Domesticus."
				else
					(gCurRoom setInset: inSnakeLasso)
				)
				(gEgo normalize: 831 loop: 1)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sGetLasso of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo
					view: 643
					setLoop: 3
					setCel: 0
					cycleSpeed: 12
					setCycle: End self
				)
			)
			(1
				(snakeLasso dispose:)
				(= ticks 30)
			)
			(2
				(gEgo setCycle: Beg self)
			)
			(3
				(gEgo get: 19 normalize: 831 loop: 1) ; snakeLasso
				((ScriptID 21 0) doit: 788) ; addCluesCode, Snake Lasso
				(gGame points: 1 141)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sLookWireCutters of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo setMotion: PolyPath 32 172 self)
			)
			(1
				(gCurRoom setInset: inWireCutter)
				(self dispose:)
			)
		)
	)
)

(instance sBlotchTime of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo
					view: 640
					setLoop: 7
					setCel: 0
					cycleSpeed: 12
					setCycle: End self
				)
			)
			(1
				(= ticks 20)
			)
			(2
				(gEgo setCycle: Beg)
				(blotchOnWall setCycle: End self)
				(sFX number: 558 loop: 1 flags: 5 play:)
			)
			(3
				(sFX number: 721 loop: -1 flags: 5 play:)
				(SetFlag 119)
				(= ticks 180)
			)
			(4
				(sFX stop:)
				(= cycles 1)
			)
			(5
				(gEgo normalize: 831 loop: 1)
				(gMessager say: 10 4 11) ; "When you push the button, you hear a sliding noise off in the distance, clearly originating outside of this room."
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance blotchOnWall of Prop
	(properties
		x 54
		y 103
		noun 10
		approachX 66
		approachY 145
		view 640
		loop 6
	)

	(method (doVerb theVerb)
		(switch theVerb
			(1 ; Look
				(if (IsFlag 119)
					(gMessager say: 10 1 12) ; "A cursory glance reveals that this large button on the wall is depressed."
				else
					(gMessager say: 10 1 11) ; "This appears to be a large button on the wall."
				)
			)
			(4 ; Do
				(if (IsFlag 119)
					(gMessager say: 10 4 12) ; "The button is still depressed from the last time you pushed it."
				else
					(gCurRoom setScript: sBlotchTime)
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance ernie_Yvette of Prop
	(properties
		name {ernie&Yvette}
		x 113
		y 143
		view 641
		signal 16385
		cycleSpeed 12
	)
)

(instance roomActions of Actions
	(properties)

	(method (doVerb)
		(if local1
			(gMessager say: 30 0 7) ; "I'm sorry, Miss Bow, but I'm kinda busy right now. Is there something I can help you with? If not, I've got work to do."
			(= local1 0)
			(= local2 1)
		else
			(gCurRoom setScript: sKickOut)
		)
	)
)

(instance ernieActions of Actions
	(properties)

	(method (doVerb theVerb)
		(switch theVerb
			(1 ; Look
				(gMessager say: 1 1 24 0 0 1893) ; "What are you looking at?"
			)
			(4 ; Do
				(gMessager say: 1 4 24 0 0 1893) ; "Don't touch me, lady."
			)
			(2 ; Talk
				(gMessager say: 1 2 24 0 0 1893) ; "Hi, Mr. Leach. Can you let me out of this museum? I don't like it in here. People keep dying."
			)
			(else 0)
		)
	)
)

(instance westDoor of Door
	(properties
		x 38
		y 94
		noun 1
		approachX 70
		approachY 152
		view 640
		loop 5
		priority 10
		signal 16
		entranceTo 610
		moveToX 12
		moveToY 143
		enterType 0
		exitType 0
	)

	(method (createPoly)
		(super createPoly: 13 150 40 138 47 145 22 155)
	)

	(method (cue)
		(if (== (gCurRoom script:) sErnieKickOut)
			(if (== state 1)
				(gAltPolys delete: doorPoly)
			)
			(sErnieKickOut cue:)
		else
			(super cue:)
			(if (== state 0)
				(gTheIconBar enable: 7)
				(cond
					((IsFlag 4)
						(if (and (not (IsFlag 17)) (not (IsFlag 22)))
							(gCurRoom setScript: sPlayIntercom)
						)
					)
					((not (TimeCheck $b102)) ; has 11:15 pm occurred?
						(gCurRoom setScript: sEnterErnie1)
					)
					((not (TimeCheck $c304)) ; has 12:45 am occurred?
						(if local0
							(gCurRoom setScript: sErnieAloneKick)
						else
							(ernieTimer
								setReal: gCurRoom (if (IsFlag 96) 30 else 60)
							)
							(if (and (not (IsFlag 17)) (not (IsFlag 22)))
								(gCurRoom setScript: sPlayIntercom)
							)
						)
					)
					((not (TimeCheck $1310)) ; has 1:45 am occurred?
						(if local0
							(= local1 1)
							(gCurRoom setScript: sErnieAloneAsk)
						else
							(ernieTimer
								setReal: gCurRoom (if (IsFlag 96) 30 else 60)
							)
							(if (and (not (IsFlag 17)) (not (IsFlag 22)))
								(gCurRoom setScript: sPlayIntercom)
							)
						)
					)
					(else
						(gCurRoom setScript: sEnterErnie2)
					)
				)
			)
		)
	)
)

(instance toolBoxOpen of View
	(properties
		x 1
		y 150
		noun 2
		approachX 32
		approachY 172
		view 640
		priority 13
		signal 17
	)

	(method (doVerb theVerb)
		(switch theVerb
			(1 ; Look
				(if (gEgo has: 10) ; wireCutters
					(super doVerb: theVerb)
				else
					(gCurRoom setInset: inWireCutter)
				)
			)
			(4 ; Do
				(self hide:)
				(ClearFlag 19)
				(sFX number: 641 loop: 1 flags: 5 play:)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance snakeLasso of View
	(properties
		x 118
		y 140
		approachX 136
		approachY 143
		view 640
		loop 8
	)

	(method (doVerb theVerb)
		(switch theVerb
			(1 ; Look
				(if (self actions:)
					0
				else
					(gCurRoom setScript: sLookLasso)
				)
			)
			(8 ; magnifier
				(self doVerb: 1)
			)
			(4 ; Do
				(self doVerb: 1)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance inWireCutter of Inset
	(properties
		view 640
		loop 4
		y 133
		disposeNotOnMe 1
		noun 22
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(gCurRoom setScript: sGetWireCutters)
				(self dispose:)
			)
			(1 ; Look
				(gMessager say: 38 1 0 0 0 15) ; "A pair of heavy-duty wire cutters."
			)
			(8 ; magnifier
				(gMessager say: 38 8 0 0 0 15) ; "There's a bit of rust on the wire cutters, as well as an odd bit of beige coat fabric."
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance inSnakeLasso of Inset
	(properties
		view 640
		loop 1
		x 81
		y 116
		disposeNotOnMe 1
		noun 23
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(gCurRoom setScript: sGetLasso)
				(self dispose:)
			)
			(1 ; Look
				(gMessager say: 32 1 0 0 0 15) ; "This curious device is a lasso at the end of a pole, used for the humane capture of snakes in the wild...or wild snakes...or something like that."
			)
			(8 ; magnifier
				(gMessager say: 32 8 0 0 0 15) ; "It's inscribed with the words: "ACME SNAKE LASSO""
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance inVatBook of Inset
	(properties
		view 640
		loop 2
		x 53
		y 100
		disposeNotOnMe 1
		noun 25
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(gCurRoom setInset: inVatBookOpen)
			)
			(8 ; magnifier
				(gMessager say: 25 1) ; "Ernie's index to the stored items in the alcohol vats."
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance inVatBookOpen of Inset
	(properties
		view 640
		loop 3
		x 53
		y 100
		disposeNotOnMe 1
		noun 26
	)

	(method (doVerb theVerb)
		(switch theVerb
			(8 ; magnifier
				(gMessager say: 26 1) ; "CURRENT VAT CONTENTS---ALCOHOLIC PRESERVATION LAB 1  Koala Bears       2  Turtles 3  Snakes          4  Hippo 5  Ground Sloth      6  Skunks 7  Loch Ness Monster 8  Ostrich 9  Lemmings       10 Unicorn 11 Creature from the Black Lagoon 12 Rats        13 Warthogs 14 King Edward of Daventry"
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance toolBoxClosed of Feature
	(properties
		x 15
		y 163
		noun 2
		nsTop 156
		nsLeft 5
		nsBottom 170
		nsRight 25
		sightAngle 40
		approachX 32
		approachY 172
	)

	(method (doVerb theVerb)
		(switch theVerb
			(1 ; Look
				(if (and (IsFlag 19) (not (gEgo has: 10))) ; wireCutters
					(gCurRoom setScript: sLookWireCutters)
				else
					(super doVerb: theVerb)
				)
			)
			(4 ; Do
				(if (IsFlag 19)
					(toolBoxOpen hide:)
					(ClearFlag 19)
					(sFX number: 641 loop: 1 flags: 5 play:)
				else
					(toolBoxOpen show: stopUpd:)
					(SetFlag 19)
					(sFX number: 640 loop: 1 flags: 5 play:)
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance desk of Feature
	(properties
		x 79
		y 134
		noun 3
		nsTop 123
		nsLeft 43
		nsBottom 145
		nsRight 116
		sightAngle 40
		approachX 79
		approachY 156
	)

	(method (doVerb theVerb)
		(switch theVerb
			(1 ; Look
				(if (self actions:)
					0
				else
					(gCurRoom setInset: inVatBook)
				)
			)
			(8 ; magnifier
				(self doVerb: 1)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance underDesk of Feature
	(properties
		x 80
		y 144
		noun 24
		nsTop 136
		nsLeft 46
		nsBottom 147
		nsRight 115
		approachX 136
		approachY 143
	)

	(method (doVerb theVerb)
		(switch theVerb
			(1 ; Look
				(if (self actions:)
					0
				else
					(gCurRoom setScript: sLookLasso)
				)
			)
			(8 ; magnifier
				(self doVerb: 1)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance intercom of Feature
	(properties
		x 54
		y 122
		noun 4
		nsTop 119
		nsLeft 47
		nsBottom 126
		nsRight 62
		sightAngle 40
	)
)

(instance mopBucket of Feature
	(properties
		x 238
		y 133
		noun 5
		nsTop 108
		nsLeft 231
		nsBottom 158
		nsRight 246
		sightAngle 40
	)
)

(instance bear of Feature
	(properties
		x 285
		y 146
		noun 6
		nsTop 104
		nsLeft 251
		nsBottom 189
		nsRight 319
		sightAngle 40
		onMeCheck 4
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(sFX number: 643 loop: 1 flags: 1 play:)
				(gMessager say: 6 4) ; "Grrrr."
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance skeleton of Feature
	(properties
		x 199
		y 154
		noun 7
		nsTop 119
		nsLeft 166
		nsBottom 189
		nsRight 233
		sightAngle 40
		onMeCheck 2
	)
)

(instance brooms of Feature
	(properties
		x 8
		y 118
		noun 8
		nsTop 91
		nsBottom 146
		nsRight 16
		sightAngle 40
	)
)

(instance block of Feature
	(properties
		x 235
		y 172
		noun 9
		nsTop 156
		nsLeft 203
		nsBottom 189
		nsRight 268
		sightAngle 40
		onMeCheck 8
	)
)

(instance light of Feature
	(properties
		x 151
		y 80
		noun 11
		nsTop 74
		nsLeft 142
		nsBottom 86
		nsRight 160
		sightAngle 40
		onMeCheck 16
	)
)

(instance nautilus of Feature
	(properties
		x 140
		y 121
		noun 12
		nsTop 111
		nsLeft 133
		nsBottom 132
		nsRight 147
		sightAngle 40
	)
)

(instance nefertiti of Feature
	(properties
		x 196
		y 183
		z 100
		noun 21
		nsTop 73
		nsLeft 184
		nsBottom 93
		nsRight 208
		sightAngle 40
	)
)

(instance squirrel of Feature
	(properties
		x 299
		y 32
		noun 14
		nsTop 11
		nsLeft 279
		nsBottom 54
		nsRight 319
		sightAngle 40
	)
)

(instance heads of Feature
	(properties
		x 299
		y 81
		noun 15
		nsTop 56
		nsLeft 279
		nsBottom 107
		nsRight 319
		sightAngle 40
	)
)

(instance beam1 of Feature
	(properties
		x 138
		y 16
		noun 16
		nsTop 10
		nsBottom 22
		nsRight 276
		sightAngle 40
	)
)

(instance beam2 of Feature
	(properties
		x 142
		y 51
		noun 17
		nsTop 46
		nsLeft 49
		nsBottom 56
		nsRight 235
		sightAngle 40
	)
)

(instance leftStuff of Feature
	(properties
		x 114
		y 96
		noun 18
		nsTop 74
		nsLeft 87
		nsBottom 119
		nsRight 142
		sightAngle 40
	)
)

(instance rightStuff of Feature
	(properties
		x 184
		y 95
		noun 19
		nsTop 72
		nsLeft 159
		nsBottom 118
		nsRight 209
		sightAngle 40
	)
)

(instance rightmostStuff of Feature
	(properties
		x 246
		y 87
		noun 20
		nsTop 30
		nsLeft 210
		nsBottom 107
		nsRight 279
		sightAngle 40
		onMeCheck 32
	)
)

(instance blender of Feature
	(properties
		y 97
		noun 28
		nsTop 75
		nsLeft 97
		nsBottom 95
		nsRight 109
		sightAngle 40
	)
)

(instance ernieTimer of Timer
	(properties)
)

(instance sFX of Sound
	(properties
		flags 1
	)
)

