;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 770)
(include sci.sh)
(use Main)
(use GloryRm)
(use TargFeature)
(use Teller)
(use DeathIcon)
(use Array)
(use Scaler)
(use IconBar)
(use RandCycle)
(use PolyPath)
(use Polygon)
(use Feature)
(use Cursor)
(use Sound)
(use Jump)
(use Motion)
(use User)
(use Actor)
(use System)

(public
	rm770 0
)

(local
	[local0 3]
	local3
	local4 = 100
	local5
	local6
	local7
	local8
	local9
	local10
	local11
	local12
	local13
	local14
	local15
	local16
	local17
	local18
	local19
	local20
)

(procedure (localproc_0 &tmp temp0 temp1)
	(for ((= temp0 0)) (<= temp0 100) ((++ temp0))
		(Palette 2 0 255 temp0) ; PalIntensity
		(FrameOut)
		(for ((= temp1 0)) (< temp1 50) ((++ temp1))
		)
	)
)

(procedure (localproc_1 param1)
	(gGlory handsOn:)
	(gTheIconBar disable: 0)
	(User canControl: 0)
	(param1 dispose:)
)

(procedure (localproc_2 &tmp temp0)
	(Cursor loop: 8 cel: 10)
	(gGlory setCursor: (IconBarCursor view: 905 loop: 8 cel: 10 yourself:))
	((gInventory at: 44) loop: 8 cel: 10 mainCel: 10 state: 1) ; theTorch
	((gTheIconBar at: 6) cursorCel: 10)
	(= temp0 (ScriptID 36 1)) ; invItem
	(temp0 cel: 10 show:)
	(UpdateScreenItem temp0)
)

