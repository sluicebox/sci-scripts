;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 400)
(include sci.sh)
(use Main)
(use OccasionalCycle)
(use eRS)
(use Inset)
(use Scaler)
(use RandCycle)
(use Polygon)
(use Feature)
(use Door)
(use LoadMany)
(use Motion)
(use Actor)
(use System)

(public
	rm400 0
)

(local
	local0
	local1
	local2 = 1
)

(instance rm400 of FPRoom
	(properties
		noun 20
		picture 400
		style 100
		horizon 83
		north 220
	)

	(method (init)
		(LoadMany rsVIEW 401 402)
		(if (== gCurPuzzle 22)
			(self setRegions: 91) ; rowdyRgn
		)
		(gEgo init: normalize: setScale: Scaler 95 47 182 126)
		(switch gPrevRoomNum
			(north
				(gEgo x: 210 y: 90)
				(if (and (== gCurPuzzle 15) (not (IsFlag 9)))
					(LoadMany rsVIEW 400 403)
					(banker
						init:
						approachVerbs: 2 ; Talk
						setCycle: OccasionalCycle 1 45 200 2 8
						setScale: -1 gEgo
					)
					(sheriff
						init:
						approachVerbs: 2 ; Talk
						setCycle: OccasionalCycle 1 45 200 2 8
						setScale: -1 gEgo
					)
					(gCurRoom setScript: sOverhearBaddies)
				else
					(gGame handsOn:)
				)
			)
			(410
				(gEgo edgeHit: EDGE_NONE)
				(gEgo heading: 180)
				(gGame handsOn:)
			)
			(235
				(gCurRoom setScript: sAfterROFL)
			)
			(680
				(gGame handsOn:)
			)
			(else
				(= style 100)
				(gEgo x: 160 y: 160)
				(gGame handsOn:)
			)
		)
		(super init:)
		(if (and (!= gCurPuzzle 22) (!= gCurPuzzle 14) (!= gPrevRoomNum 410))
			(gGameMusic1 number: 410 loop: -1 play: setVol: 100)
		)
		(gCurRoom
			addObstacle:
				((Polygon new:)
					type: PBarredAccess
					init: 2 180 63 180 155 172 229 162 289 170 301 164 214 156 181 166 217 80 217 0 319 0 319 189 0 189 0 0 198 0 190 93 155 144 42 147 42 139 70 127 90 127 90 124 69 124 36 136 29 146 3 146
					yourself:
				)
		)
		(frontDoor init: stopUpd:)
		(if (and (!= gPrevRoomNum 235) (== gCurPuzzle 22) (IsFlag 33))
			(cannister init: stopUpd: ignoreActors:)
			(glint init: hide: stopUpd: setScript: sRandomTwinkle)
		)
		(bankRoof init: setOnMeCheck: 1 4)
		(brothel init: setOnMeCheck: 1 8)
		(cactus init: setOnMeCheck: 1 32)
		(clutter init: setOnMeCheck: 1 64)
		(fence init: setOnMeCheck: 1 128)
		(gazebo init: setOnMeCheck: 1 256)
		(momsFront init: setOnMeCheck: 1 512)
		(saloonFront init: setOnMeCheck: 1 1024)
		(smithie init: setOnMeCheck: 1 2048)
		(window1 init: setOnMeCheck: 1 16)
		(window2 init: setOnMeCheck: 1 16)
		(window3 init: setOnMeCheck: 1 16)
		(window4 init: setOnMeCheck: 1 16)
		(window5 init: setOnMeCheck: 1 16)
		(window6 init: setOnMeCheck: 1 16)
		(window7 init: setOnMeCheck: 1 16)
		(signPost setCycle: OccasionalCycle 1 45 200 2 8 init:)
		(tree1
			setCycle: OccasionalCycle 1 30 120 1 10
			init:
			ignoreActors:
			setPri: 15
		)
		(if (and (== gPrevRoomNum north) (== gCurPuzzle 15) (not (IsFlag 9)))
			(tree2 init: ignoreActors: stopUpd: setPri: 14)
			(tree3 init: ignoreActors: stopUpd: setPri: 14)
		else
			(tree2
				setCycle: OccasionalCycle -1 40 160 2 15
				init:
				ignoreActors:
				setPri: 15
			)
			(tree3
				setCycle: OccasionalCycle 1 20 100 2 8
				init:
				ignoreActors:
				setPri: 15
			)
		)
		(bunting init:)
		(if (IsFlag 1)
			(glow setCycle: RandCycle init:)
		else
			(curtains setCycle: OccasionalCycle 1 30 120 1 5 init:)
		)
		(if (== gPrevRoomNum 410)
			(Animate (gCast elements:) 1)
			(proc0_15 0 16)
		)
	)

	(method (dispose)
		(if (and (!= gCurPuzzle 14) (!= gNewRoomNum 410))
			(gGameMusic1 fade:)
		)
		(DisposeScript 32)
		(super dispose:)
	)
)

