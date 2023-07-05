;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 188)
(include sci.sh)
(use Main)
(use n128)
(use Interface)
(use Save)
(use Motion)
(use Actor)
(use System)

(public
	aphrodite 0
	apparition 1
)

(procedure (localproc_0)
	(aphroWindow brTop: 200 brBottom: 70 brLeft: 60 brRight: 240)
	(gTObj
		actor: aphroHead
		noWidth: 1
		tWindow: aphroWindow
		tLoop: 4
		cSpeed: 0
	)
	(gTObj talkCue: self)
	(Talk &rest)
)

(instance aphroBody of Prop
	(properties
		y 42
		x 84
		view 178
		loop 1
	)
)

(instance aphroHead of Prop
	(properties
		y 23
		x 81
		view 178
	)
)

(instance aphroShadow of Prop
	(properties
		y 76
		x 84
		view 178
		loop 3
	)
)

(instance bolt of Prop
	(properties
		y 39
		x 102
		view 178
		loop 7
	)
)

(instance aphrodite of Prop
	(properties
		y 76
		x 84
		view 178
	)

	(method (delete)
		(super delete:)
		(DisposeScript 188)
	)
)

(instance aphroWindow of SysWindow
	(properties
		color 14
		back 8
		title {Aphrodite}
		brTop 100
		brLeft 110
		brBottom 140
		brRight 240
	)
)

(instance apparition of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gRmMusic number: 117 loop: -1 play:)
				(= global109 6)
				(gEgo setMotion: MoveTo 130 80 self)
				(aphrodite init: cycleSpeed: 1 setCycle: End self)
				(if (not (IsFlag 211))
					((ScriptID 177 2) setPri: 5) ; theDove
				)
			)
			(1
				(aphrodite loop: 2 cycleSpeed: 0 setCycle: Fwd)
				(aphroBody init: setPri: (+ (aphrodite priority:) 1))
				(aphroShadow
					init:
					view: 178
					loop: 3
					cel: 0
					posn: 84 76
					setCycle: Fwd
				)
				(if (not (IsFlag 211))
					((ScriptID 177 3) dispose:) ; doveShadow
					((ScriptID 177 2) view: 178 loop: 5 cel: 0 setCycle: 0) ; theDove
				)
				(= cycles 2)
			)
			(2
				(if (not (IsFlag 211))
					((ScriptID 177 2) loop: 6) ; theDove
				)
				(= cycles 2)
			)
			(3
				(gEgo setMotion: MoveTo 130 80 self)
			)
			(4
				(gEgo setLoop: 1)
				(if global124
					(= global125 0)
					(= global124 0)
					(gEgo view: 4 cel: 5 setCycle: Beg)
				)
				(if (IsFlag 211)
					(self dispose:)
					(aphrodite setScript: zapEgo)
				else
					(= cycles 15)
				)
			)
			(5
				(aphroHead init: setPri: (+ (aphrodite priority:) 1))
				(localproc_0 188 0 188 1 188 2 188 3) ; "Where you stand, once my priestesses stood. My name was spoken with reverence. My statue and holy of holies were housed within, where only that bare pedestal remains."
			)
			(6
				(localproc_0 188 4 188 5) ; "But beware, the power of the Grail itself will pass final judgment upon your worthiness to possess it."
			)
			(7
				(aphroHead dispose:)
				(aphroShadow dispose:)
				(aphroBody dispose:)
				((ScriptID 177 2) cycleSpeed: 1 setCycle: End) ; theDove
				(aphrodite loop: 0 cel: 3 cycleSpeed: 1 setCycle: Beg self)
			)
			(8
				((ScriptID 177 2) dispose:) ; theDove
				(ClearFlag 203)
				(SetFlag 208)
				(gEgo setLoop: -1)
				(aphrodite dispose:)
				(= global109 0)
				(gRmMusic stop:)
				(gRegMusic number: 110 loop: -1 play:)
				(HandsOn)
			)
		)
	)
)

(instance zapEgo of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= cycles 15)
			)
			(1
				(aphroHead init: setPri: (+ (aphrodite priority:) 1))
				(localproc_0 188 6) ; "I HATE to be ignored! And by a mortal! It is too great an insult to bear!"
			)
			(2
				(aphroBody setCycle: End self)
			)
			(3
				(bolt init: setCycle: End self)
			)
			(4
				(gEgo view: 96 setCycle: End)
				(bolt setCycle: Beg self)
			)
			(5
				(bolt dispose:)
				(aphroBody setCycle: Beg self)
			)
			(6
				(aphroHead dispose:)
				(aphroBody dispose:)
				(aphroShadow dispose:)
				(aphrodite loop: 0 cel: 5 cycleSpeed: 1 setCycle: Beg self)
			)
			(7
				(aphrodite posn: 500 500)
				(= cycles 2)
			)
			(8
				(Print 188 7 #at 75 100) ; "Hell hath no fury like a Goddess peeved."
				(EgoDead)
			)
		)
	)
)

