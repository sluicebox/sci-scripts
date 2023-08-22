;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 320)
(include sci.sh)
(use Main)
(use butte)
(use eRS)
(use Sq4Narrator)
(use Sq4Feature)
(use MCyc)
(use PolyPath)
(use Polygon)
(use LoadMany)
(use Sound)
(use Motion)
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
	(Graph grDRAW_LINE param1 param2 param3 param4 (proc0_18 global134 global136) -1 -1)
	(Graph grREDRAW_BOX temp0 (- param2 1) temp1 (+ param4 1))
)

(procedure (localproc_1) ; UNUSED
	(Graph grRESTORE_BOX local1)
	(Graph grREDRAW_BOX local3 (- local4 1) local5 (+ local6 1))
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
		(self setRegions: 703) ; butte
		(theSea init:)
		(theRoom init:)
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
					((ScriptID 703 4) posn: 270 -5 init:) ; cop
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
				(= cycles 30)
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
						(gLongSong play:)
						(= seconds 3)
					)
					(else
						(HandsOn)
						(client setScript: 0)
					)
				)
			)
			(6
				(gCurRoom setScript: subRiseScript)
			)
		)
	)
)

(instance subRiseScript of Script
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
				(gEgo moveHead: 0 setHeading: 270)
				(babe2 z: 0 setCycle: MCyc @local7)
				(babe3 z: 0 setCycle: MCyc @local32 self)
			)
			(1
				(= seconds 4)
			)
			(2
				(sub
					setLoop: 1
					setCycle: Fwd
					init:
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
				(= seconds 4)
			)
			(5
				(hatch
					init:
					x: (subTop x:)
					y: (subTop y:)
					setPri: (+ (subTop priority:) 1)
					setCycle: End
				)
				(hatchSnd number: 133 loop: 1 init: play:)
				(= seconds 3)
			)
			(6
				(babeLeader init: cycleSpeed: 12 setCycle: CT 5 1 self)
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
				(bubble z: 2000)
				(gCast eachElementDo: #hide)
				(gCurRoom drawPic: 325 10)
				(arm init:)
				(theMouth init:)
				(theEyes init:)
				(zondraTalker init: 0 theEyes theMouth)
				(= cycles 1)
			)
			(10
				(gTheIconBar enable:)
				(= seconds 2)
			)
			(11
				(arm setCel: 1 stopUpd:)
				(= seconds 2)
			)
			(12
				(zondraTalker ; "You've got a lot of nerve coming back here, Roger Wilco."
					say:
						1
						self
						2
						64
						2
						2
						25
						(proc0_18 global153 global137)
						26
						global129
						27
						1
						67
						315
				)
			)
			(13
				(zondraTalker ; "After leaving me the way you did, you male Scum!"
					say:
						2
						self
						2
						64
						2
						2
						25
						(proc0_18 global153 global137)
						26
						global129
						27
						1
						67
						315
				)
			)
			(14
				(zondraTalker ; "This is the last woman you'll ever dump on! Right, girls?!"
					say:
						3
						self
						2
						64
						2
						2
						25
						(proc0_18 global153 global137)
						26
						global129
						27
						1
						67
						315
				)
			)
			(15
				(thoreenTalker ; "RIGHT!"
					init: 0 0 0
					say:
						1
						self
						2
						64
						270
						125
						25
						global130
						26
						global129
						27
						0
						67
						48
				)
				(if (& gMessageMode $0001)
					(vibraTalker ; "RIGHT!"
						init: 0 0 0
						say:
							1
							0
							2
							64
							3
							160
							25
							global150
							26
							global129
							27
							0
							67
							315
					)
				)
			)
			(16
				(if (& gMessageMode $0001)
					(vibraTalker dispose:)
				)
				(zondraTalker ; "Said ya couldn't be tied down..."
					say:
						4
						self
						2
						64
						2
						2
						25
						(proc0_18 global153 global137)
						26
						global129
						27
						1
						67
						315
				)
			)
			(17
				(rogerTalker ; "I said that?"
					init: 0 0 0
					say:
						1
						self
						2
						64
						48
						155
						25
						global140
						26
						global129
						27
						0
						67
						270
				)
			)
			(18
				(zondraTalker ; "You said ya had to be free to roam the galaxy."
					say:
						5
						self
						2
						64
						2
						2
						25
						(proc0_18 global153 global137)
						26
						global129
						27
						1
						67
						315
				)
			)
			(19
				(rogerTalker ; "Was that me?"
					say:
						2
						self
						2
						64
						48
						155
						25
						global140
						26
						global129
						27
						0
						67
						270
				)
			)
			(20
				(zondraTalker ; "You'll be sorrier than you look. We'll see to that!"
					say:
						6
						self
						2
						64
						2
						2
						25
						(proc0_18 global153 global137)
						26
						global129
						27
						1
						67
						315
				)
			)
			(21
				(thoreenTalker ; "YEAH!"
					say:
						2
						self
						2
						64
						270
						125
						25
						global130
						26
						global129
						27
						0
						67
						48
				)
				(if (& gMessageMode $0001)
					(vibraTalker ; "YEAH!"
						modNum: 322
						say:
							2
							0
							2
							64
							3
							160
							25
							global150
							26
							global129
							27
							0
							67
							315
					)
				)
			)
			(22
				(if (& gMessageMode $0001)
					(vibraTalker dispose:)
				)
				(zondraTalker ; "Into the sub, fly boy."
					say:
						7
						self
						2
						64
						2
						2
						25
						(proc0_18 global153 global137)
						26
						global129
						27
						1
						67
						315
				)
			)
			(23
				(gTheIconBar disable:)
				(zondraTalker dispose:)
				(= cycles 1)
			)
			(24
				(gCast eachElementDo: #show)
				(gCurRoom drawPic: 320 10)
				(babeLeader loop: 0 cel: 0 setPri: 14 posn: 117 144)
				(theMouth dispose:)
				(arm dispose:)
				(theEyes dispose:)
				(= cycles 1)
			)
			(25
				(NormalEgo 2 0 4)
				(AnimateEgoHead 4)
				(gTheIconBar enable:)
				(HandsOn)
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
				(EgoDead 2 21) ; "Now this is a pain that'll linger! All the Ben Gay in Florida won't relieve this stiffness."
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
					cycleSpeed: 12
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

(instance babeLeader of Sq4Actor
	(properties
		x 142
		y 122
		sightAngle 90
		view 321
		loop 7
		priority 15
		signal 16
	)

	(method (doVerb theVerb)
		(switch theVerb
			(1 ; Look
				(gNarrator say: 1) ; "She looks like she might be familiar to you someday. However the gun in her hand looks like it could limit the chance of any lasting relationship in the future, or the past."
			)
			(4 ; Do
				(gNarrator say: 2) ; "Hey! Would you like your chest cavity to host her spear?"
			)
			(2 ; Talk
				(gNarrator say: 3) ; "The time for talk on your part appears to have passed. Speak now and forever hold your pieces."
			)
			(6 ; Smell
				(gNarrator say: 4) ; "You can bet she smells better than you. Better just speculate on this one or you'll be snorting spear."
			)
			(7 ; Taste
				(gNarrator say: 5) ; "Best to keep your tastbuds packed away right now, Buckwheat."
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

(instance babe2 of Sq4Prop
	(properties
		x 126
		y 92
		view 321
		loop 5
	)

	(method (doVerb theVerb)
		(switch theVerb
			(1 ; Look
				(gNarrator say: 6) ; "This one looks committed to finding out just how good you'd look on a spit."
			)
			(4 ; Do
				(gNarrator say: 7) ; "Hey, are you trying to find out how you'd look with convenient \b3handles protruding from each side of your less-than-studly self?"
			)
			(2 ; Talk
				(gNarrator say: 3) ; "The time for talk on your part appears to have passed. Speak now and forever hold your pieces."
			)
			(6 ; Smell
				(gNarrator say: 8) ; "This would be an excellent time to keep your nostrils to yourself."
			)
			(7 ; Taste
				(gNarrator say: 9) ; "Gee! Maybe you should walk right on up to her and give it a try. NOT!!"
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance babe3 of Sq4Prop
	(properties
		x 298
		y 121
		view 321
		loop 6
		priority 14
		signal 16
	)

	(method (doVerb theVerb)
		(switch theVerb
			(1 ; Look
				(gNarrator say: 10) ; "Her speargun is pointed in a direction that eliminates any need for second thought."
			)
			(4 ; Do
				(gNarrator say: 11) ; "Do it and die."
			)
			(2 ; Talk
				(gNarrator say: 12) ; "She looks completely uninterested in conversing with the likes of you."
			)
			(6 ; Smell
				(gNarrator say: 8) ; "This would be an excellent time to keep your nostrils to yourself."
			)
			(7 ; Taste
				(gNarrator say: 13) ; "Yeah! Right!"
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance sub of Sq4Actor
	(properties
		x 120
		y 200
		sightAngle 90
		yStep 3
		view 320
		loop 1
		priority 12
		signal 16384
		cycleSpeed 12
	)

	(method (doVerb theVerb)
		(switch theVerb
			(1 ; Look
				(gNarrator say: 14) ; "The submarine has a sporty look to it, distinctly hydrodynamic compared to those fine vessels you've travelled aboard recently."
			)
			(4 ; Do
				(gCurRoom setScript: enterSubScript)
			)
			(6 ; Smell
				(gNarrator say: 15) ; "This is not a good time for vessel-sniffing."
			)
			(7 ; Taste
				(gNarrator say: 16) ; "It's not a good time to slap the old buds on barnacles."
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance subTop of Sq4Actor
	(properties
		x 135
		y 154
		sightAngle 90
		view 320
		loop 3
		priority 13
		signal 16400
		cycleSpeed 12
	)

	(method (doVerb theVerb)
		(switch theVerb
			(1 ; Look
				(gNarrator say: 14) ; "The submarine has a sporty look to it, distinctly hydrodynamic compared to those fine vessels you've travelled aboard recently."
			)
			(4 ; Do
				(gCurRoom setScript: enterSubScript)
			)
			(2) ; Talk
			(6 ; Smell
				(gNarrator say: 15) ; "This is not a good time for vessel-sniffing."
			)
			(7 ; Taste
				(gNarrator say: 16) ; "It's not a good time to slap the old buds on barnacles."
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance hatch of Sq4Prop
	(properties
		sightAngle 90
		view 320
		loop 2
		signal 16384
		cycleSpeed 12
	)

	(method (doVerb theVerb)
		(switch theVerb
			(1 ; Look
				(gNarrator say: 17) ; "That hatch looks like the perfect place to have an entry/exit device."
			)
			(4 ; Do
				(gCurRoom setScript: enterSubScript)
			)
			(6 ; Smell
				(gNarrator say: 15) ; "This is not a good time for vessel-sniffing."
			)
			(7 ; Taste
				(gNarrator say: 18) ; "Hmm...freshly lubricated."
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance bubble of Sq4Prop
	(properties
		x 130
		y 184
		sightAngle 90
		view 320
		priority 15
		signal 16
	)

	(method (doVerb theVerb)
		(switch theVerb
			(1 ; Look
				(gNarrator say: 19) ; "Bubbles are churned out by the slow moving props."
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance arm of Sq4Prop
	(properties
		x 171
		y 104
		view 1325
	)
)

(instance theMouth of Sq4Prop
	(properties
		x 171
		y 60
		view 1325
		loop 2
		signal 16384
	)
)

(instance theEyes of Sq4Prop
	(properties
		x 172
		y 42
		view 1325
		loop 4
		signal 16384
	)
)

(instance zCode of Code ; UNUSED
	(properties)

	(method (doit param1)
		(param1 z: (- (param1 z:) 1000))
	)
)

(instance theRoom of Sq4Feature
	(properties
		nsBottom 200
		nsRight 320
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2 ; Talk
				((ScriptID 703 6) doVerb: theVerb) ; theRoom
			)
			(1 ; Look
				(gNarrator say: 20) ; "Here at the base of the buttes lies the legendary Sea of Estros. The shimmering crystal-clear water is calm and inviting, giving no hint of the currents that could suck you under fast enough to pull your skin off and leave your insides standing on the shore. We could show you that, but it would be in bad taste."
			)
			(else
				(super doVerb:)
			)
		)
	)
)

(instance theSea of Sq4Feature
	(properties
		nsBottom 200
		nsRight 320
		onMeCheck 16
	)

	(method (doVerb theVerb)
		(switch theVerb
			(1 ; Look
				(gNarrator say: 21) ; "The water here is quite deep."
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance hatchSnd of Sound
	(properties)
)

(instance zondraTalker of FaceTalker
	(properties
		noun 19
		modNum 322
		talkerNum 19
	)
)

(instance rogerTalker of Sq4Narrator
	(properties
		noun 7
		modNum 322
		disposeWhenDone 0
		talkerNum 7
	)
)

(instance thoreenTalker of Sq4Narrator
	(properties
		noun 20
		modNum 322
		disposeWhenDone 0
		modeless 1
		talkerNum 20
	)
)

(instance vibraTalker of Sq4Narrator
	(properties
		noun 20
		modNum 322
		disposeWhenDone 0
		modeless 1
		talkerNum 20
	)
)

