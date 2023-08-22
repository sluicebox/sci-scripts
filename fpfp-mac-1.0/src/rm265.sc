;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 265)
(include sci.sh)
(use Main)
(use Swing)
(use eRS)
(use Scaler)
(use PolyPath)
(use Polygon)
(use Feature)
(use Door)
(use LoadMany)
(use Jump)
(use Motion)
(use Actor)
(use System)

(public
	rm265 0
)

(local
	local0
	local1
	local2
	local3
)

(instance rm265 of FPRoom
	(properties
		noun 16
		picture 260
		horizon 40
		north 320
		east 270
		west 250
	)

	(method (init)
		(LoadMany rsSOUND 2264 637)
		(LoadMany rsVIEW 261)
		(LoadMany rsSCRIPT 991 12)
		(switch gPrevRoomNum
			(west
				(= style 12)
			)
			(east
				(= style 11)
				(if (< (gEgo y:) 100)
					(gEgo y: 100)
				)
			)
			(680
				(gGame handsOn:)
			)
			(north
				(= style 100)
				(gEgo x: 100 y: 45)
			)
			(else
				(= style 100)
				(gEgo x: 160 y: 160)
			)
		)
		(gEgo init: setScale: Scaler 100 50 175 95 normalize:)
		(super init:)
		(if (IsFlag 64)
			(if (IsFlag 8)
				(bakingSoda
					posn: 260 80
					init:
					stopUpd:
					approachVerbs: 4 ; Do
					ignoreActors:
				)
				(seesaw cel: (seesaw lastCel:))
			else
				(bakingSoda
					posn: 233 80
					init:
					stopUpd:
					approachVerbs: 4 ; Do
					ignoreActors:
				)
				(seesaw cel: 0)
			)
		)
		(if (== gCurPuzzle 14)
			(gCurRoom
				addObstacle:
					((Polygon new:)
						type: PBarredAccess
						init: 0 0 319 0 319 99 278 108 207 89 283 68 279 65 201 85 144 72 84 33 84 7 48 7 49 43 119 93 0 93
						yourself:
					)
					((Polygon new:)
						type: PBarredAccess
						init: 0 181 251 179 301 141 319 135 319 189 0 189
						yourself:
					)
					((Polygon new:)
						type: PBarredAccess
						init: 0 96 22 96 22 117 0 117
						yourself:
					)
			)
			(flame1
				setCycle: Fwd
				init:
				setPri: 5
				ignoreActors:
				setScript: sCycleColors
			)
			(signGlow
				setCycle: Fwd
				cycleSpeed: 15
				init:
				ignoreActors:
				setPri: 5
			)
			(swing
				init:
				cel: 3
				setPri: 8
				stopUpd:
				ignoreActors:
				approachVerbs: 4 ; Do
			)
			(bigSwing init: approachVerbs: 4) ; Do
			(seesaw init: setPri: 5 stopUpd: ignoreActors: approachVerbs: 4 41) ; Do, Baking_Soda
			(if (not (IsFlag 61))
				(gCurRoom setScript: sEnterRoom)
			else
				(gGame handsOn:)
			)
		else
			(gCurRoom
				addObstacle:
					((Polygon new:)
						type: PBarredAccess
						init: 0 0 319 0 319 99 278 108 221 97 204 67 211 39 234 49 234 33 206 33 201 66 176 63 144 72 84 33 84 7 48 7 49 43 113 93 0 96
						yourself:
					)
					((Polygon new:)
						type: PBarredAccess
						init: 0 181 251 179 301 141 319 135 319 189 0 189
						yourself:
					)
					((Polygon new:)
						type: PBarredAccess
						init: 0 104 23 104 23 121 0 121
						yourself:
					)
			)
			(swing
				init:
				cel: 3
				setPri: 8
				stopUpd:
				ignoreActors:
				approachVerbs: 4 ; Do
			)
			(seesaw init: setPri: 5 ignoreActors: stopUpd: approachVerbs: 4 41) ; Do, Baking_Soda
			(burnedShell
				setPri: 5
				ignoreActors:
				init:
				stopUpd:
				approachVerbs: 4 ; Do
			)
			(gGame handsOn:)
		)
		(cond
			((== gCurPuzzle 14) 0)
			((== gPrevRoomNum 270)
				(gGameMusic2 fade: 127 30 12 0)
			)
			(else
				(gGameMusic2 number: 260 loop: -1 play:)
			)
		)
		(schoolDoor init: stopUpd:)
		(assayOffice init: approachVerbs: 4 setOnMeCheck: 1 1024) ; Do
		(school init: approachVerbs: 4 setOnMeCheck: 1 32) ; Do
		(buildings init: approachVerbs: 4 setOnMeCheck: 1 256) ; Do
		(street init: approachVerbs: 4 setOnMeCheck: 1 2) ; Do
		(slide init: approachVerbs: 4 setOnMeCheck: 1 4) ; Do
		(seesawBase init: approachVerbs: 4 setOnMeCheck: 1 8) ; Do
		(tree init: approachVerbs: 4 setOnMeCheck: 1 16) ; Do
		(windowPanes init: approachVerbs: 4 setOnMeCheck: 1 64) ; Do
		(roof init: approachVerbs: 4 setOnMeCheck: 1 128) ; Do
		(clutter init: approachVerbs: 4 setOnMeCheck: 1 512) ; Do
	)

	(method (doVerb theVerb)
		(switch theVerb
			(3 ; ???
				(if
					(or
						(not (gEgo cycler:))
						(and
							(gEgo cycler:)
							(== ((gEgo cycler:) firstC:) 3)
						)
					)
					(gCurRoom setScript: sStandUp)
				)
				(return 1)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)

	(method (newRoom newRoomNumber)
		(gWalkHandler delete: gCurRoom)
		(if (and (== newRoomNumber 320) (or (== gCurPuzzle 14) (== gCurPuzzle 15)))
			(proc0_15 1 16)
		)
		(super newRoom: newRoomNumber)
	)

	(method (dispose)
		(if (!= gCurPuzzle 14)
			(gGameMusic2 fade:)
		)
		(DisposeScript 991)
		(DisposeScript 12)
		(super dispose:)
	)
)

(instance sCycleColors of Script
	(properties)

	(method (doit)
		(Palette palANIMATE 228 233 1)
		(super doit: &rest)
	)
)

(instance sStandUp of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo
					view: 261
					setLoop: 8
					z: 0
					posn: 301 20
					setCel: 2
					setCycle: Beg self
				)
				(ClearFlag 82)
			)
			(1
				(swing show:)
				(gEgo
					normalize:
					state: 2
					posn: 293 70
					setPri: -1
					setScale: Scaler 100 50 175 95
					setSpeed: local3
					setMotion: MoveTo 273 72 self
				)
			)
			(2
				(bigSwing init: approachVerbs: 4) ; Do
				(gGame handsOn:)
				(swing stopUpd:)
				(gCurRoom horizon: 40)
				(gWalkHandler delete: gCurRoom)
				(self dispose:)
			)
		)
	)
)

