;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 204)
(include sci.sh)
(use Main)
(use Rm10)
(use Interface)
(use Motion)
(use Actor)
(use System)

(public
	ElfStart 0
	BoltOfMagic 1
)

(instance ElfStart of Script
	(properties)

	(method (dispose)
		(super dispose:)
		(DisposeScript 204)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				((ScriptID 10 2) init: setCycle: End self) ; elf
				(gTObj tWindow: (ScriptID 10 3) tLoop: 2 init:) ; elfWindow
				(gRmMusic number: 92 loop: 1 play:)
			)
			(1
				(gTObj talkCue: self)
				(if (IsFlag 17)
					(proc10_1 204 0) ; "Copper or tin! Copper or tin! Copper or tin for Widdershins! I am no troll but that is my toll! Copper or tin for Widdershins! Give me my way or a trick I will play!"
				else
					(proc10_1 204 1) ; "Copper or tin! Copper or tin! Copper or tin for Widdershins! I am no troll but that is my toll! Copper or tin for Widdershins!"
				)
			)
			(2
				(HandsOn)
				(client setScript: 0)
			)
		)
	)
)

(instance BoltOfMagic of Script
	(properties)

	(method (dispose)
		(magic dispose: delete:)
		(super dispose:)
		(DisposeScript 204)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gTObj endTalk:)
				((ScriptID 10 2) loop: register cel: 0) ; elf
				(magic init:)
				(= cycles 4)
			)
			(1
				(gSFX number: 56 loop: 1 play:)
				(magic
					setMotion:
						MoveTo
						(+ (gEgo x:) 5)
						(- (gEgo y:) 30)
						self
				)
			)
			(2
				(magic setLoop: 7 cel: 0 setCycle: End)
				((ScriptID 10 2) setLoop: 1 cel: 5 setCycle: Beg self) ; elf
			)
			(3
				((ScriptID 10 2) dispose:) ; elf
				(if (or global122 global121)
					(= global191 global122)
					(= global192 global121)
					(= global122 (= global121 0))
					(Print 204 2) ; "The trick has been played and I fear the sprite's bolt of mischief was aimed squarely at your purse."
					(HandsOn)
					(SetFlag 45)
				else
					(SetFlag 37)
					(SetFlag 39)
				)
				(client setScript: 0)
			)
		)
	)
)

(instance magic of Act
	(properties
		yStep 6
		view 110
		signal 16384
		illegalBits 0
		xStep 9
	)

	(method (init)
		(super init:)
		(self setLoop: 6 setPri: (+ (gEgo priority:) 1) setCycle: Fwd)
		(if (== ((ScriptID 10 2) loop:) 5) ; elf
			(self posn: 174 62)
		else
			(self posn: 162 65)
		)
	)
)

