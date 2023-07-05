;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 160)
(include sci.sh)
(use Main)
(use n010)
(use goGet)
(use Interface)
(use PolyPath)
(use Polygon)
(use Feature)
(use LoadMany)
(use Sound)
(use Motion)
(use Actor)
(use System)

(public
	Room160 0
)

(local
	local0
	local1
	local2
	local3
	local4
	local5
	local6
	[local7 200]
)

(procedure (localproc_0)
	(house init:)
	(fence init:)
	(gate init:)
	(tree init:)
	(hole init:)
	(barrel init:)
	(bottles init:)
	(wall init:)
	(flower init:)
	(roof init:)
	(castle init:)
	(road init:)
	(door init:)
	(window1 init:)
)

(instance Room160 of FRoom
	(properties
		lookStr {This is the west side of the town.}
		picture 160
		style 0
		horizon 73
		north 110
		east 170
		friendX 144
		friendY 126
		northX 235
		northY 52
		eastX 287
		eastY 114
	)

	(method (init)
		(LoadMany rsSOUND 107)
		(if (== (gBeautyStory state:) 0)
			(Load rsSOUND 12)
		)
		(if (> global225 0)
			(Load rsSOUND global225)
		)
		(Load rsSOUND 151)
		(super init:)
		(proc10_29)
		(gTheIconBar enable: show:)
		(gCurRoom
			addObstacle:
				((Polygon new:)
					type: PBarredAccess
					init: 283 2 319 0 319 105 263 109 263 97 278 94 278 88 272 76 268 61 253 60
					yourself:
				)
				((Polygon new:)
					type: PBarredAccess
					init: 319 113 319 173 0 173 0 0 273 0 230 76 199 123 158 165 265 160 265 148 277 140 276 128 264 128 264 120 319 112
					yourself:
				)
		)
		(localproc_0)
		(ripple setPri: 14 init:)
		(= local2 (Random 15 50))
		(if (and (not (IsFlag 1)) (IsFlag 5))
			(gBookEnd init: setScript: escape)
		)
		(switch (gBeautyStory state:)
			(0
				(gBeautyStory selectCode: beautySelect)
				(gEgo doCode: egoDo160)
				(= local5 ((gInventory at: 8) regActor:))
				(local5
					doCode: beautDo160
					selection: 0
					view: 689
					setLoop: 0
					cel: 0
					normal: 0
					posn: friendX friendY
					stopUpd:
					init:
				)
			)
			(else 0)
		)
	)

	(method (cue)
		(super cue:)
		(switch (gBeautyStory state:)
			(0
				(if (not (IsFlag 5))
					(self setScript: enterBeforeStory)
				else
					(proc10_13 2 local5 gEgo -1 1 160 0)
				)
			)
			(else 0)
		)
	)

	(method (doit)
		(super doit:)
		(= local0 (GetTime 1)) ; SysTime12
		(if (!= local1 local0)
			(= local0 local1)
			(if (and (not (ripple script:)) (not (-- local2)))
				(ripple setScript: waterDrop)
				(= local2 (Random 50 200))
			)
		)
		(cond
			(script 0)
			((not (IsFlag 5)) 0)
			((IsFlag 1) 0)
			((not (gEgo mover:)) 0)
			((<= (Abs (- (gEgo heading:) 90)) 30)
				(gCurRoom setScript: bookChase self)
			)
		)
		(cond
			(script 0)
			((IsFlag 5) 0)
			((gBeautyStory selected:) 0)
			(local3 0)
			((or (< (gEgo y:) 85) (> (gEgo x:) 280))
				(gCurRoom setScript: encourage)
			)
		)
		(cond
			(script 0)
			((>= (gEgo x:) 292)
				(gCurRoom setScript: egoExitEast)
			)
		)
	)

	(method (dispose)
		(if (IsFlag 5)
			(SetFlag 1)
		)
		(gBeautyStory selectCode: 0)
		(gEgo doCode: 0)
		(if (gGlobalMusic handle:)
			(gGlobalMusic fade: 0 15 12 1)
			(= global225 6)
		)
		(super dispose: &rest)
	)
)