(instance sFlingIt of Script
	(properties)

	(method (changeState newState &tmp temp0 temp1)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo setMotion: PolyPath 118 126 self)
			)
			(1
				(throwSound play:)
				(gEgo view: 261 setLoop: 0 cel: 0 setCycle: CT 1 1 self)
			)
			(2
				(gEgo setCycle: End)
				(= temp0 (Random 14 71))
				(= temp1 (Random 87 96))
				(bakingSoda
					x: 93
					y: 75
					init:
					setPri: 6
					ignoreActors:
					approachVerbs: 4 ; Do
					setCycle: Fwd
					setMotion: JumpTo temp0 temp1 self
				)
				(throwSound number: 2268 play:)
			)
			(3
				(gEgo normalize: loop: 7)
				(gCurRoom style: 100)
				(client
					cel: 0
					x: (bakingSoda x:)
					y: (bakingSoda y:)
					setPri: 6
					ignoreActors:
					setScale: -1 gEgo
					init:
					setCycle: End self
				)
				(bakingSoda dispose:)
			)
			(4
				(client stopUpd:)
				(= cycles 5)
			)
			(5
				(gMessager say: 15 41 0 0 self) ; "You try to get close enough to throw it, but are forced back by the extreme heat and accomplish nothing but a large white splat on the ground."
			)
			(6
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sEnterRoom of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(= cycles 10)
			)
			(1
				(SetFlag 61)
				(Face gEgo flame1)
				(= cycles 5)
			)
			(2
				(gMessager say: 14 0 0 0 self) ; "The Old Abandoned Assay Office is ablaze, threatening to burn down not only itself and your pharmacy, but the whole town!"
			)
			(3
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sEgoSwings of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(LoadMany rsSOUND 2266)
				(bigSwing dispose:)
				(gCurRoom horizon: 0)
				(= local3 (gEgo cycleSpeed:))
				(gEgo setSpeed: 7 setMotion: MoveTo 301 80 self)
			)
			(1
				(swing hide:)
				(gEgo
					view: 261
					setLoop: 8
					posn: 301 20
					cel: 0
					state: 0
					setScale: 0
					setCycle: End self
				)
				(gTheIconBar disable: 0 1 3 5)
				(SetFlag 82)
			)
			(2
				(gEgo
					view: 261
					setLoop: 1
					cel: 3
					posn: 300 100
					z: 80
					cycleSpeed: 10
					setPri: 6
				)
				(gWalkHandler addToFront: gCurRoom)
				(gGame handsOn:)
				(gUser canControl: 0)
				(self dispose:)
			)
		)
	)
)

