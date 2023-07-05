;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 18)
(include sci.sh)
(use Main)
(use Interface)
(use MiracleGro)
(use eRS)
(use PolyPath)
(use Polygon)
(use Feature)
(use LoadMany)
(use Sound)
(use Motion)
(use Actor)
(use System)

(public
	rm018 0
)

(instance rm018 of PQRoom
	(properties
		picture 18
		east 19
		west -1
	)

	(method (init)
		(if (== gDay 1)
			(LoadMany rsVIEW 124 125 2 3)
			(Load rsFONT 500)
		else
			(LoadMany rsVIEW 6 126 123 7)
		)
		(gEgo init:)
		(self setRegions: 891 894) ; station, elevator
		(if (>= global105 18)
			(nightWin init:)
		)
		(gCurRoom
			addObstacle:
				((Polygon new:)
					type: PBarredAccess
					init: 0 0 319 0 319 107 159 107 159 123 143 123 138 126 159 126 159 161 70 161 70 151 2 151 2 157 2 164 319 164 319 189 0 189 0 174
					yourself:
				)
				((Polygon new:)
					type: PBarredAccess
					init: 189 109 319 109 319 161 189 161 189 126 215 126 209 123 189 123
					yourself:
				)
		)
		(sergeantDoor init:)
		(homicideDoor init:)
		(speakers init:)
		(rm18Window init:)
		(elFeat init:)
		(homWindow init:)
		(bulletinBoard approachVerbs: 2 init:) ; Look
		(carpet init:)
		(theRoom init:)
		(switch gPrevRoomNum
			(20
				(SetFlag 218)
				(gEgo view: (if (> gDay 1) 6 else 2) posn: 121 125)
				(sergeantDoor cel: (sergeantDoor lastCel:))
				(HandsOff)
				(self setScript: exitSarg)
			)
			(21
				(gEgo view: (if (> gDay 1) 6 else 2) posn: 243 125)
				(homicideDoor cel: (homicideDoor lastCel:))
				(HandsOff)
				(self setScript: exitHomo)
			)
			(12
				(SetFlag 218)
				(gEgo
					view: (if (> gDay 1) 123 else 124)
					setStep: 5 1
					loop: 2
					posn: 50 140
					heading: 180
				)
				((gEgo head:) cel: 2)
				(HandsOff)
				(self setScript: global111)
			)
			(24
				(SetFlag 218)
				(gEgo
					view: (if (> gDay 1) 123 else 124)
					setStep: 5 1
					loop: 2
					posn: 50 140
					heading: 180
				)
				((gEgo head:) cel: 2)
				(HandsOff)
				(self setScript: global111)
			)
			(15
				(SetFlag 218)
				(gEgo
					view: (if (> gDay 1) 123 else 124)
					loop: 2
					setStep: 5 1
					posn: 50 140
					heading: 180
				)
				((gEgo head:) cel: 2)
				(HandsOff)
				(self setScript: global111)
			)
			(19
				(SetFlag 218)
				(HandsOff)
				(if (< (gEgo y:) 120)
					(gEgo
						view: (if (> gDay 1) 7 else 3)
						setStep: 3 2
						posn: 215 108
					)
					(self posn: 198 108 setScript: (ScriptID 896 1)) ; sWI
				else
					(gEgo
						view: (if (> gDay 1) 123 else 124)
						setStep: 5 1
						posn: 330 164
					)
					(self posn: 310 164 setScript: (ScriptID 896 1)) ; sWI
				)
			)
			(else
				(SetFlag 218)
				(HandsOff)
				(gEgo
					view: (if (> gDay 1) 123 else 124)
					setStep: 5 1
					loop: 2
					posn: 50 140
					setPri: 1
				)
				((gEgo head:) cel: 2)
				(HandsOff)
				(self setScript: afterJimsIntro)
			)
		)
		(egoBluGro
			init:
				egoBluViews
				124
				125
				2
				2
				3
				1
				2
				2
				125
				124
				1
				5
				1
				2
				123
				126
				6
				2
				3
				1
				2
				6
				126
				123
				1
				5
				1
				2
			color: 2
			who: gEgo
		)
		(egoGrnGro
			init:
				egoGrnViews
				3
				125
				2
				0
				3
				3
				1
				2
				125
				3
				3
				3
				1
				1
				7
				126
				6
				0
				3
				3
				1
				6
				126
				7
				3
				3
				3
				1
			color: 4
			who: gEgo
		)
		(rmSound number: 181 loop: -1 flags: 1 play:)
		(super init:)
	)

	(method (doit)
		(cond
			(script 0)
			((& ((egoBluGro who:) onControl: 1) (egoBluGro color:))
				(egoBluGro doit:)
			)
			((& ((egoGrnGro who:) onControl: 1) (egoGrnGro color:))
				(egoGrnGro doit:)
			)
			((& (gEgo onControl: 1) $0008)
				(HandsOff)
				(self x: 215 y: 108 setScript: (ScriptID 896 2) 0 19) ; sWO
			)
		)
		(super doit:)
	)

	(method (dispose)
		(egoBluGro dispose:)
		(egoGrnGro dispose:)
		(DisposeScript 892)
		(super dispose:)
		(DisposeScript 894)
	)

	(method (newRoom newRoomNumber)
		(rmSound fade:)
		(super newRoom: newRoomNumber)
	)
)

