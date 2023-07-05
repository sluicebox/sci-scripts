;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 630)
(include sci.sh)
(use Main)
(use eRS)
(use Inset)
(use Scaler)
(use Polygon)
(use Feature)
(use LoadMany)
(use StopWalk)
(use Motion)
(use Actor)
(use System)

(public
	rm630 0
)

(local
	local0
	local1
	local2
	local3
	local4
	local5
)

(instance rm630 of FPRoom
	(properties
		noun 1
		style 100
		south 610
	)

	(method (init)
		(if (IsFlag 58)
			(self picture: 780)
		else
			(self picture: 630)
		)
		(gEgo init: setScale: Scaler 105 84 155 108 normalize:)
		(switch gPrevRoomNum
			(south
				(if (IsFlag 58)
					(ClearFlag 44)
					(ClearFlag 40)
					(ClearFlag 42)
					(ClearFlag 41)
					(ClearFlag 43)
					(gCurRoom setScript: sGetReady)
				else
					(gCurRoom setScript: sEnterFromSouth)
				)
			)
			(680
				(gGame handsOn:)
			)
			(26 ; actBreak
				(if (IsFlag 80)
					(ClearFlag 80)
					(gGame handsOn:)
				else
					(LoadMany rsSCRIPT 1814)
					(LoadMany rsSCRIPT 1800)
					(gCurRoom setScript: sSepiaStart)
				)
			)
			(else
				(cond
					((IsFlag 58)
						(ClearFlag 44)
						(ClearFlag 40)
						(ClearFlag 42)
						(ClearFlag 41)
						(ClearFlag 43)
						(gCurRoom setScript: sGetReady)
					)
					((== gCurPuzzle 14)
						(ClearFlag 44)
						(ClearFlag 40)
						(ClearFlag 42)
						(ClearFlag 41)
						(ClearFlag 43)
						(gCurRoom setScript: sCoarsegoldBurns)
					)
					(else
						(gEgo x: 140 y: 150)
						(gGame handsOn:)
					)
				)
			)
		)
		(super init:)
		(cond
			((== gCurPuzzle 14) 0)
			((== gPrevRoomNum 26) 0) ; actBreak
			((IsFlag 58)
				(gGameMusic1 number: 638 loop: -1 play:)
			)
			(else
				(gGameMusic1 number: 630 loop: -1 play:)
			)
		)
		(gCurRoom
			addObstacle:
				(if (IsFlag 43)
					(= local5
						((Polygon new:)
							type: PBarredAccess
							init: 263 149 208 145 213 110 162 110 148 121 152 143 136 143 132 139 133 133 103 133 90 140 126 140 120 147 0 147 0 0 319 0 319 189 0 189 0 154 264 154
							yourself:
						)
					)
				else
					(= local3
						((Polygon new:)
							type: PBarredAccess
							init: 263 149 247 146 226 110 162 110 148 121 152 143 136 143 132 139 133 133 103 133 90 140 126 140 120 147 0 147 0 0 319 0 319 189 0 189 0 154 264 154
							yourself:
						)
					)
				)
				(= local4
					((Polygon new:)
						type: PBarredAccess
						init: 209 116 192 152 158 152 156 143 151 121 163 116
						yourself:
					)
				)
				((Polygon new:)
					type: PBarredAccess
					init: 224 115 228 144 220 144 218 115
					yourself:
				)
		)
		(moose init: setOnMeCheck: 1 4)
		(closet init: setOnMeCheck: 1 8)
		(trunk init: setOnMeCheck: 1 16)
		(bed init: setOnMeCheck: 1 32)
		(photo init: setOnMeCheck: 1 64)
		(lamp init: setOnMeCheck: 1 128)
		(nightStand init: setOnMeCheck: 1 256)
		(box init: setOnMeCheck: 1 1024)
		(chair init: setOnMeCheck: 1 2048)
		(dresser init: setOnMeCheck: 1 4096)
		(bottles init: setOnMeCheck: 1 8192)
		(stairs init: setOnMeCheck: 1 16384)
		(moose1 init: setOnMeCheck: 1 512)
		(trunkLid
			setCel:
				(if (IsFlag 44)
					(trunkLid lastCel:)
				else
					0
				)
			init:
			approachVerbs: 4 1 ; Do, Look
			stopUpd:
		)
		(nightDrawer
			setCel:
				(if (IsFlag 40)
					(nightDrawer lastCel:)
				else
					0
				)
			init:
			approachVerbs: 4 1 ; Do, Look
			stopUpd:
		)
		(closetDoor
			setCel:
				(if (IsFlag 42)
					(closetDoor lastCel:)
				else
					0
				)
			init:
			approachVerbs: 4 1 ; Do, Look
			stopUpd:
		)
		(closetDrawer
			setCel:
				(if (IsFlag 41)
					(closetDrawer lastCel:)
				else
					0
				)
			init:
			approachVerbs: 4 1 ; Do, Look
			stopUpd:
		)
		(dresserDrawer
			setCel:
				(if (IsFlag 43)
					(dresserDrawer lastCel:)
				else
					0
				)
			init:
			approachVerbs: 4 1 ; Do, Look
			stopUpd:
		)
		(if (IsFlag 58)
			(gCast eachElementDo: #hide)
		)
	)

	(method (doit)
		(super doit:)
		(cond
			((and local0 (== (PalVary pvGET_CURRENT_STEP) 0))
				(sSepiaStart cue:)
				(= local0 0)
			)
			((and local1 (== (PalVary pvGET_CURRENT_STEP) 64))
				(sGetReady cue:)
				(= local1 0)
			)
			(script)
			((proc0_1 gEgo 2)
				(gCurRoom setScript: sExitToSouth)
			)
			((and (proc0_1 gEgo 512) (< (gEgo y:) 130))
				(gCurRoom setScript: sTopTrip)
			)
			((and (proc0_1 gEgo 512) (> (gEgo y:) 130))
				(gCurRoom setScript: sBottomTrip)
			)
		)
	)

	(method (dispose)
		(if (and (!= gCurPuzzle 14) (!= gCurPuzzle 19))
			(gGameMusic1 fade:)
		)
		(super dispose:)
	)
)

(instance sTopTrip of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(= local2 (gEgo moveSpeed:))
				(= cycles 1)
			)
			(1
				(gEgo
					view: (if (gEgo wearingGuns:) 635 else 636)
					loop: 2
					cel: 0
					setSpeed: 6
					setCycle: CT 3 1 self
				)
			)
			(2
				(gEgo setPri: 9 setCycle: End self)
			)
			(3
				(gEgo
					normalize:
					y: 147
					loop: 2
					cel: 2
					setMotion: MoveTo (gEgo x:) 155 self
				)
			)
			(4
				(gEgo setSpeed: local2 setPri: -1)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sBottomTrip of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(= local2 (gEgo moveSpeed:))
				(= cycles 1)
			)
			(1
				(gEgo
					view: (if (gEgo wearingGuns:) 635 else 636)
					loop: 1
					cel: 0
					setSpeed: 6
					setCycle: CT 3 1 self
				)
			)
			(2
				(gEgo setPri: 8 setCycle: End self)
			)
			(3
				(gEgo
					normalize:
					y: 120
					loop: 3
					cel: 3
					setMotion: MoveTo (gEgo x:) 115 self
				)
			)
			(4
				(gEgo setSpeed: local2 setPri: -1)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sEnterFromSouth of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo x: 25 y: 189 setPri: 11 setMotion: MoveTo 125 150 self)
			)
			(1
				(gEgo setPri: -1)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sExitToSouth of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo setPri: 11 setLoop: 1 setMotion: MoveTo 25 189 self)
			)
			(1
				(gCurRoom newRoom: 610)
				(gEgo setPri: -1)
				(self dispose:)
			)
		)
	)
)

