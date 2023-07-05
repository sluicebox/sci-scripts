;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 240)
(include sci.sh)
(use Main)
(use rgCrown)
(use walkEgoInScr)
(use KQ6Room)
(use n913)
(use Print)
(use Inset)
(use PAvoider)
(use Scaler)
(use PolyPath)
(use Polygon)
(use Feature)
(use LoadMany)
(use DPath)
(use Motion)
(use Actor)
(use System)

(public
	rm240 0
)

(local
	local0
	[local1 58] = [0 -10 319 -10 326 175 243 150 231 149 204 140 181 134 162 137 158 132 152 130 142 132 135 123 119 117 105 102 71 102 58 97 58 0 46 0 46 94 13 103 29 113 13 119 24 132 14 144 42 160 64 174 101 178 117 189 0 189]
	[local59 58] = [0 -10 319 -10 326 175 243 150 231 149 204 140 181 134 162 137 158 132 152 130 142 132 135 123 119 117 105 102 71 102 58 97 58 0 46 0 46 94 11 104 19 117 54 117 34 137 18 137 39 159 64 174 101 178 117 189 0 189]
)

(procedure (localproc_0 param1)
	(if param1
		(gCurRoom addObstacle: (roomPoly points: @local59 yourself:))
	else
		(gCurRoom addObstacle: (roomPoly points: @local1 yourself:))
	)
)

(instance rm240 of KQ6Room
	(properties
		noun 3
		picture 240
		horizon 10
		south 210
	)

	(method (init)
		(LoadMany rsVIEW 240 241)
		(Load rsMESSAGE picture)
		(super init: &rest)
		(gEgo
			init:
			reset: 3
			setAvoider: PAvoider
			setScale: Scaler 90 72 188 95
		)
		(if (> gAct 2)
			(proclamation init:)
		else
			(procCover init:)
		)
		(pot init:)
		(doorBell1 init:)
		(doorBell2 init:)
		(genericFeatures init:)
		(randomVillagers init: setScript: villagersScr)
		(if ((ScriptID 10 0) isSet: 2) ; rgCrown
			((ScriptID 10 0) clrIt: 2) ; rgCrown
			(clown init:)
		)
		(cond
			((OneOf gPrevRoomNum 280 270)
				(if (== gPrevRoomNum 280)
					(pshopDoor cel: 5)
				else
					(bshopDoor cel: 5)
				)
				(self setScript: enterFromShopScr)
			)
			((== gPrevRoomNum 250)
				(self setScript: enterFromVillage2Scr)
			)
			(else
				(proc12_1 191 185 -45)
			)
		)
		(pshopDoor init:)
		(bshopDoor init:)
		(bush1 init:)
		(bush2 init:)
		(if (>= (gGame _detailLevel:) 2)
			(bush1 setScript: (Clone (ScriptID 13 0))) ; windScr
			(bush2 setScript: (ScriptID 13 0)) ; windScr
		)
		(if (not ((ScriptID 10 0) isSet: 512)) ; rgCrown
			(gGlobalSound number: 240 loop: -1 play:)
		else
			((ScriptID 10 0) clrIt: 512) ; rgCrown
		)
		(if
			(and
				(not (OneOf gPrevRoomNum 270 280))
				(gEgo has: 0) ; map
				(not (IsFlag 110))
			)
			(SetFlag 110)
			(proc10_2 dumpTrashScr)
		)
		(if (and (OneOf gAct 1 5) (not (IsFlag 12)))
			((ScriptID 241 0) init:) ; lampSeller
			(localproc_0 1)
		else
			(localproc_0 0)
		)
	)

	(method (doit &tmp temp0)
		(= temp0 (gEgo onControl: 1))
		(cond
			(script 0)
			((& temp0 $4000)
				(gGlobalSound fade: 0 10 10 0)
				(self setScript: exitToVillage2Scr)
			)
		)
		(super doit: &rest)
	)

	(method (edgeToRoom param1)
		(if (== param1 3)
			(gGlobalSound fade: 0 10 10 0)
			(proc12_0 param1 -45)
			(return 0)
		else
			(super edgeToRoom: param1 &rest)
		)
	)

	(method (newRoom newRoomNumber)
		(if (and (== newRoomNumber 210) (gCast contains: clown))
			((ScriptID 10 0) setIt: 2) ; rgCrown
		)
		(if (and (IsFlag 53) (not (== newRoomNumber 270)))
			(SetFlag 54)
			(ClearFlag 53)
		)
		(super newRoom: newRoomNumber &rest)
	)

	(method (notify)
		((gCurRoom obstacles:) delete: roomPoly)
		(localproc_0 0)
	)

	(method (dispose)
		(if (OneOf gNewRoomNum 270 280)
			(gGlobalSound fade: 70 10 15 0)
		)
		(DisposeScript 11)
		(DisposeScript 923)
		(DisposeScript 927)
		(DisposeScript 964)
		(DisposeScript 930)
		(DisposeScript 13)
		(DisposeScript 241)
		(super dispose:)
	)
)

