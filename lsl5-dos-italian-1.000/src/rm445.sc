;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 445)
(include sci.sh)
(use Main)
(use eRS)
(use Polygon)
(use Feature)
(use Motion)
(use Inventory)
(use Actor)
(use System)

(public
	rm445 0
)

(instance rm445 of LLRoom
	(properties
		picture 440
		east 450
		west 435
	)

	(method (init)
		(Load rsVIEW 441)
		(gEgo init: normalize:)
		(if (== ((Inv at: 0) owner:) 445) ; Camcorder
			(theDataMan init: stopUpd: approachVerbs: 3) ; Do
		)
		(if (== ((Inv at: 1) owner:) 445) ; Battery_Charger
			(dataPak init: stopUpd: approachVerbs: 3) ; Do
		)
		(if (== ((Inv at: 2) owner:) 445) ; A_Blank_Videotape_a
			(dataPak2 init: stopUpd: approachVerbs: 3) ; Do
		)
		(machine init:)
		(desk init:)
		(computer init:)
		(contraption init:)
		(southBank init:)
		(door init:)
		(books init:)
		(duckF init:)
		(switch gPrevRoomNum
			(west
				(HandsOn)
				(self style: 12)
			)
			(else
				(HandsOn)
				(gEgo posn: 278 104 normalize: edgeHit: EDGE_NONE setHeading: 270)
			)
		)
		(super init:)
		(HandsOn)
		(gCurRoom
			addObstacle:
				((Polygon new:)
					type: PBarredAccess
					init: 0 189 0 140 136 140 161 150 190 150 231 130 251 138 305 125 293 113 263 99 0 99 0 0 319 0 319 189
					yourself:
				)
		)
		(gTheMusic2 number: 436 setLoop: -1 play:)
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(2 ; Look
				(TPrint 445 0) ; "The F.B.I. laboratory is completely deserted. Perhaps they had more experiments than experimenters?"
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance sGetData of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo
					view: 441
					setLoop: (if register 1 else 0)
					setCel: 0
					cycleSpeed: 12
					moveSpeed: 12
					setCycle: CT 2 1 self
				)
			)
			(1
				(switch register
					(0
						(gEgo get: 0) ; Camcorder
						(Points 5 102)
						(theDataMan dispose:)
					)
					(1
						(gEgo get: 1) ; Battery_Charger
						(Points 13 103)
						(dataPak dispose:)
					)
					(2
						(gEgo get: 2) ; A_Blank_Videotape_a
						(Points 13 104)
						(dataPak2 dispose:)
					)
				)
				(gEgo setCycle: End self)
			)
			(2
				(gEgo normalize:)
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance theDataMan of View
	(properties
		x 94
		y 88
		z 13
		description {the DataMan}
		approachX 82
		approachY 99
		lookStr {A tiny electronic display device lies on the counter.}
		view 440
		priority 6
		signal 16
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(3 ; Do
				(HandsOff)
				(gCurRoom setScript: sGetData 0 0)
			)
			(else
				(super doVerb: theVerb invItem)
			)
		)
	)
)

(instance dataPak of View
	(properties
		x 72
		y 88
		z 14
		description {the DataPak}
		approachX 82
		approachY 99
		lookStr {What appears to be some sort of ROM cartridge lies on the counter.}
		view 440
		cel 1
		priority 6
		signal 16
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(3 ; Do
				(HandsOff)
				(gCurRoom setScript: sGetData 0 1)
			)
			(else
				(super doVerb: theVerb invItem)
			)
		)
	)
)

(instance dataPak2 of View
	(properties
		x 72
		y 88
		z 12
		description {the DataPak}
		approachX 82
		approachY 99
		lookStr {What appears to be some sort of ROM cartridge lies on the counter.}
		view 440
		cel 2
		priority 6
		signal 16
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(3 ; Do
				(HandsOff)
				(gCurRoom setScript: sGetData 0 2)
			)
			(else
				(super doVerb: theVerb invItem)
			)
		)
	)
)

