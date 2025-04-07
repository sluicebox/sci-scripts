;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 710)
(include sci.sh)
(use Main)
(use GloryRm)
(use TargFeature)
(use Teller)
(use DeathIcon)
(use Scaler)
(use RandCycle)
(use PolyPath)
(use Polygon)
(use Feature)
(use Motion)
(use Actor)
(use System)

(public
	rm710 0
	sLevitateOverPit 1
	torchEff 2
	sCombatOrNot 3
)

(local
	local0
	local1
	local2
	local3
	local4 = 1
	local5
	local6 = 1
	local7
)

(instance rm710 of GloryRm
	(properties
		picture 710
	)

	(method (init)
		(if gDebugging
			(SetFlag 101)
			(= gPrevRoomNum 790)
		)
		(switch gPrevRoomNum
			(810 ; combat
				(gLongSong number: 203 setLoop: -1)
				(cond
					((IsFlag 462)
						(gLongSong play:)
					)
					((IsFlag 459)
						(gLongSong mute: 1 9 play:)
					)
					((IsFlag 457)
						(gLongSong mute: 1 7 mute: 1 9 play:)
					)
					((IsFlag 455)
						(gLongSong
							mute: 1 6
							mute: 1 7
							mute: 1 8
							mute: 1 9
							play:
						)
					)
					(else
						(gLongSong
							mute: 1 5
							mute: 1 6
							mute: 1 7
							mute: 1 8
							mute: 1 9
							play:
						)
					)
				)
				(gEgo
					init:
					x: 177
					y: 171
					normalize: 0
					setPri: 152
					setScaler: Scaler 71 39 95 29
				)
				(torchEff setPri: 152)
				(gCurRoom
					addObstacle:
						((Polygon new:)
							type: PBarredAccess
							init: 0 189 0 0 319 0 319 189 150 189 150 184 266 185 284 161 258 161 221 161 210 154 210 140 173 140 167 163 146 163 127 189
							yourself:
						)
				)
			)
			(790
				(gLongSong
					number: 203
					setLoop: -1
					mute: 1 5
					mute: 1 6
					mute: 1 7
					mute: 1 8
					mute: 1 9
					play:
				)
				(gEgo init: normalize: setScaler: Scaler 71 39 95 29)
			)
			(else
				(gEgo init: normalize: setScaler: Scaler 71 39 95 29)
			)
		)
		(gWalkHandler addToFront: self)
		(RemapColors 1 253 112 173 62) ; ByRange
		(torchEff init: setScaler: gEgo setCycle: RandCycle)
		(blowBit1 init: setCycle: Fwd)
		(blowBit2 init: setCycle: Fwd)
		(blowBit3 init: setCycle: Fwd)
		(blowBit4 init: setCycle: Fwd)
		(leftExitF init: approachVerbs: 4) ; Do
		(rightExitF init: approachVerbs: 4) ; Do
		(bridge init:)
		(pillar init:)
		(upperLedge init:)
		(lowerLedge init:)
		(largeCave init:)
		(smallCave init:)
		(backLedge init:)
		(if (== gPrevRoomNum 790)
			(= global156 400)
		)
		(if (IsFlag 101)
			(SetFlag 373)
			(gEgo changeGait:)
			(if (not (IsFlag 461))
				(book init: approachVerbs: 4) ; Do
			)
			(priestHorror init:)
			(cond
				((<= global156 0)
					(priestHorror loop: 1 cel: 0)
				)
				((== gHeroType 2) ; Thief
					(priestHorror setScript: sHorrorSleeps)
				)
				(else
					(= local4 0)
					(priestHorror loop: 1 cel: 2)
				)
			)
		else
			(gEgo code: warnCode)
			(tentacle init: hide:)
		)
		(super init: &rest)
		(cond
			((== gPrevRoomNum 790)
				(SetFlag 373)
				(self
					addObstacle:
						((Polygon new:)
							type: PBarredAccess
							init: 8 105 60 94 110 94 106 88 138 88 164 74 131 74 113 65 59 65 28 47 94 0 319 0 319 189 0 189 0 0 20 0 46 24 14 48 32 62 8 69
							yourself:
						)
						((Polygon new:)
							type: PBarredAccess
							init: 102 68 112 75 109 86 27 88 17 78 29 68
							yourself:
						)
				)
				(gEgo x: 50 y: 28 changeGait:)
				(self setScript: sEnter 0 1)
			)
			((== gPrevRoomNum 810) ; combat
				(if (== gCombatResult 1)
					(self setScript: sHorrorKillsEgo)
				else
					(self setScript: sBackFromCombat)
				)
			)
			(else
				(self
					addObstacle:
						((Polygon new:)
							type: PBarredAccess
							init: 271 47 293 58 271 64 286 68 304 63 315 45 293 36 619 11 319 189 0 189 0 0 267 0 302 19 284 35 241 37 248 43 202 43 202 47
							yourself:
						)
				)
				(gEgo x: 308 y: 21)
				(self setScript: sEnter)
			)
		)
		(gGlory save: 1)
	)

	(method (doit)
		(super doit: &rest)
		(cond
			(script)
			(
				(gEgo
					inRect:
						(leftExitF nsLeft:)
						(leftExitF nsTop:)
						(leftExitF nsRight:)
						(leftExitF nsBottom:)
				)
				(if (IsFlag 101)
					(gEgo setMotion: 0)
					(self setScript: backOff)
				else
					(leftExitF doVerb: 4)
				)
			)
			(
				(gEgo
					inRect:
						(rightExitF nsLeft:)
						(rightExitF nsTop:)
						(rightExitF nsRight:)
						(rightExitF nsBottom:)
				)
				(rightExitF doVerb: 4)
			)
			(
				(and
					(not (< (gEgo y:) 125))
					(> global156 0)
					(== gHeroType 2) ; Thief
					(!= gEgoGait 2) ; sneaking
					(or
						(== ((gTheIconBar getCursor:) view:) 940)
						(== ((gTheIconBar getCursor:) view:) 942)
					)
				)
				(gCurRoom setScript: sHorrorWakes)
			)
		)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(89 ; levitateSpell
				(cond
					((IsFlag 101)
						(cond
							((and (> (gEgo x:) 190) (< (gEgo y:) 125))
								(gCurRoom setScript: (ScriptID 711 4)) ; sLeviDownRt
							)
							((and (< (gEgo x:) 190) (< (gEgo y:) 125))
								(gCurRoom setScript: (ScriptID 711 2)) ; sLeviDown
							)
							(
								(and
									(not (< (gEgo y:) 125))
									(> (gEgo x:) 160)
								)
								(gCurRoom setScript: (ScriptID 711 5)) ; sLeviUpRt
							)
							(else
								(gCurRoom setScript: (ScriptID 711 3)) ; sLeviUp
							)
						)
					)
					((and (> (gEgo x:) 190) (< (gEgo y:) 125))
						((ScriptID 31 0) init: 222 45 30 0 2) ; leviCode
					)
					(else
						((ScriptID 31 0) init: 119 79 35 0 2) ; leviCode
					)
				)
			)
			(86 ; flameDartSpell
				(gMessager say: 0 86 0) ; "You'd better not do that until you have a target. The way magic is misbehaving in these caves, you might burn yourself up!"
			)
			(85 ; calmSpell
				(if
					(and
						(IsFlag 101)
						(or
							(and (!= gHeroType 2) (not local3)) ; Thief
							(and (== gHeroType 2) (not local4)) ; Thief
						)
						(> global156 0)
					)
					(gCurRoom setScript: sCalmDazzlePH 0 0)
				else
					(super doVerb: theVerb &rest)
				)
			)
			(83 ; dazzleSpell
				(if
					(and
						(IsFlag 101)
						(or
							(and (!= gHeroType 2) (not local3)) ; Thief
							(and (== gHeroType 2) (not local4)) ; Thief
						)
						(> global156 0)
					)
					(gCurRoom setScript: sCalmDazzlePH 0 1)
				else
					(super doVerb: theVerb &rest)
				)
			)
			(10 ; Jump
				(gMessager say: 0 159 0) ; "The pit is too wide to jump."
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)

	(method (setScript param1)
		(if (== param1 (ScriptID 31 1)) ; sLevitate
			(param1 next: sLevitateDone)
		)
		(super setScript: param1 &rest)
	)

	(method (dispose)
		(gWalkHandler delete: self)
		(super dispose: &rest)
	)
)

(instance warnCode of Code
	(properties)

	(method (doit)
		(if (< (gEgo x:) 215)
			(gEgo code: 0 setMotion: 0)
			(gCurRoom setScript: warnBack)
		)
	)
)

(instance fallCode of Code
	(properties)

	(method (doit)
		(if (< (gEgo x:) 203)
			(gEgo code: 0 setMotion: 0)
			(gCurRoom setScript: sTentacleDeath 0 0)
		)
	)
)

(instance warnBack of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGlory handsOff:)
				(gMessager say: 10 6 1 0 self) ; "Whoa! The ground is really slippery around here; there seems to be a layer of slime all over it."
			)
			(1
				(gEgo code: fallCode)
				(gGlory handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance backOff of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGlory handsOff:)
				(gMessager say: 10 6 34 0 self) ; "You can't leave. The mouth closed behind you when you entered."
			)
			(1
				(gEgo setMotion: PolyPath 28 55 self)
			)
			(2
				(gGlory handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance crossByHand of Script
	(properties)

	(method (doit)
		(super doit: &rest)
		(if (== state 2)
			(gEgo useStamina: 1)
		)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGlory handsOff:)
				((gCurRoom obstacles:) dispose:)
				(gCurRoom obstacles: 0)
				(gEgo code: 0 setMotion: MoveTo 206 46 self)
			)
			(1
				(= gTempEgoSpeed (gEgo cycleSpeed:))
				(gEgo
					cycleSpeed: global433
					moveSpeed: global433
					view: 7
					setLoop: 4 1
					cel: 11
					setCycle: Beg self
				)
			)
			(2
				(if (not (IsFlag 403))
					(gEgo solvePuzzle: 403 15)
				)
				(= local6 2)
				(gEgo
					x: 205
					y: 58
					z: 25
					view: 39
					setLoop: 1 1
					setCycle: Walk
					setMotion: MoveTo 162 63 self
				)
				(if (not (IsFlag 101))
					(tentacle setScript: sTentacleDeath 0 1)
				)
			)
			(3
				(if (not (IsFlag 392))
					(SetFlag 392)
					(gMessager say: 10 6 32 0 self) ; "You just barely made it across the pit."
				else
					(self cue:)
				)
			)
			(4
				(if (not (IsFlag 101))
					((tentacle script:) cue:)
				)
				(= local6 1)
				(gCurRoom
					addObstacle:
						((Polygon new:)
							type: PBarredAccess
							init: 8 105 60 94 110 94 106 88 138 88 164 74 131 74 113 65 59 65 28 47 94 0 319 0 319 189 0 189 0 0 20 0 46 24 14 48 32 62 8 69
							yourself:
						)
						((Polygon new:)
							type: PBarredAccess
							init: 102 68 112 75 109 86 27 88 17 78 29 68
							yourself:
						)
				)
				(gEgo
					y: 73
					z: 0
					normalize: 1
					cycleSpeed: gTempEgoSpeed
					moveSpeed: gTempEgoSpeed
				)
				(gGlory handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance crossByHandLeft of Script
	(properties)

	(method (doit)
		(super doit: &rest)
		(if (== state 1)
			(gEgo useStamina: 1)
		)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGlory handsOff:)
				((gCurRoom obstacles:) dispose:)
				(gCurRoom obstacles: 0)
				(gEgo setMotion: MoveTo 162 73 self)
			)
			(1
				(= gTempEgoSpeed (gEgo cycleSpeed:))
				(if (not (IsFlag 101))
					(tentacle setScript: sTentacleDeath 0 1)
				)
				(= local6 2)
				(gEgo
					cycleSpeed: global433
					moveSpeed: global433
					y: 63
					z: 25
					view: 39
					setLoop: 0 1
					setCycle: Walk
					setMotion: MoveTo 197 60 self
				)
			)
			(2
				(= local6 1)
				(gEgo
					z: 0
					y: 46
					view: 7
					setLoop: 5 1
					cel: 0
					setCycle: End self
				)
			)
			(3
				(gEgo
					normalize: 0
					cycleSpeed: gTempEgoSpeed
					moveSpeed: gTempEgoSpeed
					setMotion: PolyPath 230 46 self
				)
			)
			(4
				(if (not (IsFlag 101))
					((tentacle script:) cue:)
				)
				(gCurRoom
					addObstacle:
						((Polygon new:)
							type: PBarredAccess
							init: 271 47 293 58 271 64 286 68 304 63 315 45 293 36 619 11 319 189 0 189 0 0 267 0 302 19 284 35 241 37 248 43 202 43 202 47
							yourself:
						)
				)
				(gEgo code: warnCode)
				(gGlory handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance tightRope of Script
	(properties)

	(method (doit)
		(super doit: &rest)
		(if (or (== state 4) (== state 5))
			(gEgo useStamina: 1)
		)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGlory handsOff:)
				((gCurRoom obstacles:) dispose:)
				(gCurRoom obstacles: 0)
				(gEgo code: 0 setMotion: MoveTo 226 44 self)
			)
			(1
				(gEgo normalize: 3)
				(= ticks 15)
			)
			(2
				(= gTempEgoSpeed (gEgo cycleSpeed:))
				(if (not (IsFlag 101))
					(tentacle setScript: sTentacleDeath 0 1)
				)
				(gEgo
					cycleSpeed: global433
					moveSpeed: global433
					x: 227
					y: 54
					z: 29
					view: 7
					setLoop: 4 1
					cel: 0
					setCycle: End self
				)
			)
			(3
				(if (not (IsFlag 403))
					(gEgo solvePuzzle: 403 15)
				)
				(gEgo
					x: 224
					y: 39
					z: 10
					view: 12
					setLoop: 1 1
					setCycle: Walk
					setMotion: MoveTo 213 43 self
				)
			)
			(4
				(gEgo setMotion: MoveTo 196 47 self)
			)
			(5
				(gEgo setMotion: MoveTo 177 51 self)
			)
			(6
				(gEgo setMotion: MoveTo 152 51 self)
			)
			(7
				(gEgo
					y: 65
					z: 25
					view: 7
					setLoop: 4 1
					cel: 11
					setCycle: Beg self
				)
			)
			(8
				(if (not (IsFlag 392))
					(SetFlag 392)
					(gMessager say: 10 6 32 0 self) ; "You just barely made it across the pit."
				else
					(self cue:)
				)
			)
			(9
				(if (not (IsFlag 101))
					((tentacle script:) cue:)
				)
				(gEgo
					view: 7
					setLoop: 3 1
					cel: 0
					y: 61
					z: 0
					setCycle: Walk
					setMotion: MoveTo 152 74 self
				)
			)
			(10
				(gEgo
					normalize: 3
					cycleSpeed: gTempEgoSpeed
					moveSpeed: gTempEgoSpeed
				)
				(gCurRoom
					addObstacle:
						((Polygon new:)
							type: PBarredAccess
							init: 8 105 60 94 110 94 106 88 138 88 164 74 131 74 113 65 59 65 28 47 94 0 319 0 319 189 0 189 0 0 20 0 46 24 14 48 32 62 8 69
							yourself:
						)
						((Polygon new:)
							type: PBarredAccess
							init: 102 68 112 75 109 86 27 88 17 78 29 68
							yourself:
						)
				)
				(gGlory handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance tightRopeLeft of Script
	(properties)

	(method (doit)
		(super doit: &rest)
		(if (or (== state 6) (== state 7))
			(gEgo useStamina: 1)
		)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGlory handsOff:)
				((gCurRoom obstacles:) dispose:)
				(gCurRoom obstacles: 0)
				(gEgo setMotion: MoveTo 152 74 self)
			)
			(1
				(gEgo normalize: 3)
				(= ticks 15)
			)
			(2
				(= gTempEgoSpeed (gEgo cycleSpeed:))
				(gEgo
					view: 7
					setLoop: 3 1
					cel: 0
					setCycle: Walk
					setSpeed: 15
					setMotion: MoveTo 152 61 self
				)
			)
			(3
				(gEgo
					setSpeed: global433
					y: 65
					z: 25
					view: 7
					setLoop: 5 1
					cel: 0
					setCycle: End self
				)
			)
			(4
				(if (not (IsFlag 101))
					(tentacle setScript: sTentacleDeath 0 1)
				)
				(gEgo
					x: 152
					y: 51
					z: 10
					view: 12
					setLoop: 0 1
					setCycle: Walk
					setMotion: MoveTo 152 51 self
				)
			)
			(5
				(gEgo setMotion: MoveTo 177 51 self)
			)
			(6
				(gEgo setMotion: MoveTo 196 47 self)
			)
			(7
				(gEgo setMotion: MoveTo 213 43 self)
			)
			(8
				(gEgo setMotion: MoveTo 224 39 self)
			)
			(9
				(gEgo
					view: 7
					x: 227
					y: 50
					z: 25
					setLoop: 4 1
					cel: 11
					setCycle: Beg self
				)
			)
			(10
				(if (not (IsFlag 101))
					((tentacle script:) cue:)
				)
				(gCurRoom
					addObstacle:
						((Polygon new:)
							type: PBarredAccess
							init: 271 47 293 58 271 64 286 68 304 63 315 45 293 36 619 11 319 189 0 189 0 0 267 0 302 19 284 35 241 37 248 43 202 43 202 47
							yourself:
						)
				)
				(gEgo
					x: 226
					y: 44
					z: 0
					setSpeed: gTempEgoSpeed
					code: warnCode
					normalize: 0
				)
				(gGlory handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sLevitateOverPit of Script
	(properties)

	(method (handleEvent event)
		(if (and (== state 3) (OneOf (event type:) evKEYBOARD $0020 evMOUSEBUTTON)) ; joyUp
			(if (== (event message:) KEY_Y)
				(= register 1)
			else
				(= register 0)
			)
			(self cue:)
			(event claimed: 1)
			(return)
		else
			(super handleEvent: event)
		)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				0
				(gGlory handsOff:)
				(= register (if (> (gEgo x:) 190) 1 else 0))
				(if register
					(gEgo setMotion: PolyPath 218 48 self)
				else
					(gEgo setMotion: PolyPath 143 83 self)
				)
			)
			(1
				1
				(= local2 (gEgo cycleSpeed:))
				(gEgo
					view: 711
					loop: 0
					cel: 0
					cycleSpeed: 8
					setCycle: End self
				)
			)
			(2
				2
				(gMessager say: 10 6 7 0 self) ; "As you hold up the sheet like a sail, you can feel the wind pushing it (and you) towards the pit. Unfortunately, you're a little too heavy. You don't think the wind is powerful enough to push you across safely."
			)
			(3
				3
				(gEgo cycleSpeed: local2 setLoop: 1 1 setCycle: Fwd)
				(gKeyDownHandler addToFront: self)
				(gMouseDownHandler addToFront: self)
				(gGlory handsOn:)
			)
			(4
				4
				(gGlory handsOff:)
				(gKeyDownHandler delete: self)
				(gMouseDownHandler delete: self)
				(if register
					(= cycles 1)
				else
					(self changeState: 8)
				)
			)
			(5
				5
				(if (not (IsFlag 101))
					(tentacle setScript: sTentacleDeath 0 1)
				)
				(if (not (IsFlag 403))
					(gEgo solvePuzzle: 403 15)
				)
				((gCurRoom obstacles:) dispose:)
				(gCurRoom obstacles: 0)
				(gEgo code: 0)
				(gLongSong2 number: 941 play:)
				(sparklies init: setCycle: Fwd)
				(if register
					(gEgo setMotion: MoveTo 143 83 self)
				else
					(gEgo setMotion: MoveTo 218 48 self)
				)
			)
			(6
				6
				(if (not (IsFlag 101))
					((tentacle script:) cue:)
				)
				(if register
					(gCurRoom
						addObstacle:
							((Polygon new:)
								type: PBarredAccess
								init: 8 105 60 94 110 94 106 88 138 88 164 74 131 74 113 65 59 65 28 47 94 0 319 0 319 189 0 189 0 0 20 0 46 24 14 48 32 62 8 69
								yourself:
							)
							((Polygon new:)
								type: PBarredAccess
								init: 102 68 112 75 109 86 27 88 17 78 29 68
								yourself:
							)
					)
				else
					(gCurRoom
						addObstacle:
							((Polygon new:)
								type: PBarredAccess
								init: 271 47 293 58 271 64 286 68 304 63 315 45 293 36 619 11 319 189 0 189 0 0 267 0 302 19 284 35 241 37 248 43 202 43 202 47
								yourself:
							)
					)
				)
				(sparklies dispose:)
				(gLongSong2 fade:)
				(= cycles 2)
			)
			(7
				7
				(= state 8)
				(if (not (IsFlag 392))
					(SetFlag 392)
					(gMessager say: 10 6 32 0 self) ; "You just barely made it across the pit."
				else
					(self cue:)
				)
			)
			(8
				8
				(gMessager say: 10 6 8 0 self) ; "It's hard to do much with the wind pushing at your sheet, so you put it away."
			)
			(9
				9
				(= local2 (gEgo cycleSpeed:))
				(gEgo
					view: 711
					setLoop: 0 1
					setCel: 2
					cycleSpeed: 8
					setCycle: Beg self
				)
			)
			(10
				10
				(gEgo cycleSpeed: local2 normalize: 1)
				(gGlory handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sLevitateDone of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGlory handsOff:)
				(gMessager say: 10 6 9 0 self) ; "You could definitely feel the wind rushing past you as you floated in the air, but there wasn't quite enough "push." You need to find a way to catch more of the wind to sail your way across."
			)
			(1
				(gGlory handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sTentacleDeath of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				0
				(if (not register)
					(gGlory handsOff:)
				)
				(tentacle setLoop: 0 1 setCel: 0 show: setCycle: End self)
			)
			(1
				1
				(tentacle setLoop: 1 1 setCel: 0 setCycle: End self)
			)
			(2
				2
				(= cycles 6)
			)
			(3
				3
				(if register
					(= state 5)
					(tentacle setCycle: RandCycle tentacle)
				else
					(tentacle setLoop: 4 1 setCel: 0 setCycle: CT 3 1 self)
				)
			)
			(4
				4
				(gEgo hide:)
				(torchEff hide:)
				(tentacle cycleSpeed: 10 setCycle: End self)
			)
			(5
				5
				(EgoDead 1 710 6) ; "The tentacle is faster than the eye. It's strong, too, as you are unceremoniously yanked to the Horror and then apart."
			)
			(6
				6
				(tentacle setLoop: 0 1 setCel: 10 setCycle: Beg self)
			)
			(7
				7
				(tentacle hide:)
				(= register 0)
				(self dispose:)
			)
		)
	)
)

(instance sCombatOrNot of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGlory handsOff:)
				(if
					(and
						(IsFlag 101)
						(or
							(and (!= gHeroType 2) (not local3)) ; Thief
							(and (== gHeroType 2) (not local4)) ; Thief
						)
						(> global156 0)
					)
					(self setScript: sGoToCombat)
				else
					(= cycles 1)
				)
			)
			(1
				(gGlory handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sHorrorSleeps of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= cycles 6)
			)
			(1
				(priestHorror setCel: 0)
				(= seconds 2)
			)
			(2
				(= state -1)
				(priestHorror setCycle: End self)
			)
		)
	)
)

