;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 355)
(include sci.sh)
(use Main)
(use volleyRm)
(use Interface)
(use tahiti)
(use Sound)
(use Jump)
(use Motion)
(use System)

(public
	playScript 0
)

(instance playScript of Script
	(properties)

	(method (init param1 param2)
		(if argc
			(super init: param1 0 &rest)
			(gIceKeyDownHandler addToFront: self)
			(hit1L init:)
			(hit1R init:)
			(hit2L init:)
			(hit2R init:)
		else
			(super init:)
		)
	)

	(method (dispose)
		(if gModelessDialog
			(gModelessDialog dispose:)
		)
		(gIceKeyDownHandler delete: self)
		(hit1L dispose:)
		(hit1R dispose:)
		(hit2L dispose:)
		(hit2R dispose:)
		(super dispose:)
		(DisposeScript 355)
	)

	(method (handleEvent event &tmp temp0)
		(cond
			((super handleEvent: event)
				(return 1)
			)
			((Said 'kick/volleyball')
				(Print 355 0) ; "You're supposed to hit it."
			)
			((or (Said 'play,join') (Said 'hit/volleyball'))
				(if (gCurRoom notify: 1)
					(proc3_8 4 355 1) ; "You are playing."
				else
					(if (tahiti volley:)
						(proc3_8 4 355 2) ; ""Good, I'm getting exhausted," the girl playing alone says."
					else
						(proc3_8 4 355 3) ; ""Well, jump in here," a girl beckons."
					)
					(= temp0 caller)
					(= caller 0)
					(self setScript: (ScriptID 3 5) client) ; joinGameScript
				)
			)
			((Said 'no')
				(proc3_8 4 355 4) ; "OK," the man says, "take it easy now."
			)
			((Said 'look/game,volleyball')
				(if (gCurRoom notify: 1)
					(proc3_8 4 355 5) ; "You look at the lithe players."
				else
					(proc3_8 4 355 6) ; "You watch a friendly game of volleyball."
				)
			)
			((Said 'stop,exit')
				(if (gCurRoom notify: 1)
					(gCurRoom notify: 1 0)
					(HandsOn)
					(gCurRoom notify: 4)
					(proc3_8 4 355 7) ; "Feeling a little tired, you decide to take a break."
				else
					(proc3_8 4 355 8) ; "They prefer to keep playing."
				)
			)
		)
	)

	(method (changeState newState &tmp temp0)
		(switch (= state newState)
			(0
				(if (< (register x:) ((ScriptID 3 4) x:)) ; Net
					(= register
						(if (Random 0 1)
							(ScriptID 3 1) ; Man
						else
							(ScriptID 3 6) ; Girl2
						)
					)
					(= temp0 (+ (register nsLeft:) 2))
				else
					(= register
						(if (and (gCurRoom notify: 1) (Random 0 1))
							gEgo
						else
							(ScriptID 3 2) ; Girl
						)
					)
					(= temp0 (- (register nsRight:) 2))
				)
				(if caller
					((ScriptID 3 3) setMotion: JumpTo temp0 170 caller) ; Ball
					((ScriptID 3 1) heading: 180 view: 603 loop: 2 cel: 0) ; Man
					((ScriptID 3 6) heading: 180 view: 803 loop: 2 cel: 4) ; Girl2
					((ScriptID 3 2) heading: 180 view: 203 loop: 2 cel: 4) ; Girl
					(if (gCurRoom notify: 1)
						(gEgo heading: 180 view: 200 setLoop: -1)
						(DirLoop gEgo (gEgo heading:))
					)
					(self dispose:)
					(return)
				else
					((ScriptID 3 3) ; Ball
						setMotion: JumpTo temp0 (+ (register nsTop:) 2) self
					)
					(register setScript: (Clone jumpScript))
				)
				(if (< (register x:) ((ScriptID 3 4) x:)) ; Net
					(switch (Random 0 1)
						(0
							(hit1R play:)
						)
						(1
							(hit2R play:)
						)
					)
				else
					(switch (Random 0 1)
						(0
							(hit1L play:)
						)
						(1
							(hit2L play:)
						)
					)
				)
			)
			(1
				(self init:)
			)
		)
	)
)

(instance jumpScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(client setCel: -1 cel: 0 setCycle: 0)
			)
			(1
				(client setCycle: End self)
			)
			(2
				(self dispose:)
			)
		)
	)

	(method (doit &tmp temp0)
		(super doit:)
		(= temp0 (ScriptID 3 3)) ; Ball
		(if
			(and
				(== state 0)
				client
				(not (client cycler:))
				(<
					(Abs (- (temp0 x:) ((temp0 mover:) x:)))
					(*
						(temp0 xStep:)
						(+ 3 (/ (client lastCel:) 2) (mod (client lastCel:) 2))
					)
				)
			)
			(self cue:)
		)
	)
)

(instance hit1L of Sound
	(properties
		number 38
		priority 1
	)
)

(instance hit1R of Sound
	(properties
		number 39
		priority 1
	)
)

(instance hit2L of Sound
	(properties
		number 40
		priority 1
	)
)

(instance hit2R of Sound
	(properties
		number 41
		priority 1
	)
)