(instance rm770 of GloryRm
	(properties
		noun 2
		picture 770
	)

	(method (init)
		(ClearFlag 6)
		(gGlory handsOff:)
		(gCurRoom
			addObstacle:
				((Polygon new:)
					type: PBarredAccess
					init: 185 96 142 106 99 105 71 89 101 77 162 68 159 65 138 56 177 56 177 53 135 53 135 57 157 67 102 74 70 87 -300 87 -300 -300 619 -300 619 489 -300 489 -300 108 47 118 28 137 110 170 222 170 298 124 297 104 271 96 236 90 224 97 196 93 208 80 204 75
					yourself:
				)
				((Polygon new:)
					type: PBarredAccess
					init: 287 118 211 160 116 160 56 137 87 118 150 118 202 102
					yourself:
				)
		)
		(= local3 50)
		(body1 init: approachVerbs: 4) ; Do
		(body2 init: approachVerbs: 4) ; Do
		(body3 init: approachVerbs: 4) ; Do
		(leftTHolder init: approachVerbs: 4 39 76) ; Do, theFlint, theTorch
		(if (== gPrevRoomNum 720)
			(rightTHolder init: approachVerbs: 4 39 76) ; Do, theFlint, theTorch
		else
			(rightTHolder nsTop: 50 init: approachVerbs: 4 39 76) ; Do, theFlint, theTorch
		)
		(leftEfx init: approachVerbs: 4 39 76) ; Do, theFlint, theTorch
		(rightEfx init: approachVerbs: 4 39 76) ; Do, theFlint, theTorch
		(altar init: approachVerbs: -1) ; ???
		(if (== gPrevRoomNum 720)
			(gEgo
				x: 153
				y: 55
				init:
				normalize:
				setScaler: Scaler 66 22 71 55
			)
			(torchEff init: setScaler: Scaler 66 22 71 55)
			(gate approachVerbs: 4 setLoop: 1) ; Do
			(gate
				setCel: (gate lastCel:)
				signal: (| (gate signal:) $0001)
				init:
			)
			(= local18 1)
			(= local19 0)
			(if ((gInventory at: 44) state:) ; theTorch
				(self doTorch: 1)
			)
			(self setScript: sFromNorth)
		else
			(gLongSong number: 200 play:)
			(gEgo
				view: 40
				loop: 0
				cel: 5
				x: 51
				y: 140
				init:
				setScaler: Scaler 100 66 158 69
			)
			(torchEff init: setScaler: Scaler 100 66 158 69)
			(gate init: approachVerbs: 4) ; Do
			(= local18 0)
			(= local19 1)
			(self setScript: sEnterScr)
		)
		(super init: &rest)
	)

	(method (doTorch param1)
		(if param1
			(torchEff signal: (| (torchEff signal:) $0001) show:)
			(SetFlag 373)
			(gEgo changeGait:)
		)
	)

	(method (doit)
		(if (GameIsRestarting)
			(if (not (& (leftEfx signal:) $0008))
				(leftEfx signal: (| (leftEfx signal:) $0001) show:)
			)
			(if (not (& (rightEfx signal:) $0008))
				(rightEfx signal: (| (rightEfx signal:) $0001) show:)
			)
		)
		(super doit:)
		(if (and (not local18) (< (gEgo y:) 72) (< (gEgo x:) 180))
			(gEgo setPri: (gEgo priority:) setScaler: Scaler 66 22 71 55)
			(torchEff setScaler: Scaler 66 22 71 55)
			(= local18 1)
			(= local19 0)
		)
		(if (and (not local19) (>= (gEgo y:) 72) (< (gEgo x:) 180))
			(gEgo setPri: -1 setScaler: Scaler 100 66 158 71)
			(torchEff setScaler: Scaler 100 66 158 71)
			(= local18 0)
			(= local19 1)
		)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(91 ; jugglingLightsSpell
				(if local17
					(gMessager say: 0 0 42) ; "You're too busy to cast a spell right now. Better think of something else FAST!"
				else
					(self setScript: sDoJuggling)
				)
			)
			(83 ; dazzleSpell
				(if local17
					(gMessager say: 0 0 42) ; "You're too busy to cast a spell right now. Better think of something else FAST!"
				else
					(self setScript: sCastDazzle)
				)
			)
			(86 ; flameDartSpell
				(cond
					(local17
						(gMessager say: 0 0 42) ; "You're too busy to cast a spell right now. Better think of something else FAST!"
					)
					(local5
						(self setScript: sCastFlame)
					)
					(else
						(gCurRoom setScript: (ScriptID 32) 0 86) ; project
					)
				)
			)
			(79 ; frostSpell
				(if local17
					(gMessager say: 0 0 42) ; "You're too busy to cast a spell right now. Better think of something else FAST!"
				else
					(gCurRoom setScript: sCastFrost)
				)
			)
			(81 ; detectMagicSpell
				(gMessager say: 2 81 4) ; "There is a faint glow of magic on all of the bones, stronger near the altar. The torch sconces beside the altar have some magic, and the altar itself radiates a strong magical aura."
			)
			(10 ; Jump
				(if local5
					(gCurRoom setScript: sJumpOut)
				else
					(super doVerb: theVerb)
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance sJumpOut of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGlory handsOff:)
				(= local17 0)
				(= gTempEgoSpeed (gEgo cycleSpeed:))
				(cage signal: (| (cage signal:) $0001) setLoop: 0 1)
				(gEgo
					useSkill: 15 ; acrobatics
					view: 30
					setLoop: 3 1
					cel: 0
					code: 0
					cycleSpeed: 6
					moveSpeed: 6
					setScale:
					fixPriority: 1
					setCycle: CT 8 1
					setMotion: JumpTo 150 100 self
					show:
				)
			)
			(1
				(gEgo setCycle: End self)
			)
			(2
				(gEgo setSpeed: gTempEgoSpeed solvePuzzle: 454 15 normalize:)
				(altar init:)
				(leftTHolder init:)
				(egoTeller dispose:)
				(= local5 0)
				(gGlory handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sBreakBones of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGlory handsOff:)
				(if register
					(gMessager say: 8 36 17 0 self) ; "As if unable to bear even the presence of your Paladin's sword, the bones of the cage crack and fall."
				else
					(gMessager say: 12 154 32 0 self) ; "Bracing yourself, you apply all your strength to the cage "bones." The rocks give a terrible shriek, then shatter."
				)
			)
			(1
				(cage signal: (| (cage signal:) $0001) dispose:)
				(gEgo view: 29 setLoop: 1 1 show:)
				(gEgo cel: (gEgo lastCel:) setCycle: Beg self)
			)
			(2
				(gEgo
					solvePuzzle: 454 15
					normalize:
					setMotion: PolyPath 200 100 self
				)
			)
			(3
				(= local5 0)
				(altar init:)
				(leftTHolder init:)
				(egoTeller dispose:)
				(gGlory handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sFromNorth of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= cycles 1)
			)
			(1
				(RemapColors 2 254 60) ; ByPercent
				(RemapColors 1 253 112 175 62) ; ByRange
				(gEgo setMotion: PolyPath 153 57 self)
			)
			(2
				(gate setCycle: Beg self)
			)
			(3
				(gate setLoop: 0 setCel: 1)
				(= cycles 12)
			)
			(4
				(gate setCel: 0)
				(= cycles 6)
			)
			(5
				(gate signal: (& (gate signal:) $fffe))
				(= local11 1)
				(gGlory handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sDoJuggling of Script
	(properties)

	(method (doit &tmp temp0)
		(switch state
			(3
				(for ((= temp0 local4)) (<= temp0 260) ((+= temp0 5))
					(= gGameTime (+ gTickOffset (GetTime)))
					(Palette 2 112 173 temp0) ; PalIntensity
					((local7 cycler:) doit:)
					(if
						(and
							(leftEfx cycler:)
							(not (& (leftEfx signal:) $0008))
						)
						((leftEfx cycler:) doit:)
						(UpdateScreenItem leftEfx)
					)
					(if
						(and
							(rightEfx cycler:)
							(not (& (rightEfx signal:) $0008))
						)
						((rightEfx cycler:) doit:)
						(UpdateScreenItem rightEfx)
					)
					(UpdateScreenItem local7)
					(FrameOut)
				)
				(self cue:)
			)
			(5
				(for ((= temp0 260)) (>= temp0 local4) ((-= temp0 8))
					(Palette 2 112 173 temp0) ; PalIntensity
					(FrameOut)
				)
				(self cue:)
			)
			(else
				(super doit:)
			)
		)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGlory handsOff:)
				(if (gEgo mover:)
					(gEgo setMotion: 0)
				)
				(gLongSong2 number: 934 setLoop: 1 1 play:)
				(if (and (> (gEgo view:) 17) (< (gEgo view:) 21))
					(gEgo view: 19 loop: 5 cel: 0 setCycle: End self)
				else
					(gEgo view: 15 loop: 0 setCycle: End self)
				)
			)
			(1
				((= local7 (Prop new:))
					view: 99
					loop: 0
					cel: 0
					x: (gEgo x:)
					y:
						(-
							(gEgo y:)
							(+
								(/ (* 55 (gEgo scaleY:)) (gEgo maxScale:))
								20
							)
						)
					setPri: (+ (gEgo priority:) 1)
					init:
					setScale:
					scaleX: (gEgo scaleX:)
					scaleY: (gEgo scaleY:)
					setCycle: Fwd
				)
				(if (and (> (gEgo view:) 17) (< (gEgo view:) 21))
					(self cue:)
				else
					(gEgo setCycle: CT 4 -1 self)
				)
			)
			(2
				(if (and (> (gEgo view:) 17) (< (gEgo view:) 21))
					(self cue:)
				else
					(gEgo setCycle: CT 2 -1 self)
				)
			)
			(3
				(ClearFlag 6)
			)
			(4
				(= seconds 2)
			)
			(5
				(local7 dispose:)
			)
			(6
				(gEgo setCycle: CT 0 -1 self)
			)
			(7
				(gGlory handsOn:)
				(gEgo normalize: 4)
				(self dispose:)
			)
		)
	)
)