(instance sGetBook of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGlory handsOff:)
				(if register
					(= cycles 1)
				else
					(gEgo
						view: 4
						loop: 0
						cel: 0
						x: 182
						y: 165
						setCycle: End self
					)
				)
			)
			(1
				(book hide:)
				(gEgo solvePuzzle: 461 15)
				(if register
					(= cycles 2)
				else
					(gEgo setCycle: Beg self)
				)
			)
			(2
				(if register
					(gMessager say: 14 87 16 0 self) ; "Your spell travels down to the cave floor and draws up a large, well-worn book. It seems to be a nobleman's diary."
				else
					(gEgo x: 185 y: 165 normalize: 0 setPri: 185)
					(= cycles 1)
				)
			)
			(3
				(gMessager say: 10 6 22 0 self) ; "You pick up the book and read it. It is the diary of the last Boyar. It seems the thing in the pit was the last Borgov. Being a servant of the Dark One didn't do much for his looks or disposition."
			)
			(4
				(gEgo setPri: -1)
				(gGlory handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sHorrorFetch of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGlory handsOff:)
				(gMessager say: 14 87 10 0 self) ; "The Horror strikes out long before your spell can fetch the book. You don't have a chance of taking it as long as the creature is alive, awake, and active."
			)
			(1
				(gGlory handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sHorrorWakes of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGlory handsOff:)
				(priestHorror setScript: 0 setCycle: End self)
			)
			(1
				(if local5
					(priestHorror loop: 1 cel: 0 setCycle: End self)
				else
					(priestHorror loop: 1 cel: 0 setCycle: CT 1 1 self)
				)
			)
			(2
				(if local5
					(gMessager say: 10 6 20 0 self) ; "Now you've done it! The Horror has woken up completely and it looks HUNGRY! You're also having some trouble keeping the contents of your stomach at the sight of the creature."
				else
					(= seconds 3)
				)
			)
			(3
				(if local5
					(self setScript: sGoToCombat)
				else
					(gMessager say: 10 6 19 0 self) ; "Uh oh, the disgusting, slimy creature seems to have heard something; it's starting to stir. (You might be in the soup this time; that thing looks as though it can really dish it out!)"
				)
			)
			(4
				(= local5 1)
				(= seconds 2)
			)
			(5
				(priestHorror setCycle: Beg self)
			)
			(6
				(priestHorror loop: 0 setScript: sHorrorSleeps)
				(= cycles 2)
			)
			(7
				(gGlory handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sKillHorror of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGlory handsOff:)
				(priestHorror setCycle: End self)
			)
			(1
				(priestHorror loop: 1 cel: 0 setCycle: End self)
			)
			(2
				(if register
					(gMessager say: 10 6 15 0 self) ; "The horrific creature lets out a final sickening gurgle as it soggily expires."
				else
					(= local4 0)
					(= local3 0)
					(gMessager say: 14 local7 0 0 self)
				)
			)
			(3
				(if register
					(priestHorror setCel: 0)
				)
				(if (not (gCurRoom script:))
					(gGlory handsOn:)
				else
					(= global200 0)
				)
				(self dispose:)
			)
		)
	)
)

