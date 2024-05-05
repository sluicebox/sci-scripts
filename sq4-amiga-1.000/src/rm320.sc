;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 320)
(include sci.sh)
(use Main)
(use Interface)
(use butte)
(use rmnScript)
(use eRS)
(use RandCycle)
(use MCyc)
(use PolyPath)
(use Polygon)
(use Feature)
(use LoadMany)
(use Sound)
(use Motion)
(use Actor)
(use System)

(public
	rm320 0
)

(local
	local0
	local1
	local2
	local3
	local4
	local5
	local6
	[local7 25] = [5 0 124 82 5 1 116 90 5 2 110 93 5 3 112 95 5 4 112 95 5 5 113 95 -32768]
	[local32 37] = [6 0 295 110 6 1 277 113 6 2 265 118 6 3 258 132 6 4 259 132 6 5 259 132 6 6 259 132 6 7 259 132 6 8 259 132 -32768]
	[local69 17] = [1 0 131 152 1 1 131 150 1 2 131 148 1 0 131 146 -32768]
	[local86 17] = [3 1 135 152 3 2 135 150 3 3 135 148 3 4 135 146 -32768]
)

(procedure (localproc_0 param1 param2 param3 param4 &tmp temp0 temp1) ; UNUSED
	(if (< param1 param3)
		(= temp0 (- param1 1))
		(= temp1 (+ param3 1))
	else
		(= temp0 (- param3 1))
		(= temp1 (- param1 1))
	)
	(= local3 temp0)
	(= local4 param2)
	(= local5 temp1)
	(= local6 param4)
	(= local1 (Graph grSAVE_BOX temp0 (- param2 1) temp1 (+ param4 1) 1))
	(Graph
		grDRAW_LINE
		param1
		param2
		param3
		param4
		(proc0_18 global134 global136 global134)
		-1
		-1
	)
	(Graph grREDRAW_BOX temp0 (- param2 1) temp1 (+ param4 1))
)

(procedure (localproc_1) ; UNUSED
	(Graph grRESTORE_BOX local1)
	(Graph grREDRAW_BOX local3 (- local4 1) local5 (+ local6 1))
)

(procedure (localproc_2)
	(Display 320 13 dsRESTOREPIXELS local2)
)