(instance sExitNorth of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGlory handsOff:)
				(gMessager say: 5 4 13 0 self) ; "You force the sphincter open with your dagger, and pass through."
			)
			(1
				(gate signal: (| (gate signal:) $0001) setCel: 1)
				(= cycles 12)
			)
			(2
				(gate setLoop: 1 setCel: 0 setCycle: End self)
			)
			(3
				(gEgo setMotion: MoveTo 153 51 self)
			)
			(4
				(gCurRoom newRoom: 720)
			)
		)
	)
)

(instance sGetTrapped of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGlory handsOff:)
				(if (> ((User curEvent:) x:) (gEgo x:))
					(= local6 1)
				else
					(= local6 0)
				)
				(if (gEgo mover:)
					(gEgo setMotion: 0)
				)
				(= gTempEgoSpeed (gEgo cycleSpeed:))
				(if local6
					(gEgo
						view: 6
						setLoop: 4 1
						cel: 0
						x: (+ (gEgo x:) 20)
						cycleSpeed: 6
						setCycle: End self
					)
				else
					(gEgo
						view: 6
						setLoop: 5 1
						cel: 0
						x: (- (gEgo x:) 20)
						cycleSpeed: 6
						setCycle: End self
					)
				)
			)
			(1
				(gMessager say: 7 6 25 0 self) ; "You stumble and fall over the ancient, petrified corpse."
			)
			(2
				(gMessager say: 9 6 26 0 self) ; "As you pick yourself up, you discover a dagger and some coins on the dried-out dead body. It isn't going to use them any more, so you take them."
			)
			(3
				(if local6
					(gEgo setLoop: 6 1 cel: 0 setCycle: End self)
				else
					(gEgo setLoop: 7 1 cel: 0 setCycle: End self)
				)
			)
			(4
				(register heading: 1)
				(gEgo solvePuzzle: 402 2 get: 5) ; theThrowdagger
				((gInventory at: 0) amount: (+ 5 ((gInventory at: 0) amount:))) ; thePurse, thePurse
				(+= global395 13)
				(gEgo normalize: (if local6 4 else 5) cycleSpeed: gTempEgoSpeed)
				(gGlory handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sGetItem of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGlory handsOff:)
				(= gTempEgoSpeed (gEgo cycleSpeed:))
				(if (gEgo looper:)
					((gEgo looper:) dispose:)
					(gEgo looper: 0)
				)
				(gEgo
					setMotion: 0
					view: 4
					loop: (mod (gEgo loop:) 2)
					cycleSpeed: 6
					setCycle: End self
				)
			)
			(1
				(switch register
					(body1
						(gMessager say: 9 4 26 0 self) ; "You search the dessicated body. The only still-usable item is a dagger, which you pick up. However, lying around the bones are some coins -- 5 golden coins each have a crown stamped onto them, and 13 small copper ones are each stamped "1 Kopek.""
					)
					(body2
						(gMessager say: 10 4 30 0 self) ; "A brief search reveals a piece of hard, grey rock, which you take, and some coins -- 3 Crowns and 13 Kopeks."
					)
					(body3
						(gMessager say: 11 4 31 0 self) ; "You find 30 assorted copper and gold coins on the body."
					)
				)
			)
			(2
				(gEgo setCycle: Beg self)
			)
			(3
				(gEgo cycleSpeed: gTempEgoSpeed normalize:)
				(switch register
					(body1
						(gEgo solvePuzzle: 402 2 get: 5) ; theThrowdagger
						((gInventory at: 0) ; thePurse
							amount: (+ 5 ((gInventory at: 0) amount:)) ; thePurse
						)
						(+= global395 13)
					)
					(body2
						(gEgo get: 21) ; theFlint
						((gInventory at: 0) ; thePurse
							amount: (+ 3 ((gInventory at: 0) amount:)) ; thePurse
						)
						(+= global395 13)
					)
					(body3
						((gInventory at: 0) ; thePurse
							amount: (+ 5 ((gInventory at: 0) amount:)) ; thePurse
						)
						(+= global395 25)
					)
				)
				(gGlory handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sEnterScr of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(Palette 2 0 255 0) ; PalIntensity
				(= cycles 1)
			)
			(1
				(RemapColors 2 254 60) ; ByPercent
				(RemapColors 1 253 112 175 62) ; ByRange
				(= gTempEgoSpeed (gEgo cycleSpeed:))
				(localproc_0)
				(= cycles 2)
			)
			(2
				(gMessager say: 7 6 37 0 self) ; "You awaken from nightmares of flying and falling. You find yourself in this strange place, the only illumination an eerie green glow."
			)
			(3
				(gEgo setCycle: Beg self)
			)
			(4
				(gEgo cycleSpeed: gTempEgoSpeed normalize: 4)
				(= cycles 2)
			)
			(5
				(gMessager say: 7 6 36 0 self) ; "No, make that FIVE burning questions:    What city did your luggage end up in THIS time?"
			)
			(6
				(gGlory handsOn:)
				(gTheIconBar curIcon: (gTheIconBar at: 1))
				(gGlory
					setCursor:
						((gTheIconBar getCursor:)
							view: 941
							loop: 0
							cel: 0
							yourself:
						)
				)
				(self dispose:)
			)
		)
	)
)