(instance sMiss of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo view: 402 cel: 0 setCycle: End self)
			)
			(1
				(puff x: (Random 260 319) y: (Random 21 31) init: show:)
				(= ticks 30)
			)
			(2
				(puff hide: stopUpd:)
				(= cycles 2)
			)
			(3
				(gMessager say: 7 47 0 0 self) ; "You take careful aim with your pistol, slowly squeeze off a shot..."
			)
			(4
				(gEgo normalize:)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sAfterROFL of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGameMusic2 stop:)
				(gGameMusic1 number: 410 loop: -1 play: setVol: 100)
				(SetFlag 83)
				(= seconds 2)
			)
			(1
				(gMessager say: 6 0 4 0 self) ; "Yiparooni, Freddy done made them cowhands laugh themselves to death with a well-placed bullet."
			)
			(2
				(++ gCurPuzzle)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sShotTheCannister of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(signPost setCycle: Beg)
				(gEgo view: 402 cel: 0 setCycle: End self)
			)
			(1
				(gMessager say: 5 47 0 1 self) ; "You take careful aim with your pistol, slowly squeeze off a shot..."
			)
			(2
				(gunSound play: self)
			)
			(3
				(gMessager say: 5 47 0 2 self) ; "You did it! You shot off the canister's valve."
			)
			(4
				(gGame points: 20 146)
				(cannister setLoop: 2 setCycle: Fwd)
				(= cycles 1)
			)
			(5
				(= ticks 180)
			)
			(6
				(gCurRoom newRoom: 235)
				(self dispose:)
			)
		)
	)
)

(instance sRandomTwinkle of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(glint stopUpd:)
				(= seconds (Random 8 20))
			)
			(1
				(glint show:)
				(= cycles 5)
			)
			(2
				(glint hide:)
				(self changeState: 0)
			)
		)
	)
)