(instance rm320 of SQRoom
	(properties
		picture 320
		horizon 15
		north 310
	)

	(method (init)
		(LoadMany rsVIEW 0 300)
		(LoadMany rsSOUND 143 51 57 132 133 115 883 884 887 889)
		(gCurRoom
			addObstacle:
				((Polygon new:)
					type: PBarredAccess
					init: 319 189 0 189 0 0 165 0 245 126 218 147 174 145 171 133 142 144 191 158 193 170 297 146 315 132 310 116 294 115 295 110 304 106 298 94 310 90 299 59 303 52 298 49 303 47 308 38 319 29
					yourself:
				)
				((Polygon new:)
					type: PNearestAccess
					init: 319 26 307 33 270 5 272 0 319 0
					yourself:
				)
				((Polygon new:)
					type: PNearestAccess
					init: 200 0 226 29 252 46 271 83 247 123 176 0
					yourself:
				)
		)
		(gLongSong2 number: 133 loop: 1)
		(gLongSong number: 57 flags: 1 loop: -1)
		(if (> (butte policeLanded:) 0)
			(Load rsVIEW 305)
			(Load rsPIC 300)
		else
			(LoadMany rsVIEW 7 5)
		)
		(if (and (== gPrevRoomNum 297) (not (IsFlag 32)))
			(babe2 init: z: 1000)
			(babe3 init: z: 1000)
			(landSFX init:)
			(Load rsSCRIPT 810)
		)
		(self setRegions: 703 setFeatures: theSea theRoom) ; butte
		(if (or (and (== gPrevRoomNum north) (butte egoSwims:)) (== gPrevRoomNum 297))
			(HandsOff)
			(Load rsVIEW 323)
			(butte egoSwims: 0)
			(gEgo
				view: 323
				normal: 0
				loop: 1
				posn:
					(cond
						((< (gEgo x:) 51) 45)
						((> (gEgo x:) 128) 128)
						(else
							(gEgo x:)
						)
					)
					150
			)
			(if (== gPrevRoomNum north)
				(self style: 13)
			)
			(self setScript: swimScript)
		else
			(HandsOff)
			(gEgo illegalBits: -32752)
			(self style: 13 setScript: enterScript)
		)
		(gEgo setPri: 8 init:)
		(super init:)
		(if
			(or
				(== (butte curPolice1Room:) 320)
				(== (butte curPolice2Room:) 320)
			)
			(butte junctioned: 1)
			((ScriptID 703 4) posn: 255 153 init: setScript: copEnters) ; cop
		else
			(butte junctioned: 0)
		)
	)

	(method (doit &tmp temp0)
		(cond
			(script)
			((and (== script fallScript) (== (gEgo edgeHit:) EDGE_BOTTOM)) 0)
			((and (not script) (== (gEgo edgeHit:) EDGE_TOP))
				(HandsOff)
				(gEgo illegalBits: -32768)
				(self setScript: exitScript)
			)
		)
		(super doit:)
		(= temp0 (gEgo onControl: 1))
		(cond
			(script)
			((and (butte junctioned:) (not ((ScriptID 703 4) script:))) ; cop
				(if (== (butte oldPoliceRoom:) 310)
					((ScriptID 703 4) x: 270 y: -5 init:) ; cop
				)
				((ScriptID 703 4) setScript: copEnters) ; cop
			)
			((or (& temp0 $0004) (& temp0 $0040))
				(HandsOff)
				(self setScript: fallScript 0 temp0)
			)
		)
	)
)

(instance fallScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(cond
					((& register $0004)
						(gEgo setPri: 3)
					)
					((& register $0040)
						(gEgo setPri: 3)
					)
				)
				(gCurRoom setScript: (ScriptID 703 1)) ; butteFallScript
				(self dispose:)
			)
		)
	)
)

(instance exitScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo setMotion: MoveTo (gEgo x:) -2 self)
			)
			(1
				(gCurRoom newRoom: (gCurRoom north:))
			)
		)
	)
)

(instance enterScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo
					x:
						(cond
							((< (gEgo x:) 250) 250)
							((> (gEgo x:) 291) 291)
							(else
								(gEgo x:)
							)
						)
					y: 50
				)
				(= cycles 1)
			)
			(1
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance copEnters of Script
	(properties)

	(method (doit)
		(if (and (not (gCurRoom script:)) (== state 0))
			(self cue:)
		)
		(if
			(and
				(not (gCurRoom script:))
				(< ((ScriptID 703 4) distanceTo: gEgo) 80) ; cop
			)
			((ScriptID 703 4) setScript: (ScriptID 703 5)) ; cop, shootEgoScript
			(self dispose:)
		)
		(super doit:)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0 0)
			(1
				((ScriptID 703 4) setCycle: Walk setMotion: MoveTo 300 100 self) ; cop
			)
			(2
				((ScriptID 703 4) ; cop
					setMotion: PolyPath (gEgo x:) (gEgo y:) self
				)
			)
		)
	)
)

