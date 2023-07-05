;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 192)
(include sci.sh)
(use Main)
(use Motion)
(use System)

(public
	jackJumps 0
)

(instance jackJumps of Script
	(properties)

	(method (dispose)
		(super dispose:)
		(DisposeScript 192)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= cycles 15)
			)
			(1
				((ScriptID 94 14) init: setPri: 13) ; jack1
				((ScriptID 94 0) notify: 1) ; rm94
				(= cycles 5)
			)
			(2
				((ScriptID 94 14) dispose:) ; jack1
				((ScriptID 94 15) init: show: setPri: 13 setCycle: CT 1 1 self) ; jackCycle
				((ScriptID 94 16) number: (SoundFX 81) init: loop: 1 play:) ; jackSound
				(if ((ScriptID 94 0) notify: 0) ; rm94
					((ScriptID 94 1) setScript: (ScriptID 94 5)) ; archer1, archer1Start
					((ScriptID 94 2) setScript: (ScriptID 94 6)) ; archer2, archer2Start
					((ScriptID 94 3) setScript: (ScriptID 94 7)) ; archer3, archer3Start
					((ScriptID 94 4) setScript: (ScriptID 94 8)) ; archer4, archer4Start
				)
			)
			(3
				((ScriptID 94 15) setCel: 2 setCycle: End self) ; jackCycle
				((ScriptID 94 16) play:) ; jackSound
			)
			(4
				((ScriptID 94 15) cycleSpeed: 1 setCycle: CT 1 1 self) ; jackCycle
				((ScriptID 94 16) play:) ; jackSound
			)
			(5
				((ScriptID 94 15) setCycle: End self) ; jackCycle
				((ScriptID 94 16) play:) ; jackSound
			)
			(6
				((ScriptID 94 15) cycleSpeed: 2 setCycle: CT 1 1 self) ; jackCycle
				((ScriptID 94 16) play:) ; jackSound
			)
			(7
				((ScriptID 94 15) setCycle: End self) ; jackCycle
				((ScriptID 94 16) play:) ; jackSound
			)
			(8
				((ScriptID 94 15) cycleSpeed: 3 setCycle: CT 1 1 self) ; jackCycle
				((ScriptID 94 16) play:) ; jackSound
			)
			(9
				((ScriptID 94 15) setCycle: End self) ; jackCycle
				((ScriptID 94 16) play:) ; jackSound
			)
			(10
				((ScriptID 94 15) cycleSpeed: 4 setCycle: CT 1 1 self) ; jackCycle
				((ScriptID 94 16) play:) ; jackSound
			)
			(11
				((ScriptID 94 15) setCycle: End self) ; jackCycle
				((ScriptID 94 16) play:) ; jackSound
			)
			(12
				((ScriptID 94 15) cycleSpeed: 5 setCycle: CT 1 1 self) ; jackCycle
				((ScriptID 94 16) play:) ; jackSound
			)
			(13
				((ScriptID 94 15) setCycle: End self) ; jackCycle
				((ScriptID 94 16) play:) ; jackSound
			)
			(14
				((ScriptID 94 15) cycleSpeed: 6 setCycle: End self) ; jackCycle
				((ScriptID 94 16) play:) ; jackSound
			)
			(15
				((ScriptID 94 16) dispose:) ; jackSound
				(self dispose:)
			)
		)
	)
)

