;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 323)
(include sci.sh)
(use Main)
(use Sync)
(use Avoid)
(use Motion)
(use System)

(public
	rhymeScript 0
)

(local
	local0
)

(instance rhymeScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(if (global109 script:)
					(-- state)
				)
				(= cycles 1)
			)
			(1
				(= global133 watch)
				(proc0_9)
				(Load rsCURSOR 69)
				(Load rsSCRIPT 979)
				(Load rsSCRIPT 985)
				(gLongSong stop:)
				(rhymeSync init: 0)
				(= global164 1)
				(= cycles 1)
			)
			(2
				(if (< (rhymeSync prevSignal:) 10)
					(-- state)
					(= cycles 1)
				else
					(proc0_16 (Format @global300 323 0)) ; "Little Bo Peep has lost her sheep"
					(++ global164)
					(= seconds 3)
				)
			)
			(3
				(= cycles 1)
				(++ global164)
			)
			(4
				(if (< (rhymeSync prevSignal:) 20)
					(-- state)
					(= cycles 1)
				else
					(proc0_16 (Format @global300 323 1)) ; "And doesn't know where to find them;"
					(++ global164)
					(global109
						setCel: (if (== (global109 cel:) 4) 3 else 1)
						setCycle: 0
					)
					(= seconds 2)
				)
			)
			(5
				(if (== (global129 loop:) 2)
					(global109 setCel: 1)
				else
					(global109 setCel: 3)
				)
				(= seconds 2)
			)
			(6
				(global109 setCel: (if (== (global109 cel:) 1) 0 else 4))
				(= cycles 1)
			)
			(7
				(if (< (rhymeSync prevSignal:) 30)
					(-- state)
				else
					(proc0_16 (Format @global300 323 2)) ; "Leave them alone and they'll come home,"
					(self setScript: finish)
				)
				(= cycles 1)
			)
			(8
				(if (< (rhymeSync prevSignal:) 40)
					(-- state)
				else
					(proc0_16 (Format @global300 323 3)) ; "Wagging their tails behind them."
				)
				(= cycles 1)
			)
			(9
				(if (rhymeSync playing:)
					(-- state)
				else
					(proc0_16 0)
				)
				(= cycles 1)
			)
			(10
				(if script
					(-- state)
				else
					(= global129 0)
					(proc0_10)
				)
				(= cycles 1)
			)
			(11
				(gEgo setMotion: 0 setAvoider: 0 setLoop: -1)
				(gLongSong number: 1 loop: -1 play:)
				(if (!= gScore gPossibleScore)
					(proc0_3)
				)
				(self dispose:)
				(= local0 1)
			)
		)
		(if local0
			(DisposeScript 323)
		)
	)
)

(instance rhymeSync of ScriptSync
	(properties)
)

(instance watch of Script
	(properties)

	(method (cue)
		(gEgo setAvoider: 0)
		(proc0_7 gEgo global109)
	)
)

(instance finish of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(global129
					setAvoider: ((Avoid new:) offScreenOK: 1)
					setMotion: MoveTo 172 117 self
				)
			)
			(1
				(global129
					setLoop: 8
					setCel: 0
					illegalBits: 0
					ignoreActors: 1
					setCycle: 0
					setMotion: MoveTo 164 110 self
				)
			)
			(2
				(global129 setCel: 1 setMotion: MoveTo 146 107 self)
			)
			(3
				(global129 setCel: 2 setMotion: MoveTo 137 108 self)
			)
			(4
				(global129 setCel: -1 setAvoider: 0 setCycle: End self)
			)
			(5
				(global129 setLoop: 7 setPri: 11)
				(global110 hide:)
				(global109 cel: 0 setCel: -1 setLoop: 5 setCycle: End self)
				(++ global164)
			)
			(6
				(global109 setLoop: 6 setCycle: Fwd)
				(= cycles 9)
			)
			(7
				(global109 setCycle: End self)
			)
			(8
				(global109 setCycle: Beg self)
			)
			(9
				(global109 setLoop: 5 setCel: 255 setCycle: Beg self)
			)
			(10
				(global109 setLoop: 4 setCel: 0)
				(global110 show:)
				(self dispose:)
			)
		)
	)
)