(instance swimScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= cycles 1)
			)
			(1
				(gLongSong2 number: 883 loop: -1 vol: 127 flags: 0 play:)
				(gEgo
					illegalBits: 0
					setCycle: Walk
					setLoop: -1
					setMotion: MoveTo 160 154 self
				)
			)
			(2
				(gLongSong2 number: 0 stop:)
				(gEgo
					setLoop: 1
					cel: 0
					setCycle: End
					xStep: 2
					setMotion: MoveTo 185 (gEgo y:) self
				)
			)
			(3
				(NormalEgo 0 0)
				(= seconds 1)
			)
			(4
				(gEgo
					setPri: 8
					xStep: 3
					yStep: 2
					setMotion: MoveTo 205 (gEgo y:) self
				)
			)
			(5
				(cond
					((!= gPrevRoomNum 297)
						(HandsOn)
						(client setScript: 0)
					)
					((not (IsFlag 32))
						(SetFlag 32)
						(gLongSong playBed:)
						(= local0 (gLongSong prevSignal:))
						(while
							(and
								(!= (gLongSong prevSignal:) 10)
								(== (gLongSong prevSignal:) local0)
							)
							(gLongSong check:)
						)
						(gCurRoom setScript: subRiseScript)
					)
					(else
						(HandsOn)
						(client setScript: 0)
					)
				)
			)
		)
	)
)