(instance sLandInSwamp of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gWalkHandler delete: gCurRoom)
				(gEgo setCycle: End self)
			)
			(1
				(gEgo hide:)
				(swing show: setCycle: Swing 1 1 2265 1)
				(jumpSound number: 2266 play:)
				(= seconds 3)
			)
			(2
				(ShakeScreen 10)
				(= seconds 3)
			)
			(3
				(= global122 7)
				(gCurRoom newRoom: 99) ; deathRoom
				(self dispose:)
			)
		)
	)
)

(instance sHitWall of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gWalkHandler delete: gCurRoom)
				(if
					(or
						(== (gEgo cel:) ((gEgo cycler:) lastC:))
						(and
							(!= (gEgo cel:) ((gEgo cycler:) lastC:))
							(== ((gEgo cycler:) cycleDir:) 1)
						)
					)
					(gEgo setCycle: End self)
				else
					(= cycles 1)
				)
			)
			(1
				(gEgo setCycle: Beg self)
			)
			(2
				(gEgo loop: 2 z: 0 cel: 0 posn: 257 33 setCycle: CT 1 1 self)
				(swing show: setCycle: Swing 1 1 2265 1)
				(jumpSound number: 2266 play:)
			)
			(3
				(gEgo setLoop: 3 posn: 273 33 cel: 0 setCycle: CT 2 1 self)
			)
			(4
				(ShakeScreen 10)
				(= ticks 80)
			)
			(5
				(gEgo setCycle: End self)
			)
			(6
				(= global122 9)
				(gCurRoom newRoom: 99) ; deathRoom
				(self dispose:)
			)
		)
	)
)

(instance sJumpToRoof of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gWalkHandler delete: gCurRoom)
				(if
					(or
						(== (gEgo cel:) ((gEgo cycler:) lastC:))
						(and
							(!= (gEgo cel:) ((gEgo cycler:) lastC:))
							(== ((gEgo cycler:) cycleDir:) 1)
						)
					)
					(gEgo setCycle: End self)
				else
					(= cycles 1)
				)
			)
			(1
				(gEgo setCycle: Beg self)
			)
			(2
				(jumpSound number: 2266 play:)
				(gEgo setLoop: 2 z: 0 cel: 0 posn: 256 27 setCycle: End self)
				(swing show: setCycle: Swing 1 1 2265 1)
			)
			(3
				(gEgo
					normalize:
					setSpeed: local3
					posn: 242 28
					setScale: Scaler 100 50 175 95
				)
				(= seconds 2)
			)
			(4
				(gTheIconBar enable: 2)
				(gTheIconBar curIcon: (gTheIconBar at: 2))
				(gGame setCursor: 2)
				(gUser canControl: 1)
				(gUser input: 1)
				(= local0 1)
				(gGame points: 5)
				(ClearFlag 82)
				(gCurRoom horizon: 0)
				(self dispose:)
			)
		)
	)
)