(instance sCalmDazzlePH of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGlory handsOff:)
				(= local3 1)
				(if register
					(gMessager say: 0 83 10 0 self) ; "The pit creature has apparently been in this cave so long that it can't stand light; your spell has stunned it temporarily!"
				else
					(gMessager say: 0 85 10 0 self) ; "A gentle feeling of peace suffuses the cave. The horrible creature slowly relaxes and subsides into an uneasy sleep."
				)
			)
			(1
				(if register
					(priestHorror loop: 1 setCel: 1)
				else
					(priestHorror loop: 0 cel: 0 setScript: sHorrorSleeps)
				)
				(= cycles 2)
			)
			(2
				(gGlory handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sGoToCombat of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGlory handsOff:)
				(SetFlag 378)
				(= cycles 2)
			)
			(1
				(gGlory handsOn:)
				(gCurRoom newRoom: 810) ; combat
			)
		)
	)
)

(instance sBackFromCombat of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGlory handsOff:)
				(if (OneOf gHeroType 0 3) ; Fighter, Paladin
					(gEgo solvePuzzle: 489 4 1)
				)
				(= cycles 1)
			)
			(1
				(gGlory handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sHorrorKillsEgo of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGlory handsOff:)
				(= cycles 2)
			)
			(1
				(switch gHeroType
					(1 ; Magic User
						(EgoDead 23 0 937 1 912)
					)
					(2 ; Thief
						(EgoDead 21 0 937 1 912)
					)
					(else
						(EgoDead 12 0 937 1 912)
					)
				)
			)
		)
	)
)