(instance sSepiaStart of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= local0 1)
				(= local2 (gEgo moveSpeed:))
				(PalVary pvINIT 630 0)
				(gGame setCursor: 996)
				(gTheIconBar disable:)
				(gEgo
					view: 633
					x: 138
					y: 87
					setLoop: 1
					setCel: 0
					cycleSpeed: 12
					setCycle: 0
					scaleSignal: 0
				)
				(= cycles 1)
			)
			(1
				(PalVary pvREVERSE 5 0 1)
			)
			(2
				(gMessager say: 22 0 0 0 self) ; "Now let's see. Where wuz I?"
			)
			(3
				(drawerSound number: 2933 play: self)
			)
			(4
				(gEgo setCycle: End self)
			)
			(5
				(gMessager say: 24 0 0 0 self) ; "Penelope...Coarsegold...Madame Ovaree..."
			)
			(6
				(gEgo setLoop: 2 setCel: 0 setCycle: End self)
			)
			(7
				(gEgo
					normalize:
					x: 148
					y: 118
					loop: 0
					cel: 0
					setSpeed: local2
					scaleSignal: 1
				)
				(gGame handsOn:)
				(gTheIconBar enable:)
				(self dispose:)
			)
		)
	)
)

(instance sCoarsegoldBurns of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(SetFlag 1)
				(= local2 (gEgo moveSpeed:))
				(= gCurPuzzle 14)
				(gEgo put: 28) ; Ladder
				(gEgo put: 54) ; Snails
				(ClearFlag 16)
				(gEgo
					view: 633
					x: 141
					y: 88
					setLoop: 1
					setCel: 0
					setCycle: 0
					scaleSignal: 0
					cycleSpeed: 12
				)
				(srini
					view: 634
					x: 157
					y: 122
					setLoop: 0
					setCel: 0
					cycleSpeed: 10
					setCycle: Fwd
					init:
				)
				(gGameMusic1 number: 637 loop: -1 play:)
				((ScriptID 0 13) setReal: (ScriptID 0 13) 0 10) ; deathTimer, deathTimer
				(= cycles 1)
			)
			(1
				(proc0_9 1000 srini)
				(= seconds 3)
			)
			(2
				(srini setCycle: End self)
			)
			(3
				(gMessager say: 23 2 6 0 self) ; "FIRE! FIRE! Freddy Pharkas, please come urgently!"
			)
			(4
				(gEgo setCycle: End self)
			)
			(5
				(gMessager say: 23 2 7 0 self) ; "Whu...what's wrong, Srini?"
			)
			(6
				(srini
					view: 801
					setSpeed: 4
					setCycle: StopWalk -1
					setMotion: MoveTo 230 114 self
				)
			)
			(7
				(srini setMotion: MoveTo 238 151 self)
			)
			(8
				(srini setMotion: MoveTo 99 151 self)
			)
			(9
				(srini setMotion: MoveTo 25 189 self)
			)
			(10
				(gEgo setLoop: 2 setCel: 0 setCycle: End self)
			)
			(11
				(gEgo
					normalize:
					x: 149
					y: 120
					cycleSpeed: local2
					moveSpeed: local2
					scaleSignal: 1
					setHeading: 90
				)
				(proc0_9 0)
				(gGame handsOn:)
				(srini dispose:)
				(self dispose:)
			)
		)
	)
)