(instance sDoCage of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGlory handsOff:)
				(gMessager say: 4 67 0 0 self) ; "You unroll the scroll containing the Bone Ritual. The words are visible at last and you begin to perform the Ritual."
			)
			(1
				(gEgo drop: 52 1 solvePuzzle: 453 6) ; theBoneRit
				(SetFlag 323)
				(= local5 1)
				(if (== gHeroType 2) ; Thief
					((gCurRoom obstacles:) dispose:)
					(gCurRoom obstacles: 0)
					(gCurRoom
						addObstacle:
							((Polygon new:)
								type: PBarredAccess
								init: 142 106 99 105 70 93 93 77 161 67 159 64 138 56 177 56 177 53 135 53 135 57 156 66 93 74 67 87 -300 87 -300 -300 619 -300 619 489 -300 489 -300 108 47 118 28 137 110 170 222 170 298 124 297 104 271 96 236 90 224 97 195 93
								yourself:
							)
							((Polygon new:)
								type: PBarredAccess
								init: 287 118 211 160 116 160 56 137 87 118 150 118 202 102
								yourself:
							)
					)
					(cage
						cycleSpeed: 150
						setPri: (- (gEgo priority:) 5)
						setLoop: 4
						signal: (| (cage signal:) $0001)
						setCycle: End
						init:
					)
					(cage2
						signal: (| (cage signal:) $0001)
						setPri: (+ (gEgo priority:) 5)
						setCycle: End
						init:
					)
					(= local17 1)
				else
					(cage
						setPri: (+ (gEgo priority:) 5)
						signal: (| (cage signal:) $0001)
						setLoop: 3
						setCycle: CT 3 1
						init:
					)
					(gEgo changeGait: 0 setLooper: 0 setCycle: 0 hide:) ; walking
				)
				(egoTeller init: gEgo 770 12 154 8)
				(altar dispose:)
				(leftTHolder dispose:)
				(gGlory handsOn:)
				(gTheIconBar disable: 0)
				(User canControl: 0)
				(self dispose:)
			)
		)
	)
)