(instance sEgoJumps of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gTimers delete: (ScriptID 0 13)) ; deathTimer
				(switch register
					(2
						(Load rsVIEW 266)
						(gEgo setMotion: MoveTo 246 20 self)
					)
					(1
						(gEgo setMotion: MoveTo 273 18 self)
					)
					(0
						(gEgo setMotion: MoveTo 232 23 self)
					)
				)
			)
			(1
				(gEgo
					setScale: 0
					setPri: 6
					view: 261
					setLoop: (if register 4 else 7)
					setCel: 0
					setCycle: CT 4 1 self
				)
			)
			(2
				(jumpSound number: 2267 play:)
				(gEgo setCycle: CT 8 1 self)
			)
			(3
				(switch register
					(0
						(= local0 0)
						(gEgo setCycle: End self)
					)
					(1
						(gEgo setCycle: End)
						(jumpSound number: 2268 play:)
						(bakingSoda
							view: 261
							setLoop: 5
							setCycle: Fwd
							setMotion: JumpTo 256 57 self
						)
						(if (< (seesaw cel:) 2)
							(seesaw setCycle: End)
						)
					)
					(2
						(gEgo state: 2 setCycle: End)
						(jumpSound number: 2268 play:)
						(bakingSoda setCycle: Fwd setMotion: JumpTo 46 14 self)
						(= local0 0)
						(if (> (seesaw cel:) 0)
							(seesaw setCycle: Beg)
						)
						(++ gCurPuzzle)
					)
				)
			)
			(4
				(switch register
					(1
						(gEgo
							posn: 263 85
							setScale: Scaler 100 50 175 95
							normalize:
						)
						(= cycles 2)
					)
					(2
						(gEgo
							posn: 236 87
							setScale: Scaler 100 50 175 95
							normalize:
						)
						(= cycles 2)
					)
					(0
						(= global122 9)
						(gCurRoom newRoom: 99) ; deathRoom
					)
				)
			)
			(5
				(switch register
					(1
						(bakingSoda hide:)
						(gEgo
							view: 261
							loop: 6
							cel: 0
							setScale: 0
							setCycle: End self
						)
					)
					(2
						((gCurRoom obstacles:) delete: dispose:)
						(bakingSoda dispose:)
						(jumpSound number: 2264 play:)
						(splatter
							view: 266
							loop: 0
							cel: 0
							x: 25
							y: 43
							init:
							setPri: 14
							setCycle: CT 5 1 self
						)
					)
				)
			)
			(6
				(if (== register 1)
					(= global122 9)
					(gCurRoom newRoom: 99) ; deathRoom
				else
					(burnedShell init: stopUpd: approachVerbs: 4 setPri: 5) ; Do
					(splatter setCycle: End self)
					(seesaw stopUpd:)
					(ClearFlag 64)
					(flame1 dispose:)
					(signGlow dispose:)
					(UnLoad 128 264)
					(gCurRoom
						addObstacle:
							((Polygon new:)
								type: PBarredAccess
								init: 0 0 319 0 319 99 278 108 221 97 204 67 211 39 234 49 234 33 206 33 201 66 176 63 144 72 84 33 84 7 48 7 49 43 113 93 0 96
								yourself:
							)
							((Polygon new:)
								type: PBarredAccess
								init: 0 181 251 179 301 141 319 135 319 189 0 189
								yourself:
							)
							((Polygon new:)
								type: PBarredAccess
								init: 0 104 23 104 23 121 0 121
								yourself:
							)
					)
					(gGameMusic1 fade:)
					(gCurRoom horizon: 40)
				)
			)
			(7
				(splatter dispose:)
				(= cycles 3)
			)
			(8
				(gGameMusic2 number: 2701 loop: 1 play: self)
			)
			(9
				(gGameMusic2 number: 260 loop: -1 play:)
				(gMessager say: 23 0 0 0 self) ; "What pluck! What prowess! What a ridiculous solution!"
				(gGame points: 12)
			)
			(10
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance splatter of Prop
	(properties
		noun 22
		view 262
	)
)