(instance sGetReady of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo
					x: 178
					y: 121
					setHeading: 90
					wearingGuns: 1
					stopUpd:
					normalize:
					hide:
				)
				(= cycles 1)
			)
			(1
				(= gAct 4)
				(ClearFlag 58)
				(gGame points: 1)
				(= cycles 10)
			)
			(2
				(proc0_9 26)
				(gMessager say: 27 0 0 0 self) ; "With your boots, your clothes, your guns cleaned and loaded, your silver ear, and your lucky neckerchief, you're ready to get dressed and assume your identity as the Gunslingin' Stranger."
			)
			(3
				(gCast eachElementDo: #show)
				(srini
					view: 634
					loop: 1
					x: 199
					y: 121
					cycleSpeed: 13
					setScale: Scaler 105 84 155 108
					init:
				)
				(gCurRoom drawPic: 630)
				(= cycles 1)
			)
			(4
				(srini setCycle: End self)
			)
			(5
				(gEgo show: stopUpd:)
				(srini view: 634 setLoop: 0 setCel: 8 setCycle: End self)
			)
			(6
				(srini stopUpd:)
				(= cycles 5)
			)
			(7
				(gMessager say: 26 0 0 0 self) ; "There you are, Freddy Pharkas, you are mostly indeed a picture of stately mysterious strangerness. Nobody will be positive to recognize you any now."
			)
			(8
				(gTheIconBar disable:)
				(= local1 1)
				(PalVary pvINIT 630 5)
			)
			(9
				(proc0_15 1 0 self)
			)
			(10
				(gCast eachElementDo: #dispose)
				(PalVary pvUNINIT)
				(= cycles 1)
			)
			(11
				(Palette palSET_INTENSITY 0 256 0)
				(gCurRoom newRoom: 26) ; actBreak
				(self dispose:)
			)
		)
	)
)

