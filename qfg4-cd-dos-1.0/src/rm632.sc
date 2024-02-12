;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 632)
(include sci.sh)
(use Main)
(use GloryRm)
(use TargFeature)
(use DeathIcon)
(use Scaler)
(use DPath)
(use Chase)
(use Sound)
(use Jump)
(use Motion)
(use System)

(public
	rm632 0
)

(local
	local0
	local1
	local2
)

(instance rm632 of GloryRm
	(properties
		modNum 620
		picture 620
		north 663
	)

	(method (init)
		(if (!= gPrevRoomNum 810) ; combat
			(= gCombatResult 0)
			(if (not (IsFlag 331))
				(aBad1 health: 50)
			)
			(if (not (IsFlag 332))
				(aBad2 health: 50)
			)
			(if (not (IsFlag 333))
				(aBad3 health: 50)
			)
			(if (not (IsFlag 334))
				(aBad4 health: 50)
			)
		else
			(if (> global156 0)
				(aBad1 health: global156)
			else
				(= global156 0)
				(SetFlag 331)
				(aBad1 health: 0)
			)
			(if (> global462 0)
				(aBad2 health: global462)
			else
				(= global462 0)
				(SetFlag 332)
				(aBad2 health: 0)
			)
			(if (> global463 0)
				(aBad3 health: global463)
			else
				(= global463 0)
				(SetFlag 333)
				(aBad3 health: 0)
			)
			(if (> global464 0)
				(aBad4 health: global464)
			else
				(= global464 0)
				(SetFlag 334)
				(aBad4 health: 0)
			)
		)
		(switch gPrevRoomNum
			(663
				(batSound play:)
				(SetFlag 251)
				(gEgo posn: 88 32)
			)
			(810 ; combat
				(switch gCombatResult
					(1
						(batSound play:)
						(gCurRoom setScript: sEgosDead)
					)
					(2
						(gEgo posn: 260 163)
						(gCurRoom setScript: sMonstersDead)
					)
					(else
						(batSound play:)
						(if (IsFlag 251)
							(gEgo x: 91 y: 36)
						else
							(gEgo x: 269 y: 167)
						)
						(gCurRoom setScript: sHeroRan)
					)
				)
			)
			(else
				(batSound play:)
				(ClearFlag 251)
				(gEgo posn: 276 152)
			)
		)
		((ScriptID 633 0) init:) ; rm620Code
		(if (!= gPrevRoomNum 810) ; combat
			(gEgo init: normalize: (if (== gPrevRoomNum 644) 2 else 3))
		)
		(if (aBad1 health:)
			(aBad1 setPri: 196 init: ignoreActors: 1 setScript: sBad1)
		)
		(if (aBad2 health:)
			(aBad2 setPri: 196 init: ignoreActors: 1 setScript: sBad2)
		)
		(if (aBad3 health:)
			(aBad3 setPri: 196 init: ignoreActors: 1 setScript: sBad3)
		)
		(if (aBad4 health:)
			(aBad4 setPri: 196 init: ignoreActors: 1 setScript: sBad4)
		)
		(super init: &rest)
		(if
			(and
				(not (== gPrevRoomNum 810)) ; combat
				(== gHeroType 3) ; Paladin
				(or
					(not (IsFlag 331))
					(not (IsFlag 332))
					(not (IsFlag 333))
					(not (IsFlag 334))
				)
			)
			(gMessager say: 4 6 24 0 0 620) ; "You sense danger in the air, flapping on bat-like wings around you."
		)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(1 ; Look
				(gMessager say: 0 1 0 0 0 632) ; "You are on a winding stairway in the far eastern wing of the castle. Torches line the walls. The floor is thick with bat droppings. There are doors at the top and bottom of the stairs."
			)
			(91 ; jugglingLightsSpell
				(gMessager say: 7 91 0 1 0 620) ; "You can't cast that spell here."
			)
			(21 ; theRocks
				(gCurRoom setScript: (ScriptID 32) 0 21) ; project
			)
			(37 ; theThrowdagger
				(gCurRoom setScript: (ScriptID 32) 0 37) ; project
			)
			(86 ; flameDartSpell
				(gCurRoom setScript: (ScriptID 32) 0 86) ; project
			)
			(88 ; forceBoltSpell
				(gCurRoom setScript: (ScriptID 32) 0 88) ; project
			)
			(93 ; lightningBallSpell
				(gCurRoom setScript: (ScriptID 32) 0 93) ; project
			)
			(79 ; frostSpell
				(gCurRoom setScript: (ScriptID 32) 0 79) ; project
			)
			(85 ; calmSpell
				(if (IsFlag 334)
					(gMessager say: 4 6 35 0 0 620) ; "Those badders look REALLY calm now... almost comatose."
				else
					(= local2 1)
					(gMessager say: 0 85 29 0 0 620) ; "The Badders seem to be flying in more relaxed patterns now."
					(return 1)
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)

	(method (newRoom newRoomNumber)
		(if (== newRoomNumber 810) ; combat
			(= global156 (aBad1 health:))
			(= global462 (aBad2 health:))
			(= global463 (aBad3 health:))
			(= global464 (aBad4 health:))
		)
		(= gCombatMonsterNum 825) ; badder
		(if (== newRoomNumber 810) ; combat
			(gLongSong doSongs: fade:)
		)
		(gLongSong2 stop:)
		(super newRoom: newRoomNumber)
	)

	(method (dispose)
		(if script
			(script dispose:)
		)
		((ScriptID 633 3) stop: clean: (ScriptID 633 3)) ; wasMusic3, wasMusic3
		(DisposeScript 633)
		(super dispose:)
	)
)

(instance sHeroRan of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGlory handsOn:)
				(gEgo init:)
				(gLongSong fade:)
				(= ticks 30)
			)
			(1
				(gGlory handsOff:)
				(gLongSong doSongs: 630 631 632)
				(if (IsFlag 251)
					((ScriptID 633 2) setCycle: End self) ; pUpperDoor
				else
					((ScriptID 633 1) setCycle: End self) ; pBottomDoor
				)
			)
			(2
				(gEgo setMotion: MoveTo (gEgo x:) (- (gEgo y:) 5) self)
			)
			(3
				(if (IsFlag 251)
					(gCurRoom newRoom: (gCurRoom north:))
				else
					(gCurRoom newRoom: 644)
				)
			)
		)
	)
)