(instance door of View
	(properties
		x 282
		y 99
		description {Doctor Phil Hopian's door}
		lookStr {This door leads back into Dr. Phil Hopian's office. After what you just went through, you're in no hurry to go back in there!}
		view 440
		loop 1
		signal 16384
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(3 ; Do
				(TPrint 445 1) ; "It's locked, and you're glad that you can't get in!"
			)
			(5 ; Talk
				(TPrint 445 2) ; "You knock on Dr. Phil Hopian's office door. There is no answer because the good Doctor is off playing golf."
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance machine of Feature
	(properties
		x 215
		y 47
		nsTop -1
		nsLeft 170
		nsBottom 95
		nsRight 261
		description {the machine}
		sightAngle 40
		lookStr {This machine does something, you feel quite certain.}
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(3 ; Do
				(TPrint 445 3) ; "You have not a clue as to what this machine may do!"
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance computer of Feature
	(properties
		x 133
		y 91
		z 33
		nsTop 45
		nsLeft 119
		nsBottom 71
		nsRight 148
		description {the computer}
		sightAngle 40
		lookStr {If only you had paid attention when Larry chattered on and on about his computer. You know nothing about computers and are sure you'll be unable to do anything with it.}
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(3 ; Do
				(TPrint 445 4) ; "You are afraid to touch any computer keyboard that doesn't have MIDI built in!"
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance contraption of Feature
	(properties
		x 114
		y 160
		z 34
		nsTop 115
		nsLeft 94
		nsBottom 137
		nsRight 134
		description {the chemistry set}
		sightAngle 40
		lookStr {This is where the technician made the flatulence powder. (Un)Fortunately, he left his equipment thoroughly clean.}
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(3 ; Do
				(TPrint 445 5) ; "You'll never be able to duplicate the F.B.I.'s "secret formula" of eleven natural herbs and spices."
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance southBank of Feature
	(properties
		x 159
		y 166
		nsTop 144
		nsBottom 189
		nsRight 319
		description {the workbench}
		sightAngle 40
		lookStr {Lots of chemicals, beakers, and junk food wrappers fill this workbench.}
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(3 ; Do
				(if (or (IsFlag 41) (IsFlag 42) (IsFlag 43)) ; fVibratorMan, fBraMan, fFartMan
					(TPrint 445 6) ; "After seeing the results of Commander Twit's earlier experiments, you think it best not to touch anything here unless truly necessary."
				else
					(TPrint 445 7) ; "There's nothing on that bench that could be useful to you in your mission."
				)
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance books of Feature
	(properties
		x 41
		y 88
		z 30
		nsTop 49
		nsLeft 28
		nsBottom 68
		nsRight 55
		description {the books}
		sightAngle 40
		lookStr {These books are filled with Latin phrases. The only Latin phrases you know would get a sailor thrown out of a bar in Tijuana!}
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(3 ; Do
				(TPrint 445 8) ; "You don't have time to read a book now, Patti!"
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance desk of Feature
	(properties
		x 81
		y 87
		z 17
		nsTop 54
		nsBottom 88
		nsRight 162
		description {the desk}
		sightAngle 40
		lookStr {This desk doesn't contain any secret documents; they all were burned in the big fire last week!}
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(3 ; Do
				(TPrint 445 9) ; "You open the drawer and look inside. There's nothing in there but a few charred slips of paper."
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance duckF of Feature
	(properties
		x 43
		y 189
		z 42
		nsTop 134
		nsLeft 23
		nsBottom 160
		nsRight 63
		sightAngle 40
	)

	(method (doVerb theVerb invItem)
		(if (== theVerb 2) ; Look
			(TPrint 445 10) ; "Aw! The technician took his duck with him!"
		else
			(southBank doVerb: theVerb invItem)
		)
	)
)

