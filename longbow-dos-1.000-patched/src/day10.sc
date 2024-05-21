;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 533)
(include sci.sh)
(use Main)
(use verseScript)
(use rhEgo)
(use RTEyeCycle)
(use PPath)
(use PChase)
(use Polygon)
(use MoveFwd)
(use StopWalk)
(use Sound)
(use Motion)
(use System)

(public
	day10 0
)

(local
	[local0 9] = [535 0 2 4 26 38 22 26 27]
	[local9 9] = [1533 0 1 2 1 2 1 1 0]
	[local18 6] = [1533 6 2 1 1 0]
	[local24 4] = [1533 9 1 0]
	[local28 6] = [1533 10 1 2 1 0]
	[local34 4] = [1533 13 1 0]
	[local38 8] = [1533 14 2 1 2 2 1 0]
	[local46 9] = [1533 19 2 1 2 1 2 1 0]
	[local55 4] = [1533 25 2 0]
	[local59 4] = [1533 26 1 0]
	[local63 8] = [1533 27 1 2 1 1 2 0]
	[local71 4] = [1533 32 1 0]
	[local75 6] = [1533 33 1 2 1 0]
	[local81 4] = [1533 36 2 0]
	[local85 4] = [1533 37 1 0]
	[local89 5] = [1533 38 2 1 0]
	[local94 4] = [1533 40 1 0]
	[local98 5] = [1533 41 1 2 0]
	[local103 5] = [1533 43 2 1 0]
	[local108 6] = [1533 45 2 1 1 0]
	[local114 5] = [1533 48 2 1 0]
	[local119 5] = [1533 50 2 1 0]
	[local124 4] = [1533 53 1 0]
	local128
	[local129 9] = [257 124 233 121 212 123 183 129 -32768]
)

(instance day10 of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo posn: 153 220 setHeading: 0 setMotion: MoveFwd 40)
				(gCurRoom
					addObstacle:
						((Polygon new:)
							type: PContainedAccess
							init: 150 240 171 183 198 176 226 176 226 170 254 170 247 164 290 151 235 158 227 148 202 148 202 136 209 136 209 129 50 129 85 132 43 162 0 181
							yourself:
						)
						((Polygon new:)
							type: PBarredAccess
							init: 175 141 136 188 93 188 97 180 83 180 77 187 46 187 91 148 142 148 148 141
							yourself:
						)
				)
				(= seconds 2)
			)
			(1
				((ScriptID 530 1) ; keeper
					approachX: 183
					approachY: 160
					setMotion: PPath @local129 self
				)
			)
			(2
				(Face (ScriptID 530 1) gEgo self) ; keeper
			)
			(3
				(= cycles 2)
			)
			(4
				(= register (+ (if (IsFlag 140) 2) (if (IsFlag 210) 1)))
				(SetFlag 210)
				(++ gRoomCount)
				(switch register
					(0
						(Converse @local9 @local0 2 self 0) ; "Are you mad to come here within the shadow of the castle? Leave at once!"
					)
					(1
						(Converse @local24 @local0 0 self) ; "You must be desperate indeed to come here yet again."
					)
					(2
						(Converse @local28 @local0 2 self) ; "What do you want here, outlaw?"
					)
					(3
						(Converse @local34 @local0 0 self) ; "Why did you return? I told you before, I can do nothing for you."
					)
				)
				(if register
					(++ state)
				)
			)
			(5
				(Converse @local18 @local0 999 self) ; "And you?"
			)
			(6
				((ScriptID 530 1) ignoreActors: 0 actions: guardTunnels) ; keeper
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance guardTunnels of SpecialDoVerb
	(properties)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(3 ; Do
				(Converse @local124 @local0 0) ; "Don't try to force your way past me, outlaw. I fought in the Crusades and I've no fear of any man that faces me fairly."
			)
			(5 ; Talk
				(cond
					((IsFlag 32)
						(= local128 2)
					)
					((IsFlag 31)
						(= local128 1)
						(SetFlag 32)
					)
					(else
						(= local128 0)
						(SetFlag 31)
					)
				)
				(if (IsFlag 140)
					(switch local128
						(0
							(Converse @local38 @local0 2) ; "I need your help."
						)
						(1
							(Converse @local46 @local0 999) ; "I only ask that you unlock your cellar door and let me pass."
						)
						(2
							((ScriptID 530 1) setScript: letIn 0 1) ; keeper
						)
					)
				else
					(switch local128
						(0
							(Converse @local38 @local0 2) ; "I need your help."
						)
						(1
							(Converse @local75 @local0 999) ; "I cannot see why you come to me for help, at any rate."
						)
						(2
							((ScriptID 530 1) setScript: letIn 0 0) ; keeper
						)
					)
				)
			)
			(10 ; Longbow
				((ScriptID 530 1) setScript: threaten) ; keeper
			)
			(4 ; Inventory
				(if (== invItem 0) ; bucks
					((ScriptID 530 1) setScript: bribe) ; keeper
					(return 1)
				else
					(return 0)
				)
			)
		)
	)
)