(instance sGoToCombat of Script ; UNUSED
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGlory handsOff:)
				(= gCombatMonsterNum 825) ; badder
				(= seconds 2)
			)
			(1
				(if local2
					(gGlory handsOn:)
					(self dispose:)
				else
					(gCurRoom newRoom: 810) ; combat
				)
			)
		)
	)
)

(instance sEgosDead of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGlory handsOff:)
				(gEgo init: view: 6 setLoop: 0 1 setCel: 0 x: 271 y: 180)
				(= cycles 1)
			)
			(1
				(gEgo setCycle: End self)
			)
			(2
				(EgoDead 29 620) ; "The badders just swooped down and did you in. Even weak monsters can be dangerous if there are enough of them."
			)
		)
	)
)

(instance sMonstersDead of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGlory handsOff:)
				(gLongSong fade:)
				(= local1 (gEgo cycleSpeed:))
				(gEgo
					init:
					x: 271
					y: 180
					view: 13
					setCel: 0
					setLoop: 1 1
					cycleSpeed: global433
				)
				(= ticks 30)
			)
			(1
				(gLongSong number: 107 setLoop: 1 play: self)
				(gEgo setCycle: End)
			)
			(2
				(gLongSong doSongs: 630 631 632)
				(gEgo setSpeed: local1 normalize: 2)
				(gGlory handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sDeadBadders of Script ; UNUSED
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGlory handsOff:)
				(= seconds 2)
			)
			(1
				(aBad1
					setLoop: 4 1
					setCel: 0
					setCycle: 0
					setMotion: JumpTo 186 169
				)
				(aBad2
					setLoop: 4 1
					setCel: 0
					setCycle: 0
					setMotion: JumpTo 51 112
				)
				(aBad3
					setLoop: 4 1
					setCel: 0
					setCycle: 0
					setMotion: JumpTo 263 170
				)
				(aBad4
					setLoop: 4 1
					setCel: 0
					setCycle: 0
					setMotion: JumpTo 265 170
				)
				(= seconds 2)
			)
			(2
				(gGlory handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sBad1 of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= ticks 2)
			)
			(1
				(aBad1
					setCycle: Fwd
					ignoreActors: 1
					signal: (| (aBad1 signal:) $0001)
					setMotion: DPath 150 148 231 43 105 48 62 71 self
				)
			)
			(2
				(aBad1 setMotion: Chase gEgo 10)
			)
		)
	)
)