(instance egoExitEast of HandsOffScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo
					setMotion: PolyPath (+ (gEgo x:) 20) (gEgo y:) self
				)
			)
			(1
				(self dispose:)
			)
		)
	)
)

(instance bookChase of HandsOffScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo
					setMotion:
						PolyPath
						(+ (gCurRoom eastX:) 20)
						(gCurRoom eastY:)
						self
				)
			)
			(1
				(gCurRoom newRoom: 170)
				(self dispose:)
			)
		)
	)
)

(instance escape of HandsOffScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gBookEnd
					setStep: 7 2
					posn: 224 118
					setCycle: Walk
					setMotion: PolyPath (gCurRoom eastX:) (gCurRoom eastY:) self
				)
			)
			(1
				(gBookEnd dispose:)
				(self dispose:)
			)
		)
	)
)

(instance encourage of HandsOffScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= local3 1)
				(gEgo setMotion: 0)
				(= cycles 1)
			)
			(1
				(Face gEgo local5)
				(= cycles 1)
			)
			(2
				(proc10_13 2 local5 gEgo self 0 160 1)
			)
			(3
				(proc10_13 0 local5 gEgo self 1 160 2)
			)
			(4
				(self dispose:)
			)
		)
	)
)

(instance enterBeforeStory of HandsOffScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(proc10_13 0 local5 gEgo -1 0 160 3)
				(proc10_13 0 local5 gEgo self 1 160 4)
			)
			(1
				(gEgo setMotion: PolyPath 191 131 self)
			)
			(2
				(Face gEgo local5 self)
			)
			(3
				(self dispose:)
			)
		)
	)
)

(instance storySelect of HandsOffScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= local4 1)
				(gBeautyStory selected: 1 incState:)
				(= global143 gBeautyStory)
				((gInventory at: 9) owner: 290)
				(if (gGame script:)
					(gGame setScript: 0)
					(gGlobalMusic2 stop:)
				)
				(gGlobalMusic number: 12 priority: 15 setLoop: -1 play:)
				(self setScript: (ScriptID 91 1) self) ; DisplayStart
			)
			(1
				(proc10_13 0 local5 gEgo self 1 160 5)
			)
			(2
				(gEgo selection: 0)
				(local5 selection: 0)
				(self dispose:)
			)
		)
	)
)

(instance dripSound of Sound
	(properties
		flags 1
		number 107
		priority 14
	)
)

(instance waterDrop of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(drop
					posn: 287 94
					setPri: 15
					yStep: 15
					setMotion: MoveTo 287 155 self
					init:
				)
			)
			(1
				(drop dispose:)
				(dripSound play:)
				(ripple setCycle: End self)
			)
			(2
				(self dispose:)
			)
		)
	)
)

(instance raccoonSound of Sound
	(properties
		flags 1
		number 151
		priority 15
	)
)

(instance moveRaccoon of HandsOffScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(if gModelessDialog
					(gModelessDialog dispose:)
				)
				(raccoonSound play:)
				(raccoon setCycle: End self)
			)
			(1
				(raccoon dispose:)
				(self dispose:)
			)
		)
	)
)