(instance subRiseScript of rmnScript
	(properties)

	(method (doit)
		(super doit: &rest)
		(if (> state 2)
			(if (> (gEgo x:) 206)
				(HandsOff)
				(gCurRoom setScript: shootScript)
			)
			(if (!= (gEgo y:) 154)
				(HandsOff)
				(gCurRoom setScript: shootScript)
			)
			(if (< (gEgo x:) 204)
				(HandsOff)
				(gCurRoom setScript: enterSubScript)
			)
		)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo setLoop: 1 moveHead: 0 setHeading: 270)
				(babe2 z: 0 setCycle: MCyc @local7)
				(babe3 z: 0 setCycle: MCyc @local32 self)
			)
			(1
				(= cycles 10)
			)
			(2
				(sub
					init:
					setLoop: 1
					setCycle: Fwd
					setMotion: MoveTo 131 154 self
				)
			)
			(3
				(gLongSong2 number: 884 loop: 1 vol: 127 play:)
				(sub setCycle: MCyc @local69)
				(subTop init: setCycle: MCyc @local86 self)
			)
			(4
				(sub setCycle: Fwd)
				(= cycles 10)
			)
			(5
				(hatch
					init:
					x: (subTop x:)
					y: (subTop y:)
					setPri: (+ (subTop priority:) 1)
					setCycle: End self
				)
				(hatchSnd number: 133 loop: 1 init: play:)
			)
			(6
				(babeLeader init: cycleSpeed: 1 setCycle: CT 5 1 self)
			)
			(7
				(babeLeader setCycle: CT 8 1)
				(= cycles 9)
			)
			(8
				(gTheIconBar disable:)
				(= cycles 1)
			)
			(9
				(gCast eachElementDo: #hide)
				(bubble z: 2000)
				(arm init:)
				(theMouth init:)
				(theEyes init:)
				(gCurRoom drawPic: 325 10)
				(= cycles 1)
			)
			(10
				(gTheIconBar enable:)
				(= seconds 2)
			)
			(11
				(arm setCel: 1)
				(= seconds 2)
			)
			(12
				(theEyes setCel: 1)
				(theMouth loop: 2 setCycle: RandCycle 22)
				(self
					save1:
						(proc0_12
							{"You've got a lot of nerve coming back here, Roger Wilco."}
							67
							2
							2
							28
							(proc0_18 global153 global137 global153)
							29
							global129
							30
							1
							70
							315
						)
				)
				(= seconds 10)
			)
			(14
				(theMouth loop: 2 setCycle: RandCycle 22)
				(theEyes setCel: 2)
				(self
					save1:
						(proc0_12
							{"After leaving me the way you did, you male Scum!"}
							67
							2
							2
							28
							(proc0_18 global153 global137 global153)
							29
							global129
							30
							1
							70
							315
						)
				)
				(= seconds 10)
			)
			(16
				(theMouth loop: 2 setCycle: RandCycle 22)
				(theEyes setCel: 2)
				(self
					save1:
						(proc0_12
							{"This is the last woman you'll ever dump on! Right, girls?!"}
							67
							2
							2
							28
							(proc0_18 global153 global137 global153)
							29
							global129
							30
							1
							70
							315
						)
				)
				(= seconds 10)
			)
			(18
				(self
					save1:
						(proc0_12
							{"RIGHT!"}
							67
							3
							160
							28
							global150
							29
							global129
							30
							0
							70
							315
						)
				)
				(= local2
					(proc0_12
						{"RIGHT!"}
						67
						270
						125
						28
						global130
						29
						global129
						30
						0
						70
						48
					)
				)
				(= seconds 10)
			)
			(20
				(theMouth loop: 2 setCycle: RandCycle 22)
				(theEyes setCel: 1)
				(self
					save1:
						(proc0_12
							{"Said ya couldn't be tied down..."}
							67
							2
							2
							28
							(proc0_18 global153 global137 global153)
							29
							global129
							30
							1
							70
							315
						)
				)
				(= seconds 10)
			)
			(22
				(self
					save1:
						(proc0_12
							{"I said that?"}
							67
							48
							155
							28
							global140
							29
							global129
							30
							0
							70
							270
						)
				)
				(= seconds 10)
			)
			(24
				(theMouth loop: 2 setCycle: RandCycle 22)
				(theEyes setCel: 2)
				(self
					save1:
						(proc0_12
							{"You said ya had to be free to roam the galaxy."}
							67
							2
							2
							28
							(proc0_18 global153 global137 global153)
							29
							global129
							30
							1
							70
							315
						)
				)
				(= seconds 10)
			)
			(26
				(self
					save1:
						(proc0_12
							{"Was that me?"}
							67
							48
							155
							28
							global140
							29
							global129
							30
							0
							70
							270
						)
				)
				(= seconds 10)
			)
			(28
				(theMouth loop: 2 setCycle: RandCycle 22)
				(theEyes setCel: 1)
				(self
					save1:
						(proc0_12
							{"You'll be sorrier than you look. We'll see to that!"}
							67
							2
							2
							28
							(proc0_18 global153 global137 global153)
							29
							global129
							30
							1
							70
							315
						)
				)
				(= seconds 10)
			)
			(30
				(self
					save1:
						(proc0_12
							{"YEAH!"}
							67
							3
							160
							28
							global150
							29
							global129
							30
							0
							70
							315
						)
				)
				(= local2
					(proc0_12
						{"YEAH!"}
						67
						270
						125
						28
						global130
						29
						global129
						30
						0
						70
						48
					)
				)
				(= seconds 10)
			)
			(32
				(theMouth loop: 2 setCycle: RandCycle 22)
				(theEyes setCel: 1)
				(self
					save1:
						(proc0_12
							{"Into the sub, fly boy."}
							67
							2
							2
							28
							(proc0_18 global153 global137 global153)
							29
							global129
							30
							1
							70
							315
						)
				)
				(= seconds 10)
			)
			(34
				(gTheIconBar disable:)
				(= cycles 1)
			)
			(35
				(gCast eachElementDo: #show)
				(gCurRoom drawPic: 320 10)
				(babeLeader loop: 0 cel: 0 setPri: 14 posn: 117 144)
				(theMouth dispose:)
				(arm dispose:)
				(theEyes dispose:)
				(= cycles 1)
			)
			(36
				(NormalEgo 2 0 4)
				(AnimateEgoHead 4)
				(gTheIconBar enable:)
				(HandsOn)
			)
			(else
				(theMouth setLoop: 1 setCycle: 0)
				(theEyes setCel: 0)
				(self restore:)
				(localproc_2)
				(= cycles 1)
			)
		)
	)
)

(instance shootScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gLongSong2 number: 887 vol: 127 loop: 1 play:)
				(babeLeader loop: 0 cel: 0 x: 117 y: 144 setCycle: End self)
			)
			(1
				(gLongSong2 number: 889 vol: 127 loop: 1 play:)
				(gEgo normal: 0 view: 321 loop: 1 cel: 0 setCycle: End self)
			)
			(2
				(Animate (gCast elements:) 0)
				(EgoDead 2 21)
			)
		)
	)
)