(instance procInset of Inset
	(properties
		view 242
		x 80
		y 73
		disposeNotOnMe 1
		noun 10
	)

	(method (init)
		(super init: &rest)
		(gGame handsOn:)
		(gTheIconBar disable: 0 1 3 4 5 6)
	)

	(method (doVerb)
		(Print font: gUserFont posn: 160 30 width: 138 addText: 10 1 0 1 init:) ; "It's a proclamation. It reads: "Citizens Rejoice! Announcing the royal wedding and coronation of Vizier Abdul Alhazred and Princess Cassima. For reasons of security, the wedding will not be open to the public. Long live the new king and queen of the Land of the Green Isles!""
	)

	(method (onMe param1 &tmp temp0)
		(if (not (= temp0 (super onMe: param1 &rest)))
			(gGame handsOn:)
			(gTheIconBar enable: 6)
		)
		(return temp0)
	)
)

(instance exitToVillage2Scr of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo
					setScale: Scaler 75 25 95 68
					setMotion: DPath 43 92 33 90 self
				)
			)
			(1
				(gCurRoom newRoom: 250)
			)
		)
	)
)

(instance enterFromVillage2Scr of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo
					posn: 34 90
					setScale: Scaler 75 25 95 68
					setMotion: DPath 43 92 54 96 self
				)
			)
			(1
				(gEgo
					setScale: Scaler 90 72 188 95
					setMotion: MoveTo 55 101 self
				)
			)
			(2
				(if (not script)
					(= cycles 1)
				)
			)
			(3
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance exitToShopScr of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo
					setMotion: 0
					setSpeed: 6
					view: 241
					loop: 1
					cel: 0
					normal: 0
				)
				(if (== register 1)
					(gEgo posn: 232 144 scaleX: 117 scaleY: 117)
					(= local0 pshopDoor)
				else
					(gEgo posn: 160 130 scaleX: 107 scaleY: 107)
					(= local0 bshopDoor)
				)
				(gEgo setScale: setCycle: End self)
			)
			(1
				(if (== register 1)
					(gEgo posn: 239 128)
				else
					(gEgo setPri: 9 posn: 171 115)
				)
				(gEgo loop: 0 cel: 0 setCycle: End self)
				(gGlobalSound4 number: 901 loop: 1 play:)
				(local0 cel: 0 setCycle: CT 4 1 self)
			)
			(2 0)
			(3
				(gEgo reset:)
				(if (== (self register:) 1)
					(gCurRoom newRoom: 280)
				else
					(gCurRoom newRoom: 270)
				)
			)
		)
	)
)

(instance enterFromShopScr of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo setMotion: 0 view: 241 loop: 2 cel: 0 normal: 0)
				(if (== gPrevRoomNum 280)
					(gEgo posn: 224 145 scaleX: 117 scaleY: 117)
					(= local0 pshopDoor)
				else
					(gEgo setPri: 9 posn: 158 129 scaleX: 107 scaleY: 107)
					(= local0 bshopDoor)
				)
				(gEgo setScale:)
				(= cycles 2)
			)
			(1
				(local0 setCycle: Beg self)
			)
			(2
				(= cycles 2)
			)
			(3
				(local0 stopUpd:)
				(gGlobalSound4 number: 902 loop: 1 play:)
				(gEgo setCycle: End self)
			)
			(4
				(if (not (gCast contains: clown))
					(gGame handsOn:)
				)
				(gEgo reset: 5 setScale: Scaler 90 72 188 95)
				(if (== gPrevRoomNum 280)
					(gEgo posn: 214 147)
				else
					(gEgo setPri: -1 posn: 150 132)
				)
				(self dispose:)
			)
		)
	)
)