(instance raccoon of Prop
	(properties
		x 12
		y 127
		description {Raccoon}
		lookStr {The raccoon is cute.}
		view 160
	)

	(method (doVerb theVerb)
		(switch theVerb
			(5 ; Do
				(raccoon setScript: moveRaccoon)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance drop of Actor
	(properties
		x 281
		y 127
		view 160
		loop 1
	)
)

(instance ripple of Prop
	(properties
		x 289
		y 161
		view 160
		loop 2
	)

	(method (doVerb theVerb)
		(barrel doVerb: theVerb)
	)
)

(instance house of Feature
	(properties
		x 56
		y 120
		description {House}
		sightAngle 90
		onMeCheck 2
		lookStr {This house has flowers and a fence around it.}
	)
)

(instance fence of Feature
	(properties
		x 200
		y 110
		description {Fence}
		sightAngle 90
		onMeCheck 4
		lookStr {The fence is white.}
	)
)

(instance gate of Feature
	(properties
		x 173
		y 137
		description {Gate}
		sightAngle 90
		onMeCheck 8
		lookStr {The gate is locked.}
	)
)

(instance tree of Feature
	(properties
		x 11
		y 80
		description {Tree}
		sightAngle 90
		onMeCheck 16
		lookStr {The tree has a hole in it.}
	)
)

(instance hole of Feature
	(properties
		x 15
		y 120
		description {Hole}
		sightAngle 90
		onMeCheck 32
		lookStr {In this hole lives a raccoon.}
	)

	(method (doVerb theVerb)
		(cond
			((!= theVerb 5) ; Do
				(super doVerb: theVerb &rest)
			)
			((gCast contains: raccoon)
				(raccoon doVerb: 5)
			)
			(else
				(raccoonSound play:)
				(raccoon cel: 1 init:)
				(Print 160 6 #time 5 #at -1 160 #dispose) ; "You see a raccoon."
			)
		)
	)
)

(instance barrel of Feature
	(properties
		x 281
		y 140
		description {Barrel}
		sightAngle 90
		onMeCheck 64
		lookStr {The barrel is full of water from rain.}
	)
)

(instance bottles of Feature
	(properties
		x 259
		y 140
		description {Bottles}
		sightAngle 90
		onMeCheck 128
		lookStr {The bottles are full of water.}
	)
)

(instance wall of Feature
	(properties
		x 42
		y 140
		description {Wall}
		sightAngle 90
		onMeCheck 256
		lookStr {This is the top of the wall.}
	)
)

(instance flower of Feature
	(properties
		x 106
		y 110
		description {Flowers}
		sightAngle 90
		onMeCheck 512
		lookStr {The flowers here smell like candy.}
	)
)

(instance roof of Feature
	(properties
		x 115
		y 50
		description {Roof}
		sightAngle 90
		onMeCheck 1024
		lookStr {The roof of the house is made of straw.}
	)
)

(instance castle of Feature
	(properties
		x 189
		y 40
		description {Castle}
		sightAngle 90
		onMeCheck 2048
		lookStr {The castle is far in the distance.}
	)
)

(instance road of Feature
	(properties
		x 237
		y 70
		description {Road}
		sightAngle 90
		onMeCheck 4096
		lookStr {The road leads north to the castle and east.}
	)
)

(instance door of Feature
	(properties
		x 93
		y 112
		description {Door}
		sightAngle 90
		onMeCheck 8192
		lookStr {The door has a large window in it.}
	)
)

(instance window1 of Feature
	(properties
		x 121
		y 87
		description {Window}
		sightAngle 90
		onMeCheck 16384
		lookStr {The window lets you see into the house.}
	)
)

(instance beautySelect of Code
	(properties)

	(method (doit)
		(gCurRoom setScript: storySelect)
	)
)

(instance egoDo160 of Code
	(properties)

	(method (doit param1)
		(switch param1
			(5
				(cond
					(local6
						(switch (gEgo selection:)
							(0
								(proc10_13 2 gEgo local5 -1 1 160 7)
								(proc10_13 3 local5 gEgo -1 0 160 8)
								(proc10_13 0 local5 gEgo -1 0 160 9)
								(proc10_13 3 local5 gEgo -1 1 160 10)
							)
							(1
								(proc10_13 2 gEgo local5 -1 1 160 11)
								(proc10_13 0 local5 gEgo -1 1 160 12)
								(proc10_13 1 gEgo local5 -1 1 160 13)
								(proc10_13 3 local5 gEgo -1 1 160 14)
							)
							(2
								(proc10_13 0 gEgo local5 -1 1 160 15)
								(proc10_13 0 local5 gEgo -1 1 160 16)
							)
							(else
								(ClearFlag 5)
								(= local6 0)
								(gEgo selection: 0)
								(local5 selection: 0)
							)
						)
					)
					((== (gBeautyStory state:) 0)
						(switch (gEgo selection:)
							(0
								(proc10_13 0 gEgo local5 -1 1 160 17)
								(proc10_13 3 local5 gEgo -1 0 160 18)
								(proc10_13 3 local5 gEgo -1 1 160 19)
							)
							(1
								(proc10_13 0 gEgo local5 -1 1 160 20)
								(proc10_13 0 local5 gEgo -1 0 160 21)
								(proc10_13 0 local5 gEgo -1 0 160 22)
								(proc10_13 0 local5 gEgo -1 1 160 23)
							)
							(2
								(proc10_13
									0
									gEgo
									local5
									-1
									1
									(Format @local7 160 24 @global110) ; "I am %s."
								)
								(proc10_13
									0
									local5
									gEgo
									-1
									0
									(Format @local7 160 25 @global110) ; "Pleased to meet you, %s. I am Beauty."
								)
								(proc10_13 0 local5 gEgo -1 1 160 26)
								(proc10_13 0 gEgo local5 -1 1 160 27)
								(proc10_13 0 local5 gEgo -1 1 160 28)
							)
							(else
								(proc10_13 2 gEgo local5 -1 1 160 29)
								(proc10_13 0 local5 gEgo -1 1 160 30)
								(proc10_13 0 gEgo local5 -1 1 160 31)
								(proc10_13 3 local5 gEgo -1 1 160 32)
							)
						)
					)
					(else
						(switch (gEgo selection:)
							(0
								(proc10_13 0 gEgo local5 -1 1 160 33)
								(proc10_13 0 local5 gEgo -1 0 160 34)
								(proc10_13 3 local5 gEgo -1 1 160 35)
								(proc10_13 3 gEgo local5 -1 1 160 36)
								(proc10_13 0 local5 gEgo -1 1 160 37)
							)
							(1
								(proc10_13 2 gEgo local5 -1 1 160 38)
								(proc10_13 2 local5 gEgo -1 0 160 39)
								(proc10_13 0 local5 gEgo -1 1 160 40)
							)
							(2
								(proc10_13 2 gEgo local5 -1 1 160 41)
								(proc10_13 0 local5 gEgo -1 1 160 42)
							)
							(else
								(proc10_13 0 gEgo local5 -1 1 160 33)
								(proc10_13 0 local5 gEgo -1 1 160 43)
							)
						)
					)
				)
				(gEgo incSel:)
			)
		)
	)
)

(instance beautDo160 of Code
	(properties)

	(method (doit param1)
		(switch param1
			(5
				(cond
					(local6
						(switch (local5 selection:)
							(0
								(proc10_13 0 local5 gEgo -1 1 160 44)
							)
							(1
								(proc10_13 3 local5 gEgo -1 0 160 45)
								(proc10_13 3 local5 gEgo -1 1 160 46)
							)
							(2
								(proc10_13 3 local5 gEgo -1 1 160 47)
							)
							(else
								(ClearFlag 5)
								(= local6 0)
								(gEgo selection: 0)
								(local5 selection: 0)
							)
						)
					)
					((== (gBeautyStory state:) 0)
						(switch (local5 selection:)
							(0
								(proc10_13 3 local5 gEgo -1 1 160 48)
							)
							(1
								(proc10_13 0 local5 gEgo -1 1 160 49)
							)
							(2
								(proc10_13 3 local5 gEgo -1 1 160 50)
							)
							(else
								(proc10_13 0 local5 gEgo -1 0 160 51)
								(proc10_13 3 local5 gEgo -1 1 160 52)
							)
						)
					)
					(else
						(switch (local5 selection:)
							(0
								(proc10_13 3 local5 gEgo -1 0 160 53)
								(proc10_13 3 local5 gEgo -1 1 160 54)
							)
							(1
								(proc10_13 0 local5 gEgo -1 1 160 55)
							)
							(2
								(proc10_13 3 local5 gEgo -1 0 160 56)
								(proc10_13 3 local5 gEgo -1 1 160 57)
							)
							(else
								(proc10_13 0 local5 gEgo -1 0 160 58)
								(proc10_13 3 local5 gEgo -1 1 160 59)
							)
						)
					)
				)
				(local5 incSel:)
			)
		)
	)
)

