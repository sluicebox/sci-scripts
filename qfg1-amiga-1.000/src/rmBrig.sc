;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 172)
(include sci.sh)
(use Main)
(use Sound)
(use Motion)
(use Game)
(use Actor)
(use System)

(public
	rmBrig 0
)

(local
	local0
	[local1 20]
	[local21 20]
	[local41 20] = [2 4 3 3 2 4 2 2 3 4 1 1 3 4 4 4 4 1 3 1]
	[local61 40] = [156 6 119 25 99 50 79 74 100 102 119 94 107 145 140 173 140 153 170 162 193 175 189 133 211 105 213 59 198 37 181 19 144 35 170 35 140 85 176 125]
)

(procedure (localproc_0)
	(for ((= local0 0)) (< local0 20) ((++ local0))
		(= [local1 local0] (Clone star))
		(= [local21 local0] (Clone starScriptOn))
		([local21 local0] register: [local41 local0])
		([local1 local0]
			cel: 0
			init:
			setPri: 15
			posn: [local61 (* local0 2)] [local61 (+ (* local0 2) 1)]
			setScript: [local21 local0]
		)
	)
)

(procedure (localproc_1)
	(for ((= local0 0)) (< local0 20) ((++ local0))
		(= [local1 local0] (Clone star))
		(= [local21 local0] (Clone starScriptOff))
		([local21 local0] register: [local41 local0])
		([local1 local0]
			cel: (- [local41 local0] 1)
			init:
			setPri: 15
			posn: [local61 (* local0 2)] [local61 (+ (* local0 2) 1)]
			setScript: [local21 local0]
		)
	)
)

(procedure (localproc_2)
	(for ((= local0 19)) (>= local0 0) ((-- local0))
		([local21 local0] dispose:)
		([local1 local0] dispose:)
	)
)

(instance rmBrig of Rm
	(properties
		picture 400
		style 7
	)

	(method (init)
		(Load rsVIEW 473)
		(Load rsVIEW 424)
		(Load rsSOUND 70)
		(super init:)
		(if (IsFlag 273)
			(leader init: setScript: leaderToElsa)
		else
			(leader init: setScript: leaderWait)
		)
	)

	(method (handleEvent event)
		(switch (event type:)
			(evSAID
				(cond
					(
						(or
							(Said
								'cast,use,throw,splash/disenchant,potion[<disenchant]'
							)
							(Said 'disenchant')
						)
						(if (gEgo has: 38) ; disenchant potion
							(SetFlag 273)
							(gEgo use: 38) ; disenchant potion
							(leader setScript: leaderToElsa)
							(HighPrint 172 0) ; "You throw the Dispel Potion on the brigand leader."
						else
							(HighPrint 172 1) ; "Good idea, but you don't have that potion."
						)
					)
					((Said 'look>')
						(if (or (Said '[<at,around][/!*]') (Said '/man,woman'))
							(HighPrint 172 2) ; "You see the brigand leader. From the look in her eyes you've only got seconds to live."
						)
					)
					((Said 'cast')
						(HighPrint 172 3) ; "Casting a spell isn't useful now."
					)
					((Said 'ask')
						(HighPrint 172 4) ; "She's not in a talking mood."
					)
					((Said 'fight')
						(HighPrint 172 5) ; "Not a good idea."
					)
					(else
						(event claimed: 1)
						(HighPrint 172 6) ; "No time for that."
					)
				)
			)
		)
		(super handleEvent: event)
	)
)

(instance leaderToElsa of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(SolvePuzzle 713 35)
				(SetCursor gTheCursor 0)
				(elsaChange init: play:)
				(localproc_0)
				(= cycles 20)
			)
			(1
				(leader setCel: 1)
				(= cycles 20)
			)
			(2
				(localproc_2)
				(localproc_1)
				(= cycles 20)
			)
			(3
				(localproc_2)
				(= cycles 2)
			)
			(4
				(gCurRoom newRoom: 97)
			)
		)
	)
)

(instance leaderWait of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= cycles 20)
			)
			(1
				(HighPrint 172 7) ; "You think that you can fight the brigand leader? You'd best think of some other plan."
				(= cycles 30)
			)
			(2
				(gCurRoom newRoom: 97)
			)
		)
	)
)

(instance starScriptOn of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= cycles (* register 3))
			)
			(1
				(client setCycle: End self)
			)
			(2
				(client loop: 1 cel: 0 setCycle: Fwd)
			)
		)
	)
)

(instance starScriptOff of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(client loop: 1 cel: 0 setCycle: Fwd)
				(= cycles (* register 3))
			)
			(1
				(client loop: 0 cel: 6 setCycle: Beg)
			)
		)
	)
)

(instance leader of Prop
	(properties
		y 188
		x 160
		view 473
	)
)

(instance star of Prop
	(properties
		y 95
		x 107
		view 424
	)
)

(instance elsaChange of Sound
	(properties
		number 70
		priority 3
	)
)

