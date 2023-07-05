;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 102)
(include sci.sh)
(use Main)
(use DLetter)
(use Language)
(use LoadMany)
(use Motion)
(use Game)
(use User)
(use Actor)
(use System)

(public
	intro3 0
)

(local
	[local0 2]
)

(instance intro3 of Rm
	(properties
		picture 68
	)

	(method (init)
		(super init:)
		(Load rsSOUND 8)
		(User canInput: 0 controls: 0)
		(gEgo view: 2 moveSpeed: 2 posn: -9 162 init:)
		(owl posn: -20 -15 init:)
		(self setScript: sceneThreeScript setRegions: 763) ; cartoonRegion
	)
)

(instance sceneThreeScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(LoadMany rsVIEW 748 757)
				(Load rsSOUND 18)
				(gGlobalSound fade: 0 5 2 1)
				(= cycles 15)
			)
			(1
				(gEgo setMotion: MoveTo 44 162 self)
			)
			(2
				(gGlobalSound number: 8 loop: -1 playBed:)
				((gEgo head:) hide:)
				(gEgo
					view: 748
					normal: 0
					cel: 0
					cycleSpeed: 2
					setLoop: 0
					setCycle: End self
				)
			)
			(3
				(PrintDC 102 0 #at 100 100 #dispose) ; "Mein Schlo\e1! Was ist geschehen?"
				(= seconds (LangSwitch 4 6))
			)
			(4
				(cls)
				(owl setCycle: Fwd setMotion: MoveTo 22 95 self)
			)
			(5
				(owl setCycle: End self)
			)
			(6
				(owl
					view: 757
					setLoop: 0
					setCycle: End
					setMotion: MoveTo 25 100 self
				)
			)
			(7
				(if (< (gGlobalSound prevSignal:) 10)
					(-- state)
				)
				(= cycles 1)
			)
			(8
				(PrintDC 102 1 #at 10 10 #dispose) ; "Ich kann Dir sagen, was geschehen ist."
				(= seconds (LangSwitch 1 2))
			)
			(9
				(gEgo cel: 0 setLoop: 1 setCycle: End self)
			)
			(10
				(gEgo setLoop: 2 setCycle: End self)
			)
			(11
				(if (< (gGlobalSound prevSignal:) 20)
					(-- state)
				)
				(= cycles 1)
			)
			(12
				(cls)
				(= global380 1)
				(PrintDC 102 2 #at 100 100 #dispose) ; "Was?"
				(gCurRoom newRoom: 103) ; intro4
			)
		)
	)
)

(instance owl of Actor
	(properties
		view 760
		loop 2
		signal 2048
	)
)