(instance sBad2 of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= ticks 2)
			)
			(1
				(aBad2
					setCycle: Fwd
					ignoreActors: 1
					signal: (| (aBad1 signal:) $0001)
					setMotion: DPath 259 101 194 157 146 14 self
				)
			)
			(2
				(aBad2 setMotion: Chase gEgo 10)
			)
		)
	)
)

(instance sBad3 of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= ticks 2)
			)
			(1
				(aBad3
					setCycle: Fwd
					ignoreActors: 1
					signal: (| (aBad1 signal:) $0001)
					setMotion: DPath 225 72 282 80 262 45 self
				)
			)
			(2
				(aBad3 setMotion: Chase gEgo 10)
			)
		)
	)
)

(instance sBad4 of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= ticks 2)
			)
			(1
				(aBad4
					setCycle: Fwd
					ignoreActors: 1
					signal: (| (aBad1 signal:) $0001)
					setMotion: DPath 75 180 13 163 118 100 27 134 self
				)
			)
			(2
				(aBad4 setMotion: Chase gEgo 10)
			)
		)
	)
)

(instance sWaitItOut of Script ; UNUSED
	(properties)

	(method (dispose)
		(gLongSong fade: 0)
		(super dispose:)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(if local0
					(= local0 0)
					(self cue:)
				else
					(self cue:)
				)
			)
			(1
				(= cycles 60)
			)
			(2
				(if (not (IsFlag 332))
					(aBad2
						setLoop: 4 1
						setCel: 0
						setCycle: 0
						setMotion: JumpTo 51 112
					)
				)
				(if (not (IsFlag 333))
					(aBad3
						setLoop: 4 1
						setCel: 0
						setCycle: 0
						setMotion: JumpTo 263 170
					)
				)
				(= cycles 60)
			)
			(3
				(if (not (IsFlag 331))
					(aBad1
						setLoop: 4 1
						setCel: 0
						setCycle: 0
						setMotion: JumpTo 186 169
					)
				)
				(if (not (IsFlag 334))
					(aBad4
						setLoop: 4 1
						setCel: 0
						setCycle: 0
						setMotion: JumpTo 265 170
					)
				)
				(= cycles 160)
			)
			(4
				(if local2
					(gGlory handsOn:)
					(self dispose:)
				else
					(gCurRoom newRoom: 810) ; combat
				)
			)
		)
	)
)

(instance sMonsterDies of Script ; UNUSED
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(if (< global156 1)
					(SetFlag 331)
				)
				(if (< global462 1)
					(SetFlag 332)
				)
				(if (< global463 1)
					(SetFlag 333)
				)
				(if (< global464 1)
					(SetFlag 334)
				)
				(= seconds 1)
			)
			(1
				(if (IsFlag 331)
					0
				else
					(aBad1 init: setCycle: Fwd setScript: sBad1)
				)
				(if (IsFlag 332)
					0
				else
					(aBad2 init: setCycle: Fwd setScript: sBad2)
				)
				(if (IsFlag 333)
					0
				else
					(aBad3 init: setCycle: Fwd setScript: sBad3)
				)
				(if (IsFlag 334)
					0
				else
					(aBad4 init: setCycle: Fwd setScript: sBad4)
				)
				(= ticks 30)
			)
			(2
				(switch gCombatResult
					(1
						(cond
							((IsFlag 334) 0)
							((IsFlag 333)
								(= global156 global464)
								(= global464 0)
							)
							((IsFlag 332)
								(= global156 global463)
								(= global463 0)
							)
							((IsFlag 331)
								(= global156 global462)
								(= global462 0)
							)
							(else 0)
						)
						(gEgo
							view: 6
							setLoop: 0 1
							setCel: 0
							setCycle: End self
						)
					)
					(2
						(self cue:)
					)
					(3
						(gCurRoom newRoom: 810) ; combat
					)
				)
			)
			(3
				(self cue:)
			)
			(4
				(cond
					((IsFlag 334)
						(gGlory handsOn:)
						(self dispose:)
					)
					(local2
						(gGlory handsOn:)
						(self dispose:)
					)
					(else
						(gCurRoom newRoom: 810) ; combat
					)
				)
			)
		)
	)
)