(instance sLightTorch of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGlory handsOff:)
				(= cycles 2)
			)
			(1
				(gEgo
					view: 31
					setLoop: 0
					cel: 0
					x: (+ (gEgo x:) 4)
					setCycle: End self
				)
			)
			(2
				(register
					signal: (| (register signal:) $0001)
					show:
					setCycle: End self
				)
			)
			(3
				(register cue:)
				(gEgo solvePuzzle: 401 6 setCycle: Beg self)
			)
			(4
				(switch register
					(leftEfx
						(SetFlag 303)
					)
					(rightEfx
						(SetFlag 304)
					)
				)
				(gEgo x: (- (gEgo x:) 4) normalize: 6)
				(gGlory handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sFlameTorch of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGlory handsOff:)
				(= cycles 2)
			)
			(1
				(register
					signal: (| (register signal:) $0001)
					show:
					setCycle: End self
				)
			)
			(2
				(register cue:)
				(gEgo solvePuzzle: 401 6)
				(switch register
					(leftEfx
						(SetFlag 303)
					)
					(rightEfx
						(SetFlag 304)
					)
				)
				(gGlory handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sTakeTorch of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGlory handsOff:)
				(gEgo view: 31 setLoop: 0 cel: 0 setCycle: End self)
			)
			(1
				(gMessager say: 1 4 5 0 self) ; "You take the torch."
				(if (rightEfx cycler:)
					(register hide:)
					(= local6 1)
					((gInventory at: 44) cel: 10 mainCel: 10 state: 1) ; theTorch
					(gCurRoom doTorch: 1)
				else
					(= local6 0)
				)
				(gEgo get: 44) ; theTorch
			)
			(2
				(gEgo setCycle: Beg self)
			)
			(3
				(SetFlag 302)
				(gEgo normalize: 6)
				(gGlory handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sCastDazzle of Script
	(properties)

	(method (changeState newState &tmp temp0 temp1)
		(switch (= state newState)
			(0
				(gGlory handsOff:)
				(if (gEgo mover:)
					(gEgo setMotion: 0)
				)
				(= temp0 (IntArray with: 2 3 0 3 0 1 2 3))
				(= temp1 (IntArray with: 0 0 0 1 0 0 2 3))
				(= local8 (gEgo cycleSpeed:))
				(= local9 (gEgo loop:))
				(soundFX number: 940 play:)
				(if (and (> (gEgo view:) 17) (< (gEgo view:) 21))
					(= local10 (gEgo cel:))
					(gEgo view: 19 loop: (temp1 at: local9))
				else
					(gEgo view: 15 loop: (temp0 at: local9))
				)
				(gEgo setMotion: 0 cycleSpeed: global433 setCycle: End self)
				(temp0 dispose:)
				(temp1 dispose:)
			)
			(1
				(gEgo setCycle: Beg self)
			)
			(2
				(gEgo cycleSpeed: local8)
				(if (and (> (gEgo view:) 17) (< (gEgo view:) 21))
					(gEgo view: 20 loop: local9 cel: local10)
				else
					(gEgo normalize: local9)
				)
				(Palette 2 0 255 200) ; PalIntensity
				(FrameOut)
				(= cycles 6)
			)
			(3
				(Palette 2 0 255 local4) ; PalIntensity
				(gGlory handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sCastForce of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(if (not (and (>= local14 1) (>= local13 1)))
					(gMessager say: 8 88 18) ; "Your Force Bolt spell shakes the bone cage a little, but otherwise has no effect; you'll have to find a way to weaken the bones before you can break them."
					(localproc_1 self)
				else
					(gMessager say: 8 88 21 0 self) ; "That did it! The brittle bones cannot take any more of your onslaught of spells. They crack and fall to the ground."
					(altar init:)
					(leftTHolder init:)
					(egoTeller dispose:)
					(= local5 0)
					(cage dispose:)
					(gEgo view: 29 setLoop: 1 1)
					(gEgo setCel: (gEgo lastCel:) show:)
				)
			)
			(1
				(gEgo setCycle: Beg self)
			)
			(2
				(gEgo solvePuzzle: 454 15 normalize:)
				(gGlory handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sCastFlame of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(if local15
					(gMessager say: 8 86 19) ; "Your Flame Dart spell has no further effect on the already-hot bones."
					(= local15 1)
					(= local16 0)
					(localproc_1 self)
				else
					(= ticks 1)
				)
			)
			(1
				(cage
					setLoop: 1
					cel: 0
					signal: (| (cage signal:) $0001)
					setCycle: End self
				)
			)
			(2
				(cage setCycle: Beg self)
			)
			(3
				(cage setLoop: 3 cel: 3 signal: (& (cage signal:) $fffe))
				(if local14
					(if local16
						(if (>= local13 2)
							(gMessager say: 8 86 23 0 self) ; "That did it! The brittle bones cannot take any more of your onslaught of spells. They crack and fall to the ground."
							(= local5 0)
							(altar init:)
							(leftTHolder init:)
							(egoTeller dispose:)
							(cage dispose:)
							(gEgo view: 29 setLoop: 1 1)
							(gEgo setCel: (gEgo lastCel:) show:)
						else
							(gMessager say: 8 86 21) ; "You reheat the brittle bones with your Flame Dart, softening them once more."
							(++ local14)
							(= local15 1)
							(= local16 0)
							(localproc_1 self)
						)
					)
				else
					(++ local14)
					(gMessager say: 8 86 18 0) ; "The bones momentarily glow red-hot; your spell has softened them a little."
					(= local15 1)
					(= local16 0)
					(localproc_1 self)
				)
			)
			(4
				(gEgo setCycle: Beg self)
			)
			(5
				(gEgo solvePuzzle: 454 15 normalize:)
				(gGlory handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sCastFrost of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(if local16
					(gMessager say: 8 79 22 0 self) ; "Your Frostbite spell has no further effect on the already frozen bones."
					(= local15 0)
					(= local16 1)
					(localproc_1 self)
				else
					(= ticks 1)
				)
			)
			(1
				(cage
					setLoop: 2
					cel: 0
					signal: (| (cage signal:) $0001)
					setCycle: End self
				)
			)
			(2
				(cage setCycle: Beg self)
			)
			(3
				(cage setLoop: 3 cel: 3 signal: (& (cage signal:) $fffe))
				(if local13
					(if local15
						(if (>= local14 2)
							(gMessager say: 8 79 20 0 self) ; "That did it! The brittle bones cannot take any more of your onslaught of spells. They crack and fall to the ground."
							(altar init:)
							(leftTHolder init:)
							(egoTeller dispose:)
							(= local5 0)
							(cage dispose:)
							(gEgo view: 29 setLoop: 1 1)
							(gEgo setCel: (gEgo lastCel:) show:)
						else
							(gMessager say: 8 79 21) ; "The brittle bones are now covered with a layer of frost."
							(++ local13)
							(= local15 0)
							(= local16 1)
							(localproc_1 self)
						)
					)
				else
					(++ local13)
					(gMessager say: 8 79 18) ; "Your Frostbite spell has frozen the bones, but they are still strong and solid."
					(= local15 0)
					(= local16 1)
					(localproc_1 self)
				)
			)
			(4
				(gEgo setCycle: Beg self)
			)
			(5
				(gEgo solvePuzzle: 454 15 normalize:)
				(gGlory handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sPlaceTorch of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGlory handsOff:)
				(= cycles 2)
			)
			(1
				(gEgo
					view: 31
					setLoop: 0
					cel: 0
					x: (+ (gEgo x:) 4)
					setCycle: End self
				)
			)
			(2
				(gMessager say: 7 6 4 0 self) ; "You put the torch back in the sconce."
			)
			(3
				(ClearFlag 302)
				(if (not (& (torchEff signal:) $0008))
					(torchEff signal: (& (torchEff signal:) $fffe) hide:)
					(ClearFlag 373)
					(SetFlag 304)
					(rightEfx show: cue:)
				)
				(= cycles 2)
			)
			(4
				(gEgo drop: 44 setCycle: Beg self) ; theTorch
			)
			(5
				(gGlory handsOn:)
				(gEgo normalize: 6)
				(self dispose:)
			)
		)
	)
)

(instance torchEff of Prop
	(properties
		view 775
		signal 16385
	)

	(method (init)
		(super init:)
		(self setCycle: RandCycle)
		(if (gEgo has: 44) ; theTorch
			(self signal: (| (self signal:) $0001) show:)
			(SetFlag 373)
			(gEgo changeGait:)
		else
			(self signal: (& (self signal:) $fffe) hide:)
			(ClearFlag 373)
		)
	)

	(method (onMe)
		(return 0)
	)

	(method (doit)
		(= x (gEgo x:))
		(= y (gEgo y:))
		(= z (+ (gEgo z:) 1))
		(super doit: &rest)
	)
)

(instance cage of Prop
	(properties
		x 241
		y 62
		view 771
		loop 3
		signal 16384
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(if local5
					((gEgo actions:) doVerb: theVerb)
				else
					(super doVerb: theVerb)
				)
			)
			(86 ; flameDartSpell
				(if local17
					(gMessager say: 0 0 42) ; "You're too busy to cast a spell right now. Better think of something else FAST!"
				else
					(gCurRoom setScript: sCastFlame)
				)
			)
			(79 ; frostSpell
				(if local17
					(gMessager say: 0 0 42) ; "You're too busy to cast a spell right now. Better think of something else FAST!"
				else
					(gCurRoom setScript: sCastFrost)
				)
			)
			(88 ; forceBoltSpell
				(if local17
					(gMessager say: 0 0 42) ; "You're too busy to cast a spell right now. Better think of something else FAST!"
				else
					(gCurRoom setScript: sCastForce)
				)
			)
			(36 ; theSword
				(if (and (== gHeroType 3) (== ((gInventory at: 19) state:) 3)) ; Paladin, theSword
					(gCurRoom setScript: sBreakBones 0 1)
				else
					(super doVerb: theVerb)
				)
			)
			(10 ; Jump
				(gCurRoom doVerb: theVerb)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance cage2 of Prop
	(properties
		x 241
		y 62
		view 771
		loop 5
		signal 16384
		cycleSpeed 150
	)

	(method (doit)
		(if (and local17 (== cel 3))
			(EgoDead 24) ; "Better bone up on your acrobatics skills. You'll need to be quicker than that to make a career playing the bones."
		)
		(super doit:)
	)

	(method (doVerb theVerb)
		(cage doVerb: theVerb)
	)
)

(instance gate of Prop
	(properties
		noun 5
		approachX 153
		approachY 50
		x 153
		y 46
		view 772
		signal 16384
	)

	(method (doVerb theVerb)
		(if (and (not (== theVerb 10)) local5) ; Jump
			(gMessager say: 7 6 47) ; "You need to get out of this cage before you can do anything else."
		else
			(switch theVerb
				(4 ; Do
					(cond
						(
							(or
								(not (gEgo has: 44)) ; theTorch
								(not ((gInventory at: 44) state:)) ; theTorch
							)
							(gMessager say: 5 4 12) ; "The valve won't budge. If you had a bit more light maybe you'd be able to see how to open it."
						)
						((and local12 (not (IsFlag 323)))
							(gMessager say: 5 4 48) ; "The valve won't open. You're trapped!"
						)
						(
							(and
								(gEgo has: 44) ; theTorch
								((gInventory at: 44) state:) ; theTorch
								(gEgo has: 5) ; theThrowdagger
							)
							(gCurRoom setScript: sExitNorth)
						)
						((not (gEgo has: 5)) ; theThrowdagger
							(gMessager say: 5 4 26) ; "Your fingers are a little to big too pry the valve open; you need something with a sharp edge to free the valve."
						)
					)
				)
				(10 ; Jump
					(gCurRoom doVerb: theVerb)
				)
				(20 ; ???
					(self doVerb: 4)
				)
				(else
					(super doVerb: theVerb &rest)
				)
			)
		)
	)
)

(instance leftEfx of Prop
	(properties
		approachX 197
		approachY 89
		x 214
		y 57
		priority 74
		fixPriority 1
		view 770
		signal 16384
		detailLevel 3
	)

	(method (init)
		(super init:)
		(if (IsFlag 303)
			(self cue: signal: (| (self signal:) $0001))
		else
			(self signal: (& (self signal:) $fffe) hide:)
		)
	)

	(method (doVerb)
		(leftTHolder doVerb: &rest)
	)

	(method (cue)
		(self setLoop: 1 1 setCycle: RandCycle)
	)
)

(instance rightEfx of Prop
	(properties
		approachX 230
		approachY 93
		x 250
		y 69
		priority 88
		fixPriority 1
		view 770
		loop 2
		signal 20480
		detailLevel 3
	)

	(method (init)
		(super init:)
		(cond
			((IsFlag 302)
				(self hide:)
			)
			((IsFlag 304)
				(self cue: signal: (| (self signal:) $0001))
			)
			(else
				(self signal: (& (self signal:) $fffe) hide:)
			)
		)
	)

	(method (doVerb)
		(rightTHolder doVerb: &rest)
	)

	(method (cue)
		(self setLoop: 3 1 setCycle: RandCycle)
	)
)

(instance body1 of Feature
	(properties
		noun 9
		nsLeft 75
		nsTop 138
		nsRight 122
		nsBottom 158
		x 98
		y 148
	)

	(method (init)
		(super init:)
		(if (!= gPrevRoomNum 720)
			(gTheDoits add: self)
		)
	)

	(method (handleEvent event)
		(if (== (event message:) JOY_DOWNRIGHT)
			(if (self onMe: (event x:) (event y:))
				(= local20 1)
			else
				(= local20 0)
			)
		)
		(super handleEvent: event &rest)
	)

	(method (doit)
		(if
			(and
				(not heading)
				(self onMe: (gEgo x:) (gEgo y:))
				(not (gCurRoom script:))
				(not local20)
			)
			(gCurRoom setScript: sGetTrapped 0 self)
		)
	)

	(method (doVerb theVerb)
		(if (and (not (== theVerb 10)) local5) ; Jump
			(gMessager say: 7 6 47) ; "You need to get out of this cage before you can do anything else."
		else
			(switch theVerb
				(4 ; Do
					(if (!= gPrevRoomNum 720)
						(if heading
							(gMessager say: 9 4 27) ; "You find nothing else useful on the body."
						else
							(= heading 1)
							(gCurRoom setScript: sGetItem 0 self)
						)
					else
						(super doVerb: theVerb)
					)
				)
				(10 ; Jump
					(gCurRoom doVerb: theVerb)
				)
				(else
					(super doVerb: theVerb)
				)
			)
		)
	)

	(method (dispose)
		(if (!= gPrevRoomNum 720)
			(gTheDoits delete: self)
		)
		(super dispose:)
	)
)

(instance body2 of Feature
	(properties
		noun 10
		nsLeft 131
		nsTop 102
		nsRight 161
		nsBottom 116
		approachX 150
		approachY 109
		x 146
		y 109
	)

	(method (init)
		(super init:)
		(if (!= gPrevRoomNum 720)
			(gTheDoits add: self)
		)
	)

	(method (doVerb theVerb)
		(if (and (not (== theVerb 10)) local5) ; Jump
			(gMessager say: 7 6 47) ; "You need to get out of this cage before you can do anything else."
		else
			(switch theVerb
				(4 ; Do
					(if (!= gPrevRoomNum 720)
						(if heading
							(gMessager say: 10 4 28) ; "You find nothing else useful on the body."
						else
							(= heading 1)
							(gCurRoom setScript: sGetItem 0 self)
						)
					else
						(super doVerb: theVerb)
					)
				)
				(10 ; Jump
					(gCurRoom doVerb: theVerb)
				)
				(else
					(super doVerb: theVerb)
				)
			)
		)
	)

	(method (dispose)
		(if (!= gPrevRoomNum 720)
			(gTheDoits delete: self)
		)
		(super dispose:)
	)
)

(instance body3 of Feature
	(properties
		noun 11
		nsLeft 153
		nsTop 91
		nsRight 179
		nsBottom 106
		approachX 170
		approachY 98
		x 166
		y 98
	)

	(method (init)
		(super init:)
		(if (!= gPrevRoomNum 720)
			(gTheDoits add: self)
		)
	)

	(method (doVerb theVerb)
		(if (and (not (== theVerb 10)) local5) ; Jump
			(gMessager say: 7 6 47) ; "You need to get out of this cage before you can do anything else."
		else
			(switch theVerb
				(4 ; Do
					(if (!= gPrevRoomNum 720)
						(if heading
							(gMessager say: 11 4 29) ; "You find nothing else useful on the body."
						else
							(= heading 1)
							(gCurRoom setScript: sGetItem 0 self)
						)
					else
						(super doVerb: theVerb)
					)
				)
				(10 ; Jump
					(gCurRoom doVerb: theVerb)
				)
				(else
					(super doVerb: theVerb)
				)
			)
		)
	)

	(method (dispose)
		(if (!= gPrevRoomNum 720)
			(gTheDoits delete: self)
		)
		(super dispose:)
	)
)

(instance leftTHolder of TargFeature
	(properties
		noun 3
		nsLeft 207
		nsTop 51
		nsRight 225
		nsBottom 70
		approachX 201
		approachY 82
		x 213
		y 109
		z 50
	)

	(method (dispose)
		(if (and gList (gList contains: self))
			(gList delete: self)
		)
		(if (and gList (not (gList size:)))
			(gList dispose:)
			(= gList 0)
		)
		(gFeatures delete: self)
		(DisposeClone self)
	)

	(method (getHurt)
		(gList delete: self)
		(leftEfx setScript: sFlameTorch 0 leftEfx)
	)

	(method (doVerb theVerb &tmp temp0)
		(if (and (not (== theVerb 10)) local5) ; Jump
			(gMessager say: 7 6 47) ; "You need to get out of this cage before you can do anything else."
		else
			(switch theVerb
				(1 ; Look
					(if (IsFlag 303)
						(gMessager say: 1 1 2) ; "The torch glows with a flickering light."
					else
						(gMessager say: 3 1 1) ; "The torch is firmly embedded in its holder."
					)
				)
				(76 ; theTorch
					(cond
						((and (== gHeroType 2) (IsFlag 323)) ; Thief
							(gMessager say: 3 76 45) ; "You can't reach the torch through the bone cage that surrounds you."
						)
						(((gInventory at: 44) state:) ; theTorch
							(if (IsFlag 303)
								(gMessager say: 3 76 8) ; "Both torches are already lit."
							else
								(gMessager say: 3 76 9) ; "You light the torch in the sconce with the one you are carrying."
								(gCurRoom setScript: sLightTorch 0 leftEfx)
							)
						)
						((IsFlag 303)
							(localproc_2)
							(gCurRoom doTorch: 1)
							(gMessager say: 3 76 10) ; "You light your torch from the one in the sconce."
						)
						(else
							(gMessager say: 3 76 11) ; "You touch the two unlit torches together. Not surprisingly, nothing happens."
						)
					)
				)
				(39 ; theFlint
					(cond
						((and (== gHeroType 2) (IsFlag 323)) ; Thief
							(gMessager say: 3 76 45) ; "You can't reach the torch through the bone cage that surrounds you."
						)
						((gEgo has: 5) ; theThrowdagger
							(if (!= (leftEfx loop:) 1)
								(gMessager say: 1 39 1) ; "You strike sparks off the flint using your dagger. The torch soon begins to burn, almost as if by magic."
								(gCurRoom setScript: sLightTorch 0 leftEfx)
							else
								(gMessager say: 1 39 2) ; "The torch is already lit."
							)
						)
						(else
							(gMessager say: 1 39 7) ; "You attempt to light the torch using your piece of flint, but you don't have anything with which to create a spark. You'll need to find something made of steel."
						)
					)
				)
				(86 ; flameDartSpell
					(cond
						(local17
							(gMessager say: 0 0 42) ; "You're too busy to cast a spell right now. Better think of something else FAST!"
						)
						(local5
							(gCurRoom setScript: sCastFlame)
						)
						(else
							(gCurRoom setScript: (ScriptID 32) 0 86) ; project
						)
					)
				)
				(10 ; Jump
					(gCurRoom doVerb: theVerb)
				)
				(else
					(super doVerb: theVerb)
				)
			)
		)
	)
)

(instance rightTHolder of TargFeature
	(properties
		noun 1
		nsLeft 241
		nsTop 64
		nsRight 265
		nsBottom 90
		approachX 230
		approachY 93
		x 249
		y 108
		z 40
	)

	(method (dispose)
		(if (and gList (gList contains: self))
			(gList delete: self)
		)
		(if (and gList (not (gList size:)))
			(gList dispose:)
			(= gList 0)
		)
		(gFeatures delete: self)
		(DisposeClone self)
	)

	(method (getHurt)
		(if (IsFlag 302)
			(gMessager say: 1 86 3) ; "The sconce is empty, so your Flame Dart has no effect."
		else
			(gList delete: self)
			(rightEfx setScript: sFlameTorch 0 rightEfx)
		)
	)

	(method (doVerb theVerb &tmp temp0)
		(if (and (not (== theVerb 10)) local5) ; Jump
			(gMessager say: 7 6 47) ; "You need to get out of this cage before you can do anything else."
		else
			(switch theVerb
				(1 ; Look
					(cond
						((and (not (IsFlag 302)) (not (IsFlag 304)))
							(gMessager say: 1 1 1) ; "It looks like a torch, but there doesn't appear to be any pitch or other flammable material on it."
						)
						((and (not (IsFlag 302)) (IsFlag 304))
							(gMessager say: 1 1 2) ; "The torch glows with a flickering light."
						)
						(else
							(super doVerb: theVerb)
						)
					)
				)
				(4 ; Do
					(if (not (IsFlag 302))
						(if (gEgo has: 44) ; theTorch
							(gMessager say: 3 4 40) ; "The sconce doesn't budge."
						else
							(gCurRoom setScript: sTakeTorch 0 rightEfx)
						)
					else
						(gMessager say: 1 4 43) ; "There is nothing in the torch holder."
					)
				)
				(76 ; theTorch
					(cond
						((IsFlag 302)
							(gCurRoom setScript: sPlaceTorch 0 rightEfx)
						)
						(((gInventory at: 44) state:) ; theTorch
							(if (IsFlag 304)
								(gMessager say: 3 76 8) ; "Both torches are already lit."
							else
								(gMessager say: 3 76 9) ; "You light the torch in the sconce with the one you are carrying."
								(gCurRoom setScript: sLightTorch 0 rightEfx)
							)
						)
						((IsFlag 304)
							(localproc_2)
							(gCurRoom doTorch: 1)
							(gMessager say: 3 76 10) ; "You light your torch from the one in the sconce."
						)
						(else
							(gMessager say: 3 76 11) ; "You touch the two unlit torches together. Not surprisingly, nothing happens."
						)
					)
				)
				(39 ; theFlint
					(if (not (IsFlag 302))
						(if (gEgo has: 5) ; theThrowdagger
							(if (!= (rightEfx loop:) 3)
								(gMessager say: 1 39 1) ; "You strike sparks off the flint using your dagger. The torch soon begins to burn, almost as if by magic."
								(gCurRoom setScript: sLightTorch 0 rightEfx)
							else
								(gMessager say: 1 39 2) ; "The torch is already lit."
							)
						else
							(gMessager say: 1 39 7) ; "You attempt to light the torch using your piece of flint, but you don't have anything with which to create a spark. You'll need to find something made of steel."
						)
					else
						(gMessager say: 1 4 43) ; "There is nothing in the torch holder."
					)
				)
				(10 ; Jump
					(gCurRoom doVerb: theVerb)
				)
				(86 ; flameDartSpell
					(cond
						(local17
							(gMessager say: 0 0 42) ; "You're too busy to cast a spell right now. Better think of something else FAST!"
						)
						(local5
							(gCurRoom setScript: sCastFlame)
						)
						(else
							(gCurRoom setScript: (ScriptID 32) 0 86) ; project
						)
					)
				)
				(else
					(super doVerb: theVerb)
				)
			)
		)
	)
)

(instance altar of Feature
	(properties
		noun 4
		nsLeft 223
		nsTop 5
		nsRight 260
		nsBottom 65
		sightAngle 40
		approachX 222
		approachY 77
		x 247
		y 65
	)

	(method (doVerb theVerb)
		(if (and (not (== theVerb 10)) local5) ; Jump
			(gMessager say: 7 6 47) ; "You need to get out of this cage before you can do anything else."
		else
			(switch theVerb
				(43 ; theDarksign
					(if (IsFlag 302)
						(gMessager say: 7 6 44) ; "The altar doesn't look quite ready for the ritual somehow. The lighting isn't quite right."
					else
						(= local12 1)
						(gEgo drop: 25) ; theDarksign
						(gMessager say: 7 6 41) ; "You press the Dark One Sign against the top of the altar. The sand swirls and shifts to form a mirror image of the sign on the altar surface."
					)
				)
				(67 ; theBoneRit
					(cond
						((or (not (IsFlag 303)) (not (IsFlag 304)))
							(gMessager say: 7 6 46) ; "The lighting isn't quite appropriate for this Ritual. You need to make some preparations first."
						)
						((IsFlag 302)
							(gMessager say: 7 6 44) ; "The altar doesn't look quite ready for the ritual somehow. The lighting isn't quite right."
						)
						((not local12)
							(gMessager say: 7 6 16) ; "There are lines in the sand as if it has been used in the past to form pictures. There is no apparent pattern to the lines at the moment."
						)
						(else
							(gCurRoom setScript: sDoCage)
						)
					)
				)
				(86 ; flameDartSpell
					(gMessager say: 4 86 0) ; "Your spells have no effect on the Altar."
				)
				(88 ; forceBoltSpell
					(gMessager say: 4 88 0) ; "Your spells have no effect on the Altar."
				)
				(79 ; frostSpell
					(gMessager say: 4 79 0) ; "Your spells have no effect on the Altar."
				)
				(93 ; lightningBallSpell
					(gMessager say: 4 93 0) ; "Your spells have no effect on the Altar."
				)
				(10 ; Jump
					(gCurRoom doVerb: theVerb)
				)
				(1 ; Look
					(if (IsFlag 323)
						(gMessager say: 4 1 6) ; "The sands on the Bone Altar shift under your gaze as if they (and the altar) are alive. Green flames flicker around the magical torches."
					else
						(gMessager say: 4 1 5) ; "This is some kind of altar to the Dark One. The top is covered with sand. Torch-holders flank the altar to provide light for nameless rites and unspeakable rituals."
					)
				)
				(76 ; theTorch
					(rightTHolder doVerb: theVerb)
				)
				(else
					(super doVerb: theVerb)
				)
			)
		)
	)
)

(instance egoTeller of Teller
	(properties
		actionVerb 4
	)

	(method (showCases)
		(super
			showCases:
				32 ; Break Cage
				(or (== gHeroType 0) (== gHeroType 3)) ; Fighter, Paladin
				33 ; Break Cage
				(or (== gHeroType 1) (== gHeroType 2)) ; Magic User, Thief
				34 ; Climb Over Cage
				[gEgoStats 11] ; climbing
				35 ; Jump Out of Cage
				(== gHeroType 2) ; Thief
		)
	)

	(method (sayMessage)
		(switch iconValue
			(32 ; Break Cage
				(gCurRoom setScript: sBreakBones 0 0)
				(self clean:)
			)
			(35 ; Jump Out of Cage
				(gCurRoom setScript: sJumpOut)
			)
			(else
				(super sayMessage: &rest)
			)
		)
	)
)

(instance soundFX of Sound
	(properties)
)