(instance letIn of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(SetScore 50)
				(Converse (if register @local55 else @local81) @local0 2 self 0)
			)
			(1
				(Converse @local63 @local0 2 self 0) ; "What? It's the Lady Marian they're burning?!"
			)
			(2
				(Converse (if register @local59 else @local85) @local0 2 self)
			)
			(3
				(gEgo
					moveSpeed: 3
					cycleSpeed: 3
					setMotion: PFollow (ScriptID 530 1) 25 ; keeper
				)
				((ScriptID 530 1) ; keeper
					moveSpeed: 3
					cycleSpeed: 3
					setMotion: MoveTo 181 107 self
				)
			)
			(4
				(if register
					(Converse @local71 @local0 0 self) ; "Godspeed!"
				else
					(= cycles 1)
				)
			)
			(5
				(gCurRoom newRoom: 550)
			)
		)
	)
)

(instance threaten of Script
	(properties)

	(method (dispose)
		(shootSound stop: dispose:)
		(super dispose: &rest)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(Face gEgo (ScriptID 530 1) self) ; keeper
			)
			(1
				(gEgo view: 4 cel: 0 setCycle: End self)
			)
			(2
				(shootSound play:)
				(gEgo view: 5 cel: 0)
				(gEgo setCycle: CT (- (gEgo lastCel:) 1) 1 self)
			)
			(3
				(Converse @local89 @local0 2 self) ; "I've no time for fancy words. Unlock the door to your back room and be quick about it!"
			)
			(4
				(gEgo setCycle: Beg self)
			)
			(5
				(gEgo
					view: 0
					setCycle: StopWalk 1
					setMotion: PFollow (ScriptID 530 1) 60 ; keeper
				)
				((ScriptID 530 1) setMotion: MoveTo 196 113 self) ; keeper
			)
			(6
				(Face (ScriptID 530 1) (ScriptID 530 2) self) ; keeper, gate
			)
			(7
				((ScriptID 530 2) ; gate
					signal: (& ((ScriptID 530 2) signal:) $feff) ; gate
					startUpd:
					setCycle: End self
				)
			)
			(8
				(gEgo view: 5 cel: 0 setMotion: 0)
				(gEgo setCycle: CT (- (gEgo lastCel:) 1) 1 self)
			)
			(9
				(= ticks 20)
			)
			(10
				(Converse 1 @local94 2 3 self) ; "Now stand well aside. Make haste!"
			)
			(11
				((ScriptID 530 1) setMotion: MoveTo 251 123 self) ; keeper
			)
			(12
				(Face (ScriptID 530 1) gEgo self) ; keeper
			)
			(13
				(Converse @local98 @local0 2 self) ; "If I live, I swear you'll regret treating me in this high-handed way!"
			)
			(14
				(gEgo setCycle: Beg self)
			)
			(15
				(gEgo
					view: 0
					setCycle: StopWalk 1
					setMotion: MoveTo 191 107 self
				)
			)
			(16
				(SetScore -75)
				(SetFlag 141)
				(gCurRoom newRoom: 550)
			)
		)
	)
)

(instance bribe of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= register (gMoney doit:))
				(if (not register)
					(self dispose:)
					(return)
				)
				(Converse
					(cond
						((IsFlag 140)
							(if (< register 40) @local103 else @local108)
						)
						((< register 40) @local114)
						(else @local119)
					)
					@local0
					2
					self
				)
			)
			(1
				(if (< register 40)
					(gMoney put:)
					(self dispose:)
				else
					(SetScore 10)
					(gEgo
						moveSpeed: 3
						cycleSpeed: 3
						setMotion: PFollow (ScriptID 530 1) 25 ; keeper
					)
					((ScriptID 530 1) ; keeper
						moveSpeed: 3
						cycleSpeed: 3
						setMotion: MoveTo 181 107 self
					)
				)
			)
			(2
				(gCurRoom newRoom: 550)
			)
		)
	)
)

(instance shootSound of Sound
	(properties
		flags 1
		number 900
		loop -1
	)
)