(instance bakingSoda of Actor
	(properties
		noun 24
		approachX 251
		approachY 101
		view 260
		loop 1
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(if (or local0 (IsFlag 82))
					(gMessager say: noun theVerb 18) ; "You can't reach the baking soda from way up here!"
				else
					(gEgo get: -1 0 2 self) ; Baking_Soda
					(ClearFlag 64)
					(ClearFlag 7)
					(ClearFlag 8)
				)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance seesaw of Prop
	(properties
		x 252
		y 79
		z -2
		noun 4
		approachX 251
		approachY 101
		view 260
		loop 2
	)

	(method (handleEvent event)
		(if (IsFlag 82)
			(super handleEvent: event)
		else
			(= local1 (event x:))
			(super handleEvent: event)
		)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(41 ; Baking_Soda
				(if (and (== gCurPuzzle 14) (not local0) (not (IsFlag 82)))
					(SetFlag 64)
					(if (> local1 250)
						(SetFlag 8)
						(gGame points: 2 153)
						(bakingSoda posn: 260 80)
						(if (< cel 2)
							(self setCycle: End)
						)
					else
						(SetFlag 7)
						(bakingSoda posn: 233 80)
						(if (> cel 0)
							(self setCycle: Beg)
						)
					)
					(bakingSoda init: ignoreActors: approachVerbs: 4 setPri: 6) ; Do
					(gEgo put: 0) ; Baking_Soda
				else
					(super doVerb: theVerb &rest)
				)
			)
			(4 ; Do
				(cond
					((IsFlag 82)
						(gMessager say: noun 4 19) ; "You're not quite skillful enough to make a perfect three-point landing from the swing to the seesaw without breaking every bone in your body."
					)
					(local0
						(cond
							((IsFlag 7)
								(gCurRoom setScript: sEgoJumps 0 1)
							)
							((IsFlag 8)
								(gCurRoom setScript: sEgoJumps 0 2)
							)
							(else
								(gCurRoom setScript: sEgoJumps 0 0)
							)
						)
					)
					((== gCurPuzzle 14)
						(if (and (not (IsFlag 7)) (not (IsFlag 8)))
							(gMessager say: noun theVerb 2) ; "Of course you want to play on the children's equipment, don't you? But shouldn't you put out the fire first?"
						else
							(super doVerb: theVerb &rest)
						)
					)
					(else
						(super doVerb: theVerb &rest)
					)
				)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance swing of Prop
	(properties
		x 300
		y 60
		z 40
		noun 3
		approachX 271
		approachY 74
		view 260
		loop 4
		signal 4096
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(if (and (not (IsFlag 82)) (not local0) (== gCurPuzzle 14))
					(gCurRoom setScript: sEgoSwings)
				else
					(super doVerb: theVerb &rest)
				)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance flame1 of Prop
	(properties
		x 1
		y 48
		noun 15
		view 264
		cycleSpeed 10
		detailLevel 2
	)

	(method (doVerb theVerb)
		(switch theVerb
			(41 ; Baking_Soda
				(if (and (not local0) (not (IsFlag 82)))
					((splatter new:) setScript: sFlingIt)
				else
					(gMessager say: noun theVerb 19) ; "You're too uncoordinated to heave the baking soda AND hold onto the swing at the same time."
				)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance signGlow of Prop
	(properties
		x 3
		y 7
		view 264
		loop 2
		priority 14
		signal 16
		detailLevel 2
	)
)

(instance schoolDoor of Door
	(properties
		x 210
		y 60
		noun 2
		approachX 199
		approachY 70
		view 260
		locked 1
		openSnd 2146
		closeSnd 2147
		openVerb 4
		moveToX 227
		moveToY 39
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(gMessager say: noun theVerb) ; "Penelope keeps this door locked all the time, to keep the kids in and the rabble out."
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance burnedShell of View
	(properties
		x 1
		y 2
		noun 11
		approachX 84
		approachY 98
		approachDist 76
		view 265
	)
)

(instance bigSwing of Feature
	(properties
		x 302
		y 81
		z 40
		noun 3
		nsTop 20
		nsLeft 294
		nsBottom 67
		nsRight 311
		approachX 271
		approachY 74
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(gCurRoom setScript: sEgoSwings)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance assayOffice of Feature
	(properties
		x 38
		y 44
		noun 11
		sightAngle 40
		approachX 84
		approachY 98
		approachDist 76
	)

	(method (doVerb theVerb &tmp temp0)
		(if (== gCurPuzzle 14)
			(= temp0 4)
		else
			(= temp0 6)
		)
		(if (OneOf theVerb 1 4) ; Look, Do
			(gMessager say: noun theVerb temp0)
		else
			(super doVerb: theVerb &rest)
		)
	)
)

(instance school of Feature
	(properties
		x 247
		y 28
		noun 12
		sightAngle 40
		approachX 200
		approachY 84
		approachDist 80
	)

	(method (handleEvent event)
		(if
			(and
				(== (gTheIconBar curIcon:) (gTheIconBar at: 2))
				(== (gInventory state:) 2048)
				(IsFlag 82)
				(not
					(or
						(not (gEgo cycler:))
						(and
							(gEgo cycler:)
							(== ((gEgo cycler:) firstC:) 3)
						)
					)
				)
			)
			(event claimed: 1)
			(cond
				(
					(or
						(== (gEgo cel:) ((gEgo cycler:) firstC:))
						(and
							(!= (gEgo cel:) ((gEgo cycler:) firstC:))
							(== ((gEgo cycler:) cycleDir:) -1)
						)
					)
					(gEgo setScript: sHitWall)
				)
				(
					(or
						(== (gEgo cel:) ((gEgo cycler:) lastC:))
						(and
							(!= (gEgo cel:) ((gEgo cycler:) lastC:))
							(== ((gEgo cycler:) cycleDir:) 1)
						)
					)
					(gEgo setScript: sLandInSwamp)
				)
			)
		else
			(super handleEvent: event)
		)
	)
)

(instance buildings of Feature
	(properties
		x 130
		y 21
		noun 13
		sightAngle 40
		approachX 112
		approachY 61
		approachDist 49
	)
)

(instance street of Feature
	(properties
		x 130
		y 21
		noun 5
		sightAngle 40
		approachX 112
		approachY 61
		approachDist 49
	)
)

(instance slide of Feature
	(properties
		x 130
		y 21
		noun 6
		sightAngle 40
		approachX 112
		approachY 61
		approachDist 49
	)
)

(instance seesawBase of Feature
	(properties
		x 130
		y 21
		noun 4
		sightAngle 40
		approachX 251
		approachY 101
		approachDist 49
	)

	(method (doVerb theVerb)
		(switch theVerb
			(41 ; Baking_Soda
				(if (and (== gCurPuzzle 14) (not local0) (not (IsFlag 82)))
					(SetFlag 64)
					(if (> local1 250)
						(SetFlag 8)
						(bakingSoda posn: 233 80)
					else
						(SetFlag 7)
						(bakingSoda posn: 260 72)
					)
					(bakingSoda init: ignoreActors: setPri: 6)
					(gEgo put: 0) ; Baking_Soda
				else
					(super doVerb: theVerb &rest)
				)
			)
			(4 ; Do
				(cond
					((IsFlag 82)
						(gMessager say: noun 4 19) ; "You're not quite skillful enough to make a perfect three-point landing from the swing to the seesaw without breaking every bone in your body."
					)
					(local0
						(cond
							((IsFlag 7)
								(gCurRoom setScript: sEgoJumps 0 1)
							)
							((IsFlag 8)
								(gCurRoom setScript: sEgoJumps 0 2)
							)
							(else
								(gCurRoom setScript: sEgoJumps 0 0)
							)
						)
					)
					((== gCurPuzzle 14)
						(if (and (not (IsFlag 7)) (not (IsFlag 8)))
							(gMessager say: noun theVerb 2) ; "Of course you want to play on the children's equipment, don't you? But shouldn't you put out the fire first?"
						else
							(super doVerb: theVerb &rest)
						)
					)
					(else
						(super doVerb: theVerb &rest)
					)
				)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance tree of Feature
	(properties
		x 130
		y 21
		noun 7
		sightAngle 40
		approachX 216
		approachY 108
		approachDist 49
	)

	(method (handleEvent event)
		(if (and (IsFlag 82) (< 30 (event y:) 62))
			(event claimed: 1)
		else
			(super handleEvent: event)
		)
	)
)

(instance windowPanes of Feature
	(properties
		x 130
		y 21
		noun 8
		sightAngle 40
		approachX 200
		approachY 84
		approachDist 49
	)

	(method (handleEvent event)
		(if
			(and
				(== (gTheIconBar curIcon:) (gTheIconBar at: 2))
				(== (gInventory state:) 2048)
				(IsFlag 82)
				(not
					(or
						(not (gEgo cycler:))
						(and
							(gEgo cycler:)
							(== ((gEgo cycler:) firstC:) 3)
						)
					)
				)
			)
			(event claimed: 1)
			(cond
				(
					(or
						(== (gEgo cel:) ((gEgo cycler:) firstC:))
						(and
							(!= (gEgo cel:) ((gEgo cycler:) firstC:))
							(== ((gEgo cycler:) cycleDir:) -1)
						)
					)
					(gEgo setScript: sHitWall)
				)
				(
					(or
						(== (gEgo cel:) ((gEgo cycler:) lastC:))
						(and
							(!= (gEgo cel:) ((gEgo cycler:) lastC:))
							(== ((gEgo cycler:) cycleDir:) 1)
						)
					)
					(gEgo setScript: sLandInSwamp)
				)
			)
		else
			(super handleEvent: event)
		)
	)
)

(instance roof of Feature
	(properties
		x 130
		y 21
		noun 9
		sightAngle 40
		approachX 200
		approachY 84
		approachDist 49
	)

	(method (handleEvent event)
		(if
			(and
				(== (gTheIconBar curIcon:) (gTheIconBar at: 2))
				(== (gInventory state:) 2048)
				(IsFlag 82)
				(not
					(or
						(not (gEgo cycler:))
						(and
							(gEgo cycler:)
							(== ((gEgo cycler:) firstC:) 3)
						)
					)
				)
			)
			(event claimed: 1)
			(cond
				(
					(and
						(== ((gEgo cycler:) firstC:) 0)
						(or
							(== (gEgo cel:) ((gEgo cycler:) firstC:))
							(and
								(!= (gEgo cel:) ((gEgo cycler:) firstC:))
								(== ((gEgo cycler:) cycleDir:) -1)
							)
						)
					)
					(gEgo setScript: sJumpToRoof)
				)
				(
					(and
						(or
							(== ((gEgo cycler:) firstC:) 1)
							(== ((gEgo cycler:) firstC:) 2)
						)
						(or
							(== (gEgo cel:) ((gEgo cycler:) firstC:))
							(and
								(!= (gEgo cel:) ((gEgo cycler:) firstC:))
								(== ((gEgo cycler:) cycleDir:) -1)
							)
						)
					)
					(gEgo setScript: sHitWall)
				)
				(
					(or
						(== (gEgo cel:) ((gEgo cycler:) lastC:))
						(and
							(!= (gEgo cel:) ((gEgo cycler:) lastC:))
							(== ((gEgo cycler:) cycleDir:) 1)
						)
					)
					(gEgo setScript: sLandInSwamp)
				)
			)
		else
			(super handleEvent: event)
		)
	)
)

(instance clutter of Feature
	(properties
		x 130
		y 21
		noun 10
		sightAngle 40
		approachX 160
		approachY 138
		approachDist 49
	)
)

(instance throwSound of FPSound
	(properties
		flags 1
		number 2264
	)
)

(instance fireSound of FPSound ; UNUSED
	(properties
		flags 1
		number 2269
	)
)

(instance jumpSound of FPSound
	(properties
		flags 1
		number 2266
	)
)

