;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 190)
(include sci.sh)
(use Main)
(use stoneDove)
(use Motion)
(use System)

(public
	doveMad 0
)

(local
	local0
	local1
	local2
	local3
)

(instance doveMad of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(if (IsFlag 210)
					(SetFlag 211)
					(= global194 1)
					(ClearFlag 203)
					(SetFlag 205)
					(HandsOn)
					(client dispose:)
				else
					(HandsOff)
					(= cycles 2)
					((ScriptID 177 2) init:) ; theDove
				)
			)
			(1
				(= global198 60)
				(switch gCurRoomNum
					(75
						((ScriptID 177 2) posn: -1 5 85 setLoop: 2) ; theDove
						(= local0 3)
					)
					(76
						((ScriptID 177 2) posn: -2 233 85 setLoop: 6) ; theDove
						(= local0 2)
					)
					(77
						((ScriptID 177 2) posn: 329 239 85 setLoop: 5) ; theDove
						(= local0 2)
					)
					(78
						((ScriptID 177 2) posn: 317 -2 85 setLoop: 1) ; theDove
						(= local0 3)
					)
				)
				((ScriptID 177 2) init: setCycle: Fwd) ; theDove
				(= local2 (gEgo x:))
				(= local3 (gEgo y:))
				(if (< (gEgo x:) 65)
					(= local2 65)
				)
				(if (> (gEgo x:) 254)
					(= local2 254)
				)
				(if (< (gEgo y:) 74)
					(= local3 74)
				)
				(if (> (gEgo y:) 161)
					(= local3 161)
					(if (and (== gCurRoomNum 78) (< 99 (gEgo x:) 190))
						(= local2 81)
						(= local3 148)
						(if (> (gEgo x:) 144)
							(= local2 205)
						)
					)
				)
				(switch gCurRoomNum
					(78
						(if (gEgo inRect: 0 0 100 70)
							(= local2 65)
							(= local3 54)
						)
					)
					(75
						(cond
							((gEgo inRect: 178 160 312 189)
								(= local2 226)
								(= local3 152)
							)
							((gEgo inRect: 144 157 179 189)
								(= local2 124)
								(= local3 154)
							)
						)
					)
					(76
						(cond
							((gEgo inRect: 256 111 500 131)
								(= local2 271)
								(= local3 145)
							)
							((gEgo inRect: 89 54 113 67)
								(= local2 47)
								(= local3 82)
							)
						)
					)
				)
				(if (or (!= (gEgo x:) local2) (!= (gEgo y:) local3))
					(gEgo
						illegalBits: 0
						setMotion: MoveTo local2 local3 self
					)
				else
					(self cue:)
				)
			)
			(2
				(gEgo illegalBits: -32768)
				((ScriptID 177 3) ; doveShadow
					signal: 16384
					setPri: ((ScriptID 177 3) priority:) ; doveShadow
				)
				((ScriptID 177 2) ; theDove
					signal: 18432
					setMotion:
						MoveTo
						(+ (gEgo x:) (if (== gCurRoomNum 75) -62 else 62))
						(gEgo y:)
						self
				)
			)
			(3
				(proc177_4 190 0) ; "I warn you, mortal, do NOT keep me waiting!."
				(= local1 5)
				((ScriptID 177 3) setScript: (ScriptID 189 0) 0 local0) ; doveShadow, circleEgo
			)
			(4
				(= global194 0)
				(SetFlag 204)
				(SetFlag 209)
				(if (== gCurRoomNum 75)
					(SetFlag 192)
				else
					(ClearFlag 192)
				)
				(SetFlag 210)
				(self dispose:)
			)
		)
	)

	(method (dispose)
		(SetFlag 220)
		(super dispose:)
	)
)