(instance sSkipCartoon of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(proc0_15 1 4 self)
			)
			(1
				(gEgo
					normalize:
					x: 148
					y: 118
					cycleSpeed: local2
					moveSpeed: local2
					scaleSignal: 1
					setHeading: 90
				)
				(srini dispose:)
				(= cycles 1)
			)
			(2
				(proc0_15 0 4 self)
			)
			(3
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance srini of Actor
	(properties
		x 209
		y 146
		view 801
		loop 4
		signal 16384
	)

	(method (cue)
		(gCurRoom setScript: sSkipCartoon)
	)
)

(instance trunkLid of Prop
	(properties
		x 83
		y 97
		noun 19
		approachX 104
		approachY 138
		view 630
		loop 2
		priority 6
		signal 16401
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(cond
					((IsFlag 42)
						(gMessager say: 19 0 2) ; "You need to close the armoire first. What do you think this is, the Embassy Suites?"
					)
					((IsFlag 44)
						(ClearFlag 44)
						(drawerSound number: 2700 play:)
						(self setCycle: Beg self)
					)
					(else
						(SetFlag 44)
						(drawerSound number: 2700 play:)
						(self setCycle: End self)
					)
				)
			)
			(1 ; Look
				(cond
					(
						(and
							(not (gEgo has: 10)) ; Clothes
							(IsFlag 44)
							(!= (gEgo wearingGuns:) 1)
						)
						(gEgo stopUpd:)
						(gCurRoom setInset: inClothes)
					)
					((IsFlag 44)
						(gMessager say: noun 1 1) ; "There is nothing more in your trunk."
					)
					(else
						(gMessager say: noun 1 0) ; "Your Dad unloaded his old vaudeville trunk on you."
					)
				)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)

	(method (cue)
		(self stopUpd:)
	)
)

(instance nightDrawer of Prop
	(properties
		x 169
		y 96
		noun 16
		approachX 161
		approachY 116
		view 632
		signal 16385
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(drawerSound number: 2126 play:)
				(if (IsFlag 40)
					(ClearFlag 40)
					(self setCycle: Beg self)
				else
					(SetFlag 40)
					(self setCycle: End self)
				)
			)
			(1 ; Look
				(cond
					(
						(and
							(not (gEgo has: 15)) ; Desk_Key
							(IsFlag 40)
							(!= (gEgo wearingGuns:) 1)
						)
						(gEgo stopUpd:)
						(gCurRoom setInset: inKeyInset)
					)
					((IsFlag 40)
						(gMessager say: noun 1 1) ; "There's nothing left in the drawer you can use."
					)
					(else
						(gMessager say: noun 1 0) ; "While window-shopping in Chowchilla, your eye fell on this plain but serviceable nightstand."
					)
				)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)

	(method (cue)
		(self stopUpd:)
	)
)

(instance closetDoor of Prop
	(properties
		x 62
		y 123
		noun 6
		approachX 104
		approachY 138
		view 630
		signal 16385
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(drawerSound number: 2126 play:)
				(if (IsFlag 42)
					(ClearFlag 42)
					(self setCycle: Beg self)
				else
					(SetFlag 42)
					(self setCycle: End self)
				)
			)
			(1 ; Look
				(if (IsFlag 42)
					(gMessager say: noun 1 1) ; "The armoire door is wide open, displaying your outfits for all the world to see and admire."
				else
					(gMessager say: noun 1 0) ; "You picked up this old armoire at the farmer's market."
				)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)

	(method (cue)
		(self stopUpd:)
	)
)

(instance closetDrawer of Prop
	(properties
		x 45
		y 142
		noun 14
		approachX 104
		approachY 138
		view 630
		loop 1
		priority 8
		signal 16401
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(drawerSound number: 2126 play:)
				(if (IsFlag 41)
					(ClearFlag 41)
					(self setCycle: Beg self)
				else
					(self setCycle: End)
					(SetFlag 41 self)
				)
			)
			(1 ; Look
				(if (IsFlag 41)
					(gMessager say: noun 1 1) ; "It's the open drawer of your armoire, currently exceedingly empty and devoid of stuff."
				else
					(gMessager say: noun 1 0) ; "The drawer at the base of your armoire is apparently empty, except for a few stray black widows."
				)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)

	(method (cue)
		(self stopUpd:)
	)
)