(instance enterSubScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo
					illegalBits: 0
					setCycle: Walk
					setMotion: PolyPath 179 145
				)
				(= cycles 1)
			)
			(1
				(gEgo
					normal: 0
					view: 321
					loop: 2
					cel: 0
					posn: 179 144
					setPri: 15
					setCycle: End
				)
				(= cycles 7)
			)
			(2
				(landSFX play:)
				(gEgo
					illegalBits: 0
					loop: 3
					cel: 0
					posn: 143 144
					cycleSpeed: 1
					setCycle: End self
				)
			)
			(3
				(gEgo normal: 1 dispose:)
				(babeLeader
					loop: 4
					cel: 0
					posn: 130 144
					setPri: 15
					setCycle: End self
				)
			)
			(4
				(babeLeader dispose:)
				(hatch setCycle: Beg self)
			)
			(5
				(hatchSnd number: 132 play:)
				(hatch dispose:)
				(= cycles 1)
			)
			(6
				(gLongSong number: 51 loop: -1 flags: 1 play:)
				(subTop setCycle: Beg)
				(subTop dispose:)
				(sub setMotion: MoveTo 131 200)
				(= seconds 3)
			)
			(7
				(sub dispose:)
				(= cycles 1)
			)
			(8
				(gCurRoom newRoom: 321)
				(self dispose:)
			)
		)
	)
)