(instance dumpTrashScr of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(SetFlag 110)
				(= seconds 2)
			)
			(1
				(gGlobalSound4 number: 901 loop: 1 play:)
				(pshopDoor
					view: 248
					cycleSpeed: 9
					loop: 1
					cel: 0
					setCycle: CT 6 1 self
				)
			)
			(2
				(gGlobalSound3 number: 241 loop: 1 play:)
				(pshopDoor setCycle: End self)
			)
			(3
				(gGlobalSound4 number: 902 loop: 1 play:)
				(= cycles 2)
			)
			(4
				(pshopDoor view: 240 loop: 0 cel: 0 stopUpd:)
				(= cycles 2)
			)
			(5
				(self dispose:)
			)
		)
	)
)

(instance searchUrnScr of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo
					setSpeed: 6
					normal: 0
					posn: 194 135
					view: 248
					loop: 0
					cel: 0
					setScale: 0
				)
				(= cycles 2)
			)
			(1
				(gEgo setCycle: CT 2 1 self)
			)
			(2
				(gGlobalSound3 number: 241 loop: -1 play:)
				(gEgo setCycle: (ScriptID 231 0) 3) ; ForwardFrom
				(= ticks 120)
			)
			(3
				(gGlobalSound3 stop:)
				(gMessager
					say:
						26
						5
						(cond
							((and (IsFlag 110) (not (IsFlag 111)))
								(= register 1)
								(gEgo get: 51) ; ink
								(SetFlag 111)
								38
							)
							((IsFlag 110) 39)
							(else 37)
						)
						0
						self
				)
			)
			(4
				(gEgo setCycle: Beg self)
			)
			(5
				(= cycles 2)
			)
			(6
				(gEgo
					reset: 0
					posn: (pot approachX:) (pot approachY:)
					setScale: Scaler 90 72 188 95
				)
				(= cycles 2)
			)
			(7
				(if register
					(gGame givePoints: 1)
				)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)

	(method (dispose)
		(DisposeScript 231)
		(super dispose:)
		(= register 0)
	)
)

(instance villagersScr of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(client hide:)
				(= state
					(switch (Random 0 2)
						(0 0)
						(1 8)
						(2 17)
					)
				)
				(= seconds (Random 45 60))
			)
			(1
				(client
					show:
					loop: 1
					cel: 0
					posn: 159 123 78
					setCycle: End self
				)
			)
			(2
				(client loop: 0 cel: 0)
				(= ticks 60)
			)
			(3
				(client loop: 3 cel: 0 setCycle: End self)
			)
			(4
				(= ticks 60)
			)
			(5
				(client loop: 3 setCycle: Beg self)
			)
			(6
				(= ticks 60)
			)
			(7
				(client loop: 3 setCycle: End self)
			)
			(8
				(client loop: 2 cel: 0 setCycle: End self)
				(= state -1)
			)
			(9
				(client
					show:
					loop: 5
					cel: 0
					posn: 198 123 90
					setCycle: End self
				)
			)
			(10
				(client loop: 4 cel: 0)
				(= ticks (Random 45 120))
			)
			(11
				(client loop: 6 cel: 0 setCycle: End self)
			)
			(12
				(= ticks (Random 45 120))
			)
			(13
				(client loop: 6 cel: 0 setCycle: Beg self)
			)
			(14
				(= ticks (Random 45 120))
			)
			(15
				(client loop: 6 cel: 0 setCycle: End self)
			)
			(16
				(= ticks (Random 45 120))
			)
			(17
				(client loop: 7 cel: 0 setCycle: End self)
				(= state -1)
			)
			(18
				(client
					show:
					posn: 247 122 84
					loop: 9
					cel: 0
					setCycle: End self
				)
			)
			(19
				(client loop: 8 cel: 0)
				(= ticks (Random 45 120))
			)
			(20
				(client loop: 12 cel: 0 setCycle: End self)
			)
			(21
				(= ticks (Random 45 120))
			)
			(22
				(client setCycle: Beg self)
			)
			(23
				(= ticks (Random 45 120))
			)
			(24
				(client loop: 10 cel: 0 setCycle: End self)
			)
			(25
				(client loop: 11 cel: 0 setCycle: Fwd)
				(= ticks 80)
			)
			(26
				(client loop: 13 cel: 0 setCycle: End self)
				(= state -1)
			)
		)
	)
)