(instance sOverhearBaddies of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= cycles 5)
			)
			(1
				(gGameMusic1 fade: 0 2 1 0)
				(gGameMusic2 number: 703 loop: -1 play: setVol: 0 fade: 100 2 1 0)
				(= cycles 10)
			)
			(2
				(gMessager say: 3 0 0 0 self) ; "The boss is more than a little upset. Seems that our "friend" has been thwarting every plan so far."
			)
			(3
				(gGameMusic1 fade: 127 3 1 0)
				(gGameMusic2 fade: 0 3 1 1)
				(SetFlag 9)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance banker of Prop
	(properties
		x 118
		y 135
		noun 4
		view 403
		cycleSpeed 10
		detailLevel 2
	)

	(method (doVerb theVerb &tmp temp0)
		(switch theVerb
			(2 ; Talk
				(if (< local0 3)
					(++ local0)
				)
				(switch local0
					(1
						(= temp0 8)
					)
					(2
						(= temp0 9)
					)
					(else
						(= temp0 10)
					)
				)
				(gMessager say: noun theVerb temp0)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance sheriff of Prop
	(properties
		x 95
		y 134
		noun 10
		view 403
		loop 1
		cycleSpeed 10
		detailLevel 2
	)

	(method (doVerb theVerb &tmp temp0)
		(switch theVerb
			(2 ; Talk
				(if (< local1 3)
					(++ local1)
				)
				(switch local1
					(1
						(= temp0 8)
					)
					(2
						(= temp0 9)
					)
					(else
						(= temp0 10)
					)
				)
				(gMessager say: noun theVerb temp0)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance frontDoor of Door
	(properties
		x 64
		y 122
		noun 1
		approachX 67
		approachY 127
		view 400
		entranceTo 410
		lockedCase 6
		openSnd 2146
		closeSnd 2147
		openVerb 4
		moveToX 89
		moveToY 126
		enterType 0
		exitType 0
	)

	(method (init)
		(super init:)
		(if (== gCurPuzzle 14)
			(= noun 2)
		)
		(= locked
			(if
				(or
					(and (> gCurPuzzle 14) (not (IsFlag 107)))
					(== gCurPuzzle 15)
				)
				0
			else
				1
			)
		)
	)

	(method (cue)
		(if (== doorState 1)
			(proc0_15 1 16)
		)
		(super cue:)
	)
)

(instance signPost of Prop
	(properties
		x 16
		y 114
		noun 11
		view 400
		loop 1
		detailLevel 2
	)

	(method (cue)
		(= local2 1)
	)

	(method (doit)
		(if (and (== cel (self lastCel:)) local2)
			(= local2 0)
			(signSound play: self)
		)
		(super doit:)
	)
)

(instance tree1 of Prop
	(properties
		x 22
		y 63
		noun 12
		view 400
		loop 2
		signal 4096
		detailLevel 2
	)
)

(instance tree2 of Prop
	(properties
		x 280
		y 14
		noun 12
		view 400
		loop 3
		cel 2
		signal 4096
		detailLevel 2
	)
)

(instance tree3 of Prop
	(properties
		x 282
		y 64
		noun 12
		view 400
		loop 4
		cel 2
		signal 4096
		detailLevel 2
	)
)

(instance curtains of Prop
	(properties
		x 101
		y 68
		noun 13
		view 400
		loop 5
		detailLevel 2
	)
)

(instance glow of Prop
	(properties
		x 101
		y 68
		noun 14
		view 400
		loop 6
		detailLevel 2
	)
)

(instance glint of Prop
	(properties
		x 290
		y 17
		noun 5
		view 401
		loop 1
		signal 16384
		detailLevel 2
	)
)

(instance puff of View
	(properties
		x 295
		y 19
		view 400
		loop 7
		cel 1
	)
)

(instance bigCannister of View
	(properties
		x 160
		y 41
		noun 9
		view 71
		loop 1
	)

	(method (doVerb theVerb)
		(switch theVerb
			(47 ; Pistols
				(gMessager say: 5 47 11) ; "Oh, no you don't! You can't shoot the canister the EASY way, from up close!"
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance cannister of Prop
	(properties
		x 290
		y 17
		noun 5
		view 401
		detailLevel 2
	)

	(method (doVerb theVerb)
		(switch theVerb
			(47 ; Pistols
				(cond
					((IsFlag 83)
						(gMessager say: 7 theVerb 4) ; "There's no longer any need to shoot at the bunting."
					)
					((proc0_1 gEgo 2)
						(gCurRoom setScript: sShotTheCannister)
					)
					(else
						(gMessager say: noun theVerb 2) ; "Good idea, but you just don't have a straight shot from here."
					)
				)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance bankRoof of Feature
	(properties
		x 87
		y 13
		noun 23
		sightAngle 40
	)
)

(instance brothel of Feature
	(properties
		x 73
		y 84
		noun 15
		sightAngle 40
		approachX 73
		approachY 84
	)
)

(instance cactus of Feature
	(properties
		x 36
		y 175
		noun 19
		sightAngle 40
		approachX 36
		approachY 175
	)
)

(instance clutter of Feature
	(properties
		x 246
		y 47
		noun 21
		sightAngle 40
	)
)

(instance fence of Feature
	(properties
		x 145
		y 182
		noun 18
		sightAngle 40
		approachX 145
		approachY 182
	)
)

(instance gazebo of Feature
	(properties
		x 271
		y 127
		noun 17
		sightAngle 40
		approachX 271
		approachY 127
	)
)

(instance momsFront of Feature
	(properties
		x 236
		y 18
		noun 25
		sightAngle 40
	)
)

(instance saloonFront of Feature
	(properties
		x 188
		y 24
		noun 24
		sightAngle 40
	)
)

(instance smithie of Feature
	(properties
		x 25
		y 17
		noun 22
		sightAngle 40
	)
)

(instance window1 of Feature
	(properties
		x 49
		y 62
		noun 16
		sightAngle 40
		approachX 49
		approachY 62
	)
)

(instance window2 of Feature
	(properties
		x 89
		y 61
		noun 16
		sightAngle 40
		approachX 89
		approachY 61
	)
)

(instance window3 of Feature
	(properties
		x 106
		y 59
		noun 16
		sightAngle 40
		approachX 106
		approachY 59
	)
)

(instance window4 of Feature
	(properties
		x 126
		y 59
		noun 16
		sightAngle 40
		approachX 126
		approachY 59
	)
)

(instance window5 of Feature
	(properties
		x 96
		y 108
		noun 16
		sightAngle 40
		approachX 96
		approachY 108
	)
)

(instance window6 of Feature
	(properties
		x 112
		y 107
		noun 16
		sightAngle 40
		approachX 112
		approachY 107
	)
)

(instance window7 of Feature
	(properties
		x 131
		y 108
		noun 16
		sightAngle 40
		approachX 131
		approachY 108
	)
)

(instance bunting of Feature
	(properties
		x 289
		y 26
		noun 7
		nsTop 21
		nsLeft 260
		nsBottom 31
		nsRight 319
		sightAngle 40
	)

	(method (doVerb theVerb)
		(switch theVerb
			(1 ; Look
				(cond
					((IsFlag 1)
						(gMessager say: noun theVerb 1) ; "It's too dark for you to make out any details of that thing hanging from the hotel balcony."
					)
					((< (gEgo x:) 145)
						(gMessager say: noun theVerb 2) ; "You can't see through hotel through the brothel. You left your X-Ray glasses at the Pharmacy!"
					)
					(else
						(gCurRoom setInset: inBunting)
					)
				)
			)
			(47 ; Pistols
				(cond
					((not (gCast contains: cannister))
						(gMessager say: noun theVerb 5) ; "You're just going to take potshots at the hotel from here?"
					)
					((IsFlag 83)
						(gMessager say: noun theVerb 4) ; "There's no longer any need to shoot at the bunting."
					)
					((proc0_1 gEgo 2)
						(gCurRoom setScript: sMiss)
					)
					(else
						(gMessager say: noun theVerb 2) ; "Good idea, but you just don't have a straight shot from here."
					)
				)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance gunSound of FPSound
	(properties
		flags 1
		number 2101
	)
)

(instance signSound of FPSound
	(properties
		flags 1
		number 2951
	)
)

(instance inBunting of Inset
	(properties
		picture 235
		hideTheCast 1
		noun 8
	)

	(method (doVerb theVerb)
		(switch theVerb
			(1 ; Look
				(if (IsFlag 33)
					(gMessager say: noun theVerb 3) ; "You can see the bunting on the Hotel balcony clear as day from here. The canister of nitrous oxide is sitting on the top rail, just minding its own business."
				else
					(gMessager say: noun theVerb 5) ; "The bunting is clearly advertising an Open Mike Night for comedians at Mom's Cafe."
				)
			)
			(8 ; icon10
				(self dispose:)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)

	(method (init)
		(super init: &rest)
		(gGameMusic2 mute: 0 6)
		(proc0_8 1)
		(if (and (== gCurPuzzle 22) (IsFlag 33))
			(bigCannister stopUpd: init:)
		)
	)

	(method (dispose)
		(proc0_8 0)
		(gGameMusic2 mute: 1 6)
		(bigCannister dispose:)
		(super dispose:)
	)
)