(instance dresserDrawer of Prop
	(properties
		x 248
		y 117
		noun 15
		approachX 207
		approachY 120
		view 631
		signal 16385
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(drawerSound number: 2126 play:)
				(if (IsFlag 43)
					(ClearFlag 43)
					((gCurRoom obstacles:) delete: local5)
					(local5 dispose:)
					(gCurRoom
						addObstacle:
							(= local3
								((Polygon new:)
									type: PBarredAccess
									init: 263 149 247 146 226 110 162 110 148 121 152 143 136 143 132 139 133 133 103 133 90 140 126 140 120 147 0 147 0 0 319 0 319 189 0 189 0 154 264 154
									yourself:
								)
							)
					)
					(self setCycle: Beg self)
				else
					(SetFlag 43)
					((gCurRoom obstacles:) delete: local3)
					(local3 dispose:)
					(gCurRoom
						addObstacle:
							(= local5
								((Polygon new:)
									type: PBarredAccess
									init: 263 149 208 145 213 110 162 110 148 121 152 143 136 143 132 139 133 133 103 133 90 140 126 140 120 147 0 147 0 0 319 0 319 189 0 189 0 154 264 154
									yourself:
								)
							)
					)
					(self setCycle: End self)
				)
			)
			(1 ; Look
				(cond
					((and (IsFlag 43) (not (IsFlag 106)))
						(gEgo stopUpd:)
						(gCurRoom setInset: inClaimCheck)
					)
					((IsFlag 43)
						(gMessager say: noun 1 1) ; "The drawer is empty, save for a few cobwebs, dust balls, and dead gnats."
					)
					(else
						(gMessager say: noun 1 0) ; "You stumbled onto this big ol' dresser at a moving sale."
					)
				)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)

	(method (cue)
		(self stopUpd:)
	)
)

(instance moose of Feature
	(properties
		x 184
		y 124
		noun 2
	)
)

(instance closet of Feature
	(properties
		x 58
		y 100
		noun 4
	)
)

(instance trunk of Feature
	(properties
		x 101
		y 96
		noun 5
	)
)

(instance bed of Feature
	(properties
		x 131
		y 95
		noun 3
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(if (IsFlag 1)
					(gMessager say: noun theVerb 4) ; "You'll never get back to sleep now. There's trouble afoot, and that gnaws at your gut."
				else
					(gMessager say: noun theVerb 3) ; "You can't sleep. You're too restless. Maybe because it's broad daylight."
				)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance photo of Feature
	(properties
		x 93
		y 68
		noun 13
	)
)

(instance lamp of Feature
	(properties
		x 177
		y 80
		noun 7
	)
)

(instance nightStand of Feature
	(properties
		x 177
		y 95
		noun 8
	)
)

(instance box of Feature
	(properties
		x 205
		y 90
		noun 9
	)
)

(instance chair of Feature
	(properties
		x 233
		y 90
		noun 10
	)
)

(instance dresser of Feature
	(properties
		x 259
		y 114
		noun 11
	)
)

(instance bottles of Feature
	(properties
		x 261
		y 83
		noun 12
	)
)

(instance stairs of Feature
	(properties
		x 12
		y 189
		noun 20
	)
)

(instance moose1 of Feature
	(properties
		x 184
		y 124
		noun 2
	)
)

(instance inClothes of Inset
	(properties
		view 630
		loop 3
		x 139
		y 68
		priority 15
		disposeNotOnMe 1
		noun 18
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(self setScript: sInsetDispose)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance inKeyInset of Inset
	(properties
		view 632
		loop 1
		x 199
		y 62
		priority 15
		disposeNotOnMe 1
		noun 17
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(self setScript: sInsetDispose)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance inClaimCheck of Inset
	(properties
		view 631
		loop 1
		x 248
		y 63
		priority 15
		disposeNotOnMe 1
		noun 21
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(SetFlag 106)
				(self setScript: sInsetDispose)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance sInsetDispose of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(switch client
					(inClaimCheck
						(gEgo get: 7 inClaimCheck) ; Claim_Check
						(gGame points: 1)
					)
					(inKeyInset
						(gEgo get: 15 inKeyInset) ; Desk_Key
						(gGame points: 1)
					)
					(inClothes
						(gEgo get: 10 inClothes) ; Clothes
						(gGame points: 1)
						(if
							(and
								(gEgo has: 38) ; Neckerchief
								(gEgo has: 52) ; Silver_Ear
								(gEgo has: 2) ; Boots
								(gEgo has: 44) ; Pistols
							)
							(SetFlag 58)
						)
					)
				)
				(= cycles 5)
			)
			(1
				(client dispose:)
				(self dispose:)
			)
		)
	)
)

(instance drawerSound of FPSound
	(properties
		flags 1
	)
)