(class ABad of TargActor
	(properties
		noun 11
		modNum 620
		x 62
		y 71
		priority 196
		fixPriority 1
		view 825
		signal 16385
		health 0
	)

	(method (doit)
		(super doit:)
		(if
			(and
				(!= gCombatResult 1)
				(!= gCombatResult 2)
				(!= gCombatResult 3)
				(<
					(GetDistance
						(gEgo x:)
						(- (gEgo y:) (/ (gEgo scaleY:) 4))
						x
						y
					)
					50
				)
				(> health 0)
				(!= (gCurRoom script:) sEgosDead)
				(not local2)
			)
			(gCurRoom newRoom: 810) ; combat
		)
	)

	(method (getHurt param1 param2)
		(cond
			((== param1 79)
				(if (aBad1 health:)
					(aBad1 getHurt: 86 (+ 16 (/ [gEgoStats 34] 10))) ; frostSpell
				)
				(if (aBad2 health:)
					(aBad2 getHurt: 86 (+ 16 (/ [gEgoStats 34] 10))) ; frostSpell
				)
				(if (aBad3 health:)
					(aBad3 getHurt: 86 (+ 16 (/ [gEgoStats 34] 10))) ; frostSpell
				)
				(if (aBad4 health:)
					(aBad4 getHurt: 86 (+ 16 (/ [gEgoStats 34] 10))) ; frostSpell
				)
				(gMessager say: 11 79 0 0 0 620) ; "Waves of ice and frost envelop the badders."
			)
			((> health 0)
				(-= health param2)
				(batHurt play:)
				(if (< health 1)
					(= health 0)
					(self cue:)
				)
			)
		)
	)
)

(instance aBad1 of ABad
	(properties)

	(method (init)
		(super init: &rest)
		(if (not (== gPrevRoomNum 810)) ; combat
			(= health 50)
		)
		(self setStep: 4 6)
		(self setScaler: Scaler 81 54 115 85)
	)

	(method (cue)
		(SetFlag 331)
		(self setLoop: 4 1 setCel: 0 setCycle: 0 setMotion: JumpTo 186 169)
	)
)

(instance aBad2 of ABad
	(properties
		x 146
		y 14
		loop 1
	)

	(method (init)
		(super init: &rest)
		(self setStep: 4 6)
		(if (not (== gPrevRoomNum 810)) ; combat
			(= health 50)
		)
	)

	(method (cue)
		(SetFlag 332)
		(self setLoop: 4 1 setCel: 0 setCycle: 0 setMotion: JumpTo 51 112)
	)
)

(instance aBad3 of ABad
	(properties
		x 262
		y 45
		loop 2
		scaleSignal 1
	)

	(method (init)
		(if (not (== gPrevRoomNum 810)) ; combat
			(= health 50)
		)
		(super init: &rest)
		(self setStep: 4 6)
		(self setScaler: Scaler 100 55 94 37)
	)

	(method (cue)
		(SetFlag 333)
		(self setLoop: 4 1 setCel: 0 setCycle: 0 setMotion: JumpTo 263 170)
	)
)

(instance aBad4 of ABad
	(properties
		x 27
		y 134
		loop 3
	)

	(method (init)
		(super init: &rest)
		(self setStep: 4 6)
		(if (not (== gPrevRoomNum 810)) ; combat
			(= health 50)
		)
	)

	(method (cue)
		(SetFlag 334)
		(aBad4 setLoop: 4 1 setCel: 0 setCycle: 0 setMotion: JumpTo 265 170)
	)
)

(instance batSound of Sound
	(properties
		number 132
	)
)

(instance batHurt of Sound
	(properties
		number 828
	)
)