(instance clownScr of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(client setMotion: PolyPath 156 250 self)
			)
			(1
				(gGame handsOn:)
				(gTheIconBar curIcon: (gTheIconBar at: 0))
				(gGame setCursor: ((gTheIconBar curIcon:) cursor:))
				(= seconds 10)
			)
			(2
				(client dispose:)
			)
		)
	)
)

(instance lookAtProcScr of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(= register 0)
				(if (not (SetFlag 71))
					(if (or (IsFlag 72) (IsFlag 52))
						(= register 30)
					else
						(= register 31)
					)
					(gMessager say: 8 1 30 1 self) ; "Hmmm. Alexander doesn't remember that sign being on the wall before. He decides to take a closer look."
				else
					(gMessager say: 8 1 33 1 self) ; "Alexander takes another look at the wedding proclamation."
					(= register 33)
				)
			)
			(1
				(gEgo
					setMotion:
						PolyPath
						(proclamation approachX:)
						(proclamation approachY:)
						self
				)
			)
			(2
				(gEgo setHeading: 0 self)
			)
			(3
				(= cycles 2)
			)
			(4
				(procInset init: 0 gCurRoom)
				(= cycles 2)
			)
			(5
				(Print
					font: gUserFont
					posn: 160 30
					width: 138
					addText: 10 1 0 1 ; "It's a proclamation. It reads: "Citizens Rejoice! Announcing the royal wedding and coronation of Vizier Abdul Alhazred and Princess Cassima. For reasons of security, the wedding will not be open to the public. Long live the new king and queen of the Land of the Green Isles!""
					init: self
				)
			)
			(6
				(= cycles 2)
			)
			(7
				(if (!= register 33)
					(Print
						font: gUserFont
						posn: 160 52
						width: 138
						addText: 8 1 register (if (== register 30) 2 else 1)
						init: self
					)
				else
					(= cycles 1)
				)
			)
			(8
				(self dispose:)
			)
		)
	)
)

(instance bshopDoor of Prop
	(properties
		x 186
		y 134
		z 49
		noun 46
		approachX 155
		approachY 131
		view 240
		loop 1
		priority 5
		signal 16401
	)

	(method (doVerb theVerb)
		(if (== theVerb 5) ; Do
			(gCurRoom setScript: exitToShopScr 0 0)
		else
			(super doVerb: theVerb &rest)
		)
	)

	(method (init)
		(super init: &rest)
		(self approachVerbs: 5) ; Do
	)
)

(instance pshopDoor of Prop
	(properties
		x 255
		y 99
		noun 45
		approachX 218
		approachY 147
		view 240
		signal 1
	)

	(method (doVerb theVerb)
		(switch theVerb
			(5 ; Do
				(gCurRoom setScript: exitToShopScr 0 1)
			)
			(1 ; Look
				(super doVerb: theVerb &rest)
			)
			(else
				(bshopDoor doVerb: theVerb &rest)
			)
		)
	)

	(method (init)
		(super init: &rest)
		(self approachVerbs: 5) ; Do
	)
)

(instance randomVillagers of Prop
	(properties
		noun 33
		view 246
	)

	(method (doVerb theVerb)
		(if (== (gKq6ApproachCode doit: theVerb) -32768)
			(= theVerb 5) ; Do
		)
		(if (== theVerb 2) ; Talk
			(gMessager say: noun theVerb (+ 25 (Random 0 2)))
		else
			(super doVerb: theVerb &rest)
		)
	)
)

(instance clown of Actor
	(properties
		x 139
		y 140
		view 717
		signal 16384
	)

	(method (init)
		(super init: &rest)
		(self
			setScale: Scaler 90 72 188 95
			setCycle: Walk
			setSpeed: 4
			setScript: clownScr
		)
	)
)

