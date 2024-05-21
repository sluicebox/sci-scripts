;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 402)
(include sci.sh)
(use Main)
(use rm400)
(use verseScript)
(use rhEgo)
(use RTEyeCycle)
(use Approach)
(use Motion)

(public
	puckScript 0
	SheriffPuckActions 1
)

(local
	local0
	local1
	local2
	local3
	local4
	[local5 8] = [1402 0 2 3 1 2 1 0]
	[local13 4] = [1402 5 2 0]
	[local17 17] = [1402 6 1 2 1 2 1 1 2 1 2 2 1 2 1 1 0]
	[local34 18] = [1402 20 2 2 0 1402 22 2 1 0 1402 24 2 0 1402 25 2 0]
	[local52 6] = [1402 26 1 2 2 0]
	[local58 8] = [1402 29 1 2 2 1 2 0]
	[local66 8] = [1402 34 1 2 1 2 2 0]
	[local74 8] = [1402 39 1 1 2 1 2 0]
	[local82 5] = [1402 44 1 2 0]
	[local87 6] = [1402 46 1 1 2 0]
	[local93 7] = [1402 49 1 2 1 2 0]
	[local100 5] = [1402 53 1 2 0]
	[local105 9] = [1402 55 1 2 1 2 1 2 0]
	[local114 6] = [1402 61 2 1 2 0]
	[local120 8] = [1402 64 1 2 1 2 1 0]
)

(procedure (localproc_0 param1)
	(Converse 3 param1 999 3 12 1 19 2 &rest)
)

(instance puckScript of TScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(= local0 (ScriptID 400 2)) ; sheriff
				(= local1 (ScriptID 400 3)) ; table
				(= local2 (ScriptID 400 4)) ; guards
				(= local3 (ScriptID 400 5)) ; giles
				(= local4 (ScriptID 400 6)) ; roger
				(SetFlag 146)
				(local0 loop: 2 setCycle: End self)
			)
			(1
				((local3 mover:) xOffset: 15 yOffset: 9)
				((local4 mover:) xOffset: -10 yOffset: -6)
				(local2 setMotion: Approach gEgo 2 self)
			)
			(2
				(localproc_0 @local5 self) ; "How dare you bring this man into my presence without removing his bow and quiver!"
			)
			(3
				(local2 setMotion: GuardFollow gEgo 2)
				(local0 loop: 2 setCycle: Beg self)
			)
			(4
				(gEgo
					setMotion: MoveTo (local1 approachX:) (gEgo y:) self
				)
			)
			(5
				(localproc_0 @local13 self) ; "I'm a busy man. Don't keep me waiting."
			)
			(6
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance wolfsHeadScript of TScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(++ register)
				(= notKilled 1)
				(localproc_0 @local17 self) ; "What is the Wolf's Head being offered upon the head of Robin Hood?"
			)
			(1
				(local0 setLoop: 2 setCycle: End self)
			)
			(2
				(localproc_0 @local34 self) ; "Done! We'll go at once!"
			)
			(3
				(SetScore 50)
				(SetFlag 180)
				(gCurRoom newRoom: 240) ; robbedOne
			)
			(4
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance puckTalkToSheriffArrow of TScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(++ register)
				(localproc_0
					(switch register
						(1 @local52)
						(2 @local58)
						(3 @local66)
						(else @local74)
					)
					self
				)
			)
			(1
				(if (== register 4)
					(self setScript: wolfsHeadScript self)
				else
					(self dispose:)
				)
			)
			(2
				(self dispose:)
			)
		)
	)
)

(instance puckTalkToSheriff of TScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(++ register)
				(localproc_0
					(switch register
						(1 @local82)
						(2 @local87)
						(3 @local93)
						(4 @local100)
						(else @local105)
					)
					self
				)
			)
			(1
				(if (== register 5)
					(self setScript: wolfsHeadScript self)
				else
					(self dispose:)
				)
			)
			(2
				(self dispose:)
			)
		)
	)
)

(instance puckWager of TScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(localproc_0 @local120 self) ; "I've a mind to make you a wager, if this amount will suit you."
			)
			(1
				(self setScript: wolfsHeadScript self)
			)
			(2
				(self dispose:)
			)
		)
	)
)

(instance puckWagerSmall of TScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(localproc_0 @local114 self) ; "What's this for?"
			)
			(1
				(self dispose:)
			)
		)
	)
)

(instance SheriffPuckActions of SpecialDoVerb
	(properties)

	(method (doVerb theVerb invItem &tmp temp0)
		(= temp0 local0)
		(return
			(switch theVerb
				(5 ; Talk
					(temp0
						setScript:
							(if (IsFlag 10)
								puckTalkToSheriffArrow
							else
								puckTalkToSheriff
							)
					)
					1
				)
				(4 ; Inventory
					(switch invItem
						(0 ; bucks
							(cond
								((not (gMoney doit:)))
								((<= 12 (gMoney taken:))
									(temp0 setScript: puckWager)
								)
								(else
									(gMoney put:)
									(temp0 setScript: puckWagerSmall)
								)
							)
							1
						)
					)
				)
			)
		)
	)
)

