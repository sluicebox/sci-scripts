;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 113)
(include sci.sh)
(use Main)
(use Talker)
(use ROsc)
(use Timer)
(use Actor)
(use System)

(local
	local0
)

(class MGNarrator of Narrator
	(properties)

	(method (say param1 param2)
		(dummy init:)
		(if (not initialized)
			(self init:)
		)
		(= caller (if (and (> argc 1) param2) param2 else 0))
		(if (& gMsgType $0001)
			(self startText: param1)
		)
		(if (& gMsgType $0002)
			(self startAudio: param1)
		)
		(= local0 0)
		(mgTimer init: self setTicks: timeScript ticks)
		(return 1)
	)

	(method (doit)
		(if (and local0 (or (!= modeless 0) (& gMsgType $0002)))
			(dummy dispose:)
			(self dispose: disposeWhenDone)
			(return 0)
		)
		(return 1)
	)

	(method (doEgoTalk)
		(gTalkEgo init: gEgo)
		(gTalkEgo show:)
		(gTalkEgo setMyView: setMyLoop: cel: 0 setCycle: ROsc 10000 0)
		(gEgo hide:)
	)

	(method (doEgoQuiet)
		(gTalkEgo setMyView: setMyLoop: cel: 0 setCycle: 0)
		(gTalkEgo dispose:)
		(gEgo show:)
	)
)

(instance timeScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0)
			(1
				(= local0 1)
				(mgTimer dispose:)
				(self dispose:)
			)
		)
	)
)

(instance mgTimer of Timer
	(properties)
)

(instance dummy of Prop
	(properties)

	(method (init)
		(self setScript: timeScript)
	)
)