(instance procCover of Prop
	(properties
		x 90
		y 86
		noun 50
		view 2401
		priority 6
		signal 16
	)
)

(instance bush1 of Prop
	(properties
		x 11
		y 167
		view 240
		loop 2
		priority 15
		signal 16400
		cycleSpeed 2
	)
)

(instance bush2 of Prop
	(properties
		x 54
		y 186
		view 240
		loop 3
		cel 3
		priority 15
		signal 16400
		cycleSpeed 4
	)
)

(instance proclamation of Feature
	(properties
		x 90
		y 101
		noun 8
		nsTop 75
		nsLeft 83
		nsBottom 91
		nsRight 96
		sightAngle 40
		approachX 88
		approachY 109
	)

	(method (doVerb theVerb)
		(if (OneOf theVerb 1 5) ; Look, Do
			(gCurRoom setScript: lookAtProcScr)
		else
			(super doVerb: theVerb &rest)
		)
	)
)

(instance pot of Feature
	(properties
		x 213
		y 135
		noun 26
		onMeCheck 256
		approachX 195
		approachY 134
	)

	(method (onMe param1)
		(if
			(and
				(== (OnControl CONTROL (param1 x:) (param1 y:)) onMeCheck)
				(< (param1 x:) 235)
			)
			(return 1)
		else
			(return 0)
		)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(5 ; Do
				(gCurRoom setScript: searchUrnScr)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)

	(method (init)
		(super init: &rest)
		(self approachVerbs: 5) ; Do
	)
)

(instance genericFeatures of Feature
	(properties
		sightAngle 40
	)

	(method (onMe param1)
		(= x (param1 x:))
		(= y (param1 y:))
		(return
			(= noun
				(switch (OnControl CONTROL (param1 x:) (param1 y:))
					(2
						(if (< (param1 y:) 100)
							(= y 154)
							5
						else
							0
						)
					)
					(4096
						(= y 131)
						47
					)
					(8192
						(= y 131)
						48
					)
					(8
						(= y 97)
						50
					)
					(32
						(= y 122)
						43
					)
					(16
						(= y 122)
						13
					)
					(64
						(= y 134)
						41
					)
					(128
						(= y 120)
						42
					)
					(512
						(if (> (param1 x:) 96)
							(= y 154)
							23
						else
							49
						)
					)
					(256
						(cond
							((> (param1 x:) 265)
								(= y 155)
								11
							)
							((< (param1 x:) 235) 0)
							(else
								(= y 146)
								24
							)
						)
					)
					(1024
						(cond
							((> (param1 y:) 131)
								(= y 160)
								25
							)
							((< (param1 y:) 80)
								(= y 148)
								40
							)
							(else
								(= y 151)
								44
							)
						)
					)
					(2048
						(= y 153)
						14
					)
					(else 0)
				)
			)
		)
	)

	(method (doVerb theVerb)
		(cond
			((and (== theVerb 5) (OneOf noun 11 26 24)) ; Do
				(gMessager say: 24 theVerb)
			)
			(
				(or
					(and
						(or
							(OneOf theVerb 5 2) ; Do, Talk
							(== (gKq6ApproachCode doit: theVerb) -32768)
						)
						(== noun 14)
						(= noun 13)
					)
					(and (== theVerb 2) (== noun 40) (= noun 41)) ; Talk
					(and
						(== (gKq6ApproachCode doit: theVerb) -32768)
						(or
							(and (== noun 44) (= noun 42))
							(and (== noun 49) (= theVerb 5)) ; Do
						)
					)
				)
				(super doVerb: theVerb &rest)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance doorBell1 of Feature
	(properties
		x 185
		y 132
		z 56
		noun 12
		nsTop 70
		nsLeft 179
		nsBottom 82
		nsRight 191
		sightAngle 40
	)
)

(instance doorBell2 of Feature
	(properties
		x 225
		y 139
		z 53
		noun 12
		nsTop 81
		nsLeft 221
		nsBottom 91
		nsRight 229
		sightAngle 40
	)
)

(instance roomPoly of Polygon
	(properties
		size 29
		type PBarredAccess
	)
)