(instance babeLeader of Actor
	(properties
		x 142
		y 122
		description {latex babe leader}
		sightAngle 90
		lookStr {She looks like she might be familiar to you someday. The gun in her hand looks like it could limit the chance of any lasting relationship in the future however.}
		view 321
		loop 7
		priority 15
		signal 16
	)

	(method (doVerb theVerb)
		(switch theVerb
			(3 ; Do
				(Print 320 0) ; "Hey! Would you like your chest cavity to host her spear?"
			)
			(5 ; Talk
				(Print 320 1) ; "The time for talk on your part appears to have passed. Speak now and forever hold your pieces."
			)
			(11 ; Smell
				(Print 320 2) ; "You can bet she smells better than you. Better just speculate on this one or you'll be snorting spear."
			)
			(10 ; Taste
				(Print 320 3) ; "Best just keep your buds packed, Buckwheat. Besides, you should be worried about dying now - not thinking about stuff like that."
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance landSFX of Sound
	(properties
		number 115
		priority 15
	)
)

(instance babe2 of Prop
	(properties
		x 126
		y 92
		description {latex babe}
		lookStr {This one looks committed to helping you find out just how good you'd look on a spit.}
		view 321
		loop 5
	)

	(method (doVerb theVerb)
		(switch theVerb
			(3 ; Do
				(Print 320 4) ; "Hey! You must want to know how you look with convenient handles protruding from each side of your less-than-studly self."
			)
			(5 ; Talk
				(Print 320 1) ; "The time for talk on your part appears to have passed. Speak now and forever hold your pieces."
			)
			(11 ; Smell
				(Print 320 5) ; "This would be an excellent time to keep your nostrils to yourself."
			)
			(10 ; Taste
				(Print 320 6) ; "Gee! Maybe you should walk right on up to her and give it a try."
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance babe3 of Prop
	(properties
		x 298
		y 121
		description {latex babe}
		lookStr {Her speargun is pointed in a direction that eliminates any need for the time consuming act of second thought.}
		view 321
		loop 6
		priority 14
		signal 16
	)

	(method (doVerb theVerb)
		(switch theVerb
			(3 ; Do
				(Print 320 7) ; "Do it and die."
			)
			(5 ; Talk
				(Print 320 8) ; "She looks completely uninterested in conversing with the likes of you."
			)
			(11 ; Smell
				(Print 320 5) ; "This would be an excellent time to keep your nostrils to yourself."
			)
			(10 ; Taste
				(Print 320 9) ; "Yeah! Right!"
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance sub of Actor
	(properties
		x 120
		y 200
		description {submarine}
		sightAngle 90
		lookStr {The submarine has a fairly sporty look to it. The hydrodynamic surfaces give it a distinct appearance different from those fine vessels you've travelled aboard recently.}
		yStep 3
		view 320
		loop 1
		priority 12
		signal 16384
		cycleSpeed 1
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Inventory
				(super doVerb: theVerb)
			)
			(3 ; Do
				(gCurRoom setScript: enterSubScript)
			)
			(11 ; Smell
				(Print 320 10) ; "This isn't a good time for your interesting vessel-sniffing hobby."
			)
			(10 ; Taste
				(Print 320 11) ; "Nah, it's not a good time to slap the old buds on barnacles."
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance subTop of Actor
	(properties
		x 135
		y 154
		description {submarine}
		sightAngle 90
		lookStr {The submarine has a fairly sporty look to it. The hydrodynamic surfaces give it a distinct appearance different from those fine vessels you've travelled aboard recently.}
		view 320
		loop 3
		priority 13
		signal 16400
		cycleSpeed 1
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Inventory
				(super doVerb: theVerb)
			)
			(3 ; Do
				(gCurRoom setScript: enterSubScript)
			)
			(5) ; Talk
			(11 ; Smell
				(Print 320 10) ; "This isn't a good time for your interesting vessel-sniffing hobby."
			)
			(10 ; Taste
				(Print 320 11) ; "Nah, it's not a good time to slap the old buds on barnacles."
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance hatch of Prop
	(properties
		description {hatch}
		sightAngle 90
		lookStr {That hatch looks like the perfect place to have an entry/exit device.}
		view 320
		loop 2
		signal 16384
		cycleSpeed 1
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Inventory
				(super doVerb: theVerb)
			)
			(3 ; Do
				(gCurRoom setScript: enterSubScript)
			)
			(5) ; Talk
			(11 ; Smell
				(Print 320 10) ; "This isn't a good time for your interesting vessel-sniffing hobby."
			)
			(10 ; Taste
				(Print 320 12) ; "Hmm...freshly lubricated."
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance bubble of Prop
	(properties
		x 130
		y 184
		description {bubbles}
		sightAngle 90
		lookStr {Bubbles are churned out by the currently slow moving, nearly surfaced props.}
		view 320
		priority 15
		signal 16
	)
)

(instance arm of Prop
	(properties
		x 171
		y 104
		view 325
	)
)

(instance theMouth of Prop
	(properties
		x 171
		y 60
		view 325
		loop 2
	)
)

(instance theEyes of Prop
	(properties
		x 172
		y 39
		view 325
		loop 3
	)
)

(instance zCode of Code ; UNUSED
	(properties)

	(method (doit param1)
		(param1 z: (- (param1 z:) 1000))
	)
)

(instance theRoom of Feature
	(properties
		nsBottom 200
		nsRight 320
		description {buttes}
		lookStr {Here at the base of the buttes lies the legendary Sea of Estros.__The shimmering crystal-clear water is calm and inviting, giving no hint of the currents that could suck you under fast enough to pull your skin off and leave your insides standing on the shore.__We could show you that, but it would be in bad taste.}
	)

	(method (doVerb theVerb)
		(switch theVerb
			(5 ; Talk
				((ScriptID 703 6) doVerb: theVerb) ; theRoom
			)
			(2 ; Look
				(Print 320 14) ; "Here at the base of the buttes lies the legendary Sea of Estros. The shimmering crystal-clear water is calm and inviting, giving no hint of the currents that could suck you under fast enough to pull your skin off and leave your insides standing on the shore. We could show you that, but it would be in bad taste."
			)
			(else
				(super doVerb:)
			)
		)
	)
)

(instance theSea of Feature
	(properties
		nsBottom 200
		nsRight 320
		description {sea}
		onMeCheck 16
		lookStr {The water here is quite deep.}
	)
)

(instance hatchSnd of Sound
	(properties)
)