(instance egoBluGro of MiracleGro
	(properties)
)

(instance egoBluViews of List
	(properties)
)

(instance egoGrnGro of MiracleGro
	(properties)
)

(instance egoGrnViews of List
	(properties)
)

(instance afterJimsIntro of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= cycles 5)
			)
			(1
				(ShowClock 1)
				(= seconds 4)
			)
			(2
				(ShowClock 0)
				(client setScript: global111)
				(self dispose:)
			)
		)
	)
)

(instance enterSergeant of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo setMotion: PolyPath 141 125 self)
			)
			(1
				(doorOpenSound play:)
				(sergeantDoor setCycle: End self)
			)
			(2
				(gEgo setMotion: MoveTo 121 125 self)
			)
			(3
				(gCurRoom newRoom: 20)
				(self dispose:)
			)
		)
	)
)

(instance exitSarg of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo setMotion: MoveTo 148 125 self)
			)
			(1
				(sergeantDoor setCycle: Beg self)
			)
			(2
				(doorCloseSound play:)
				(gEgo setMotion: MoveTo 160 125 self)
			)
			(3
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance enterHomicide of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo setMotion: PolyPath 215 125 self)
			)
			(1
				(doorOpenSound play:)
				(homicideDoor setCycle: End self)
			)
			(2
				(gEgo setMotion: MoveTo 243 125 self)
			)
			(3
				(gCurRoom newRoom: 21)
				(self dispose:)
			)
		)
	)
)

(instance exitHomo of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo setMotion: MoveTo 215 125 self)
			)
			(1
				(homicideDoor setCycle: Beg self)
			)
			(2
				(doorCloseSound play:)
				(gEgo setMotion: MoveTo 191 125 self)
			)
			(3
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance sergeantDoor of Prop
	(properties
		x 126
		y 128
		description {Sergeant's Door}
		view 135
		signal 16385
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2 ; Look
				(if (== gDay 1)
					(Print 18 0) ; "That's the door to the Sergeant's office. Hey, that's you."
				else
					(Print 18 1) ; "That's the door to the Sergeant's office."
				)
			)
			(3 ; Do
				(HandsOff)
				(gEgo setScript: enterSergeant)
			)
			(4 ; Inventory
				(Print 18 2) ; "That's unnecessary. Just open the door."
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance homicideDoor of Prop
	(properties
		x 223
		y 123
		description {Sergeant's Door}
		lookStr {That's the door to the Homicide office.}
		view 135
		loop 1
		signal 16385
	)

	(method (doVerb theVerb)
		(switch theVerb
			(3 ; Do
				(HandsOff)
				(gEgo setScript: enterHomicide)
			)
			(4 ; Inventory
				(Print 18 2) ; "That's unnecessary. Just open the door."
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance speakers of Feature
	(properties
		x 99
		y 48
		description {intercom}
		onMeCheck 64
		lookStr {The station's public address system.}
	)
)

(instance nightWin of Prop
	(properties
		x 177
		y 93
		description {the window}
		lookStr {The window overlooks scenic downtown Lytton.}
		view 135
		loop 2
		signal 16385
	)

	(method (doVerb theVerb)
		(switch theVerb
			(3 ; Do
				(Print 18 3) ; "You don't need to open the window."
			)
			(4 ; Inventory
				(Print 18 4) ; "That won't get you anywhere."
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance rm18Window of Feature
	(properties
		x 180
		y 83
		description {window}
		onMeCheck 128
		lookStr {The window overlooks scenic downtown Lytton.}
	)

	(method (doVerb theVerb)
		(switch theVerb
			(3 ; Do
				(Print 18 3) ; "You don't need to open the window."
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance homWindow of Feature
	(properties
		x 248
		y 83
		description {window}
		onMeCheck 2048
		lookStr {That's Homicide's hall window.}
	)
)

(instance bulletinBoard of Feature
	(properties
		x 212
		y 78
		description {bulletin board}
		onMeCheck 1024
		approachX 178
		approachY 124
		lookStr {The bulletin board is where people post articles of interest, personal ads, and chinese restaurant business cards.}
	)

	(method (doVerb theVerb)
		(switch theVerb
			(3 ; Do
				(if (== (Random 0 100) 99)
					(Print 18 5) ; "Thanks to the gang of Doug Oldfield, Chris Hoyt, Kim Bowdish and Mike Larson. The programmers who really deserve the main credit for this game."
				else
					(Print 18 6) ; "You look over the bulletin board, but see nothing of interest."
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance carpet of Feature
	(properties
		x 180
		y 83
		description {carpet}
		onMeCheck 16390
		lookStr {Hmm, 'policeman blue'.}
	)
)

(instance theRoom of Feature
	(properties
		lookStr {You're in the hallway of the second level of the Lytton Police Station. Several office doors line the hallway.}
	)
)

(instance elFeat of Feature
	(properties
		description {carpet}
		onMeCheck 8208
		lookStr {You are standing in the elevator.}
	)
)

(instance doorOpenSound of Sound
	(properties
		number 907
	)
)

(instance doorCloseSound of Sound
	(properties
		number 908
	)
)

(instance rmSound of Sound
	(properties)
)