(instance torchEff of Prop
	(properties
		view 775
	)

	(method (onMe)
		(return 0)
	)

	(method (doit)
		(super doit: &rest)
		(= x (gEgo x:))
		(= z (+ (gEgo z:) 1))
		(switch local6
			(1
				(= y (+ (gEgo y:) 1))
			)
			(2
				(= y (+ (gEgo y:) 32))
			)
		)
	)

	(method (doVerb theVerb)
		(gEgo doVerb: theVerb)
	)
)

(instance tentacle of Prop
	(properties
		x 222
		y 123
		view 710
		signal 16385
		cycleSpeed 8
	)
)

(instance priestHorror of TargProp
	(properties
		x 239
		y 140
		view 855
		signal 16385
	)

	(method (getHurt param1 param2)
		(if (<= (-= global156 param2) 0)
			(self setScript: sKillHorror 0 1)
		else
			(self setScript: sKillHorror 0 0)
		)
	)

	(method (doVerb theVerb)
		(cond
			((OneOf theVerb 37 86 88 79 93) ; theThrowdagger, flameDartSpell, forceBoltSpell, frostSpell, lightningBallSpell
				(cond
					((<= global156 0)
						(gMessager say: 10 6 26) ; "The slimy tentacled beast thing from the depths of the underworld is but a carcass now (it also has less adjectives)."
					)
					((and (== theVerb 37) (== ((gInventory at: 5) amount:) 1)) ; theThrowdagger, theThrowdagger
						(gMessager say: 10 6 35) ; "You decide you'd be better off with at least one dagger to defend yourself with."
					)
					(else
						(gEgo setScript: (ScriptID 32) 0 (= local7 theVerb)) ; project
					)
				)
			)
			((== theVerb 1) ; Look
				(cond
					((<= global156 0)
						(gMessager say: 14 1 14) ; "The thing looks dead. It's not easy to tell that a mound of grotesque flesh is dead, mind you, but you've got a feeling for such things now. Dead is dead."
					)
					((== local4 1)
						(gMessager say: 14 1 11) ; "As awful as it now appears, something about the creature's shape suggests that it was once as human as you. Something truly terrible must have occurred to change it to its current shape! The horrible being seems to be asleep."
					)
					((== local3 1)
						(gMessager say: 14 1 28) ; "The beast looks as if it's not paying too much attention to you. It's very mellow right now."
					)
					(else
						(gMessager say: 14 1 10) ; "The gruesome creature is a cross between a squid, chocolate pudding, and your worst nightmares. It looks awake, alert, and as if it would enjoy having you for supper. A large book lies on the ground near it."
					)
				)
			)
			((== theVerb 4) ; Do
				(cond
					((< (gEgo y:) 125)
						(gMessager say: 14 4 27) ; "You can't quite reach him from here."
					)
					((<= global156 0)
						(gMessager say: 14 4 14) ; "The Horror is gross, slimy, and (fortunately) quite dead."
					)
					(else
						(gMessager say: 14 4 11) ; "You walk over to the mound of maggots and wake him up. Dreadfully sporting of you, old chap. Stupid, but sporting."
					)
				)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance blowBit1 of Prop
	(properties
		noun 16
		sightAngle 180
		x 1
		y 98
		priority 1
		fixPriority 1
		view 713
		signal 16385
		cycleSpeed 14
	)
)

(instance blowBit2 of Prop
	(properties
		noun 16
		sightAngle 180
		x 114
		y 67
		priority 1
		fixPriority 1
		view 713
		loop 1
		signal 16385
		cycleSpeed 8
	)
)

(instance blowBit3 of Prop
	(properties
		noun 16
		sightAngle 180
		x 121
		y 161
		priority 170
		fixPriority 1
		view 713
		loop 2
		signal 16385
		cycleSpeed 14
	)

	(method (doVerb theVerb)
		(if (== theVerb 33) ; theGrapnel
			(lowerLedge doVerb: theVerb &rest)
		else
			(super doVerb: theVerb)
		)
	)
)

(instance blowBit4 of Prop
	(properties
		noun 16
		sightAngle 180
		x 195
		y 35
		priority 1
		fixPriority 1
		view 713
		loop 3
		signal 16385
		cycleSpeed 8
	)
)

(instance book of View
	(properties
		noun 15
		sightAngle 180
		approachX 185
		approachY 165
		x 195
		y 158
		priority 130
		fixPriority 1
		view 855
		loop 2
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(if (< (gEgo y:) 125)
					(gMessager say: 15 4 24) ; "You can't reach the book from here."
				else
					(gCurRoom setScript: sGetBook)
				)
			)
			(87 ; fetchSpell
				(if (< (gEgo y:) 125)
					(gGlory handsOff:)
					(gEgo setScript: (ScriptID 37) 0 self) ; castFetchScript
				else
					(gMessager say: 15 87 25) ; "Don't bother; just pick it up."
				)
			)
			(-87 ; fetchSpell (part 2)
				(if (or (<= global156 0) local3 local4)
					(gCurRoom setScript: sGetBook 0 1)
				else
					(gCurRoom setScript: sHorrorFetch)
				)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance ropeTeller of Teller
	(properties
		actionVerb 4
	)

	(method (showCases)
		(super
			showCases:
				4 ; Cross Hand-Over-Hand
				(or
					(OneOf gHeroType 0 3) ; Fighter, Paladin
					(>= [gEgoStats 0] 320) ; strength
					(and (< [gEgoStats 0] 320) (IsFlag 101) (== gHeroType 1)) ; strength, Magic User
				)
				6 ; Fly Across
				(or (OneOf gHeroType 1 3) (>= [gEgoStats 19] 310)) ; Magic User, Paladin, mana
				5 ; Walk the Tightrope
				(or (== gHeroType 2) (>= [gEgoStats 15] 110)) ; Thief, acrobatics
		)
	)

	(method (doVerb theVerb)
		(if (and (== theVerb 4) (IsFlag 388)) ; Do
			(gGlory pragmaFail:)
		else
			(super doVerb: theVerb)
		)
	)

	(method (sayMessage)
		(switch iconValue
			(4 ; Cross Hand-Over-Hand
				(self clean:)
				(if (< (gEgo x:) 170)
					(gCurRoom setScript: crossByHandLeft)
				else
					(gCurRoom setScript: crossByHand)
				)
			)
			(5 ; Walk the Tightrope
				(self clean:)
				(if (< (gEgo x:) 170)
					(gCurRoom setScript: tightRopeLeft)
				else
					(gCurRoom setScript: tightRope)
				)
			)
			(else
				(super sayMessage: &rest)
			)
		)
	)
)

(instance bridge of Feature
	(properties
		noun 3
		nsLeft 128
		nsTop 22
		nsRight 239
		nsBottom 71
		approachX 239
		approachY 45
		x 183
		y 46
	)

	(method (init)
		(self
			onMeCheck:
				((Polygon new:)
					type: PBarredAccess
					init: 125 68 142 34 153 36 186 33 230 20 239 37 229 42 218 41 224 30 186 41 151 44 162 67 138 72
					yourself:
				)
		)
		(super init: &rest)
		(self approachVerbs: 4 1 4) ; Do, Look, Do
		(ropeTeller init: self 710 12 4 11)
	)
)

(instance pillar of Feature
	(properties
		noun 4
		nsLeft 23
		nsRight 107
		nsBottom 83
		x 65
		y 41
	)

	(method (init)
		(self
			onMeCheck:
				((Polygon new:)
					type: PBarredAccess
					init: 25 78 42 68 48 39 39 20 19 0 110 1 88 21 82 42 94 70 105 77 83 86 45 88
					yourself:
				)
		)
		(super init: &rest)
	)
)

(instance upperLedge of Feature
	(properties
		noun 5
		nsTop 66
		nsRight 173
		nsBottom 116
		x 86
		y 91
	)

	(method (handleEvent event)
		(if (< (gEgo y:) 125)
			(= approachY (= approachX 0))
			(self approachVerbs: 0)
		else
			(= approachX 145)
			(= approachY 240)
			(self approachVerbs: 4 33) ; Do, theGrapnel
		)
		(super handleEvent: event &rest)
	)

	(method (init)
		(self
			onMeCheck:
				((Polygon new:)
					type: PTotalAccess
					init: 0 70 12 66 28 61 13 48 20 45 33 51 43 55 42 67 23 78 44 89 84 87 107 77 95 68 93 65 124 65 123 69 137 73 156 72 164 68 164 65 173 67 172 70 160 81 139 89 129 89 109 89 122 93 118 96 110 98 77 95 26 103 15 107 55 110 59 114 23 118 0 117
					yourself:
				)
		)
		(super init: &rest)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(33 ; theGrapnel
				(if (< (gEgo y:) 125)
					(if (> (gEgo x:) 190)
						(gMessager say: 10 6 31) ; "You'll have to cross the pit before you can do that."
					else
						(gCurRoom setScript: (ScriptID 711 0)) ; sClimbDown
					)
				else
					(gCurRoom setScript: (ScriptID 711 1)) ; sClimbUp
				)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance lowerLedge of Feature
	(properties
		noun 6
		nsTop 122
		nsRight 158
		nsBottom 189
		sightAngle 180
		x 79
		y 155
	)

	(method (init)
		(self
			onMeCheck:
				((Polygon new:)
					type: PTotalAccess
					init: 0 185 33 161 53 135 62 125 72 126 74 137 53 158 76 161 105 157 118 148 137 152 130 159 141 162 134 165 89 174 100 179 97 180 79 183 34 189
					yourself:
				)
		)
		(super init: &rest)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(33 ; theGrapnel
				(if (< (gEgo y:) 125)
					(if (> (gEgo x:) 190)
						(gMessager say: 10 6 31) ; "You'll have to cross the pit before you can do that."
					else
						(gCurRoom setScript: (ScriptID 711 0)) ; sClimbDown
					)
				else
					(gCurRoom setScript: (ScriptID 711 1)) ; sClimbUp
				)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance largeCave of Feature
	(properties
		noun 7
		nsLeft 175
		nsTop 101
		nsRight 228
		nsBottom 133
		sightAngle 180
		x 201
		y 117
	)
)

(instance smallCave of Feature
	(properties
		noun 8
		nsLeft 251
		nsTop 117
		nsRight 283
		nsBottom 140
		sightAngle 180
		x 267
		y 128
	)
)

(instance backLedge of Feature
	(properties
		noun 9
		nsLeft 195
		nsTop 29
		nsRight 318
		nsBottom 80
		x 256
		y 54
	)

	(method (init)
		(self
			onMeCheck:
				((Polygon new:)
					type: PTotalAccess
					init: 215 39 218 42 230 43 240 38 238 32 246 33 253 36 273 33 311 38 307 57 302 66 317 69 317 79 294 75 263 65 269 61 288 60 269 48 236 50 200 50 190 47 197 40
					yourself:
				)
		)
		(super init: &rest)
	)
)

(instance leftExitF of Feature
	(properties
		noun 2
		nsRight 51
		nsBottom 52
		sightAngle 40
		approachX 28
		approachY 55
		x 25
		y 26
	)

	(method (handleEvent event)
		(if (and (< (gEgo x:) 190) (< (gEgo y:) 125))
			(self approachVerbs: 4) ; Do
		else
			(self approachVerbs: 0)
		)
		(super handleEvent: event &rest)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(cond
					((not (< (gEgo y:) 125))
						(gMessager say: 10 6 30) ; "You'll have to find a way to get up on the ledge first!"
					)
					((> (gEgo x:) 190)
						(gMessager say: 10 6 29) ; "That might be a useful place to go, but first you need to find a way to get to the other side."
					)
					(else
						(= local0 50)
						(= local1 28)
						(gCurRoom setScript: sExit 0 790)
					)
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance rightExitF of Feature
	(properties
		noun 1
		nsLeft 271
		nsRight 319
		nsBottom 37
		approachX 292
		approachY 40
		x 295
		y 18
	)

	(method (handleEvent event)
		(if (and (> (gEgo x:) 190) (< (gEgo y:) 125))
			(self approachVerbs: 4) ; Do
		else
			(self approachVerbs: 0)
		)
		(super handleEvent: event &rest)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(cond
					((not (< (gEgo y:) 125))
						(gMessager say: 10 6 30) ; "You'll have to find a way to get up on the ledge first!"
					)
					((< (gEgo x:) 190)
						(gMessager say: 10 6 29) ; "That might be a useful place to go, but first you need to find a way to get to the other side."
					)
					(else
						(= local0 308)
						(= local1 21)
						(gCurRoom setScript: sExit 0 720)
					)
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance sparklies of Prop
	(properties
		priority 182
		fixPriority 1
		view 17
		loop 4
		signal 16385
	)

	(method (init)
		(self setScaler: gEgo)
		(super init: &rest)
	)

	(method (doit)
		(= x (gEgo x:))
		(= y (gEgo y:))
		(super doit: &rest)
	)
)

(instance sEnter of Script
	(properties)

	(method (changeState newState &tmp temp0 temp1)
		(switch (= state newState)
			(0
				(gGlory handsOff:)
				(if register
					(if (and (!= gHeroType 1) (< [gEgoStats 11] 100)) ; Magic User, climbing
						(= [gEgoStats 11] 100) ; climbing
					)
					(if (and (!= gHeroType 1) (not (gEgo has: 16))) ; Magic User, theGrapnel
						(gEgo get: 16) ; theGrapnel
					)
					(= temp0 (leftExitF approachX:))
					(= temp1 (leftExitF approachY:))
				else
					(= temp0 (rightExitF approachX:))
					(= temp1 (rightExitF approachY:))
				)
				(gEgo setMotion: PolyPath temp0 temp1 self)
			)
			(1
				(if (and (== gHeroType 3) (not (IsFlag 391))) ; Paladin
					(SetFlag 391)
					(gMessager say: 10 6 33 0 self) ; "Something deadly lies in wait nearby."
				else
					(= cycles 1)
				)
			)
			(2
				(gGlory handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sExit of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGlory handsOff:)
				(gEgo setMotion: PolyPath local0 local1 self)
			)
			(1
				(gCurRoom newRoom: register)
			)
		)
	)
)

