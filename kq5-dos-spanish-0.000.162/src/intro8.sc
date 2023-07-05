;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 107)
(include sci.sh)
(use Main)
(use DLetter)
(use Language)
(use Motion)
(use Game)
(use User)
(use Actor)
(use System)

(public
	intro8 0
)

(instance intro8 of Rm
	(properties
		picture 74
		style 10
	)

	(method (init)
		(User canInput: 0 controls: 0)
		(gEgo
			view: 750
			setLoop: 6
			normal: 0
			posn: 163 224
			cycleSpeed: 2
			setCycle: Fwd
			init:
		)
		((gEgo head:) hide:)
		(owl
			init:
			view: 760
			signal: 16384
			cycleSpeed: 2
			illegalBits: 0
			setLoop: 8
			setCycle: Fwd
			posn: 247 207
		)
		(self setScript: a2s2Script setRegions: 763) ; cartoonRegion
		(super init:)
	)

	(method (newRoom newRoomNumber)
		(gEgo setStep: -1 -1)
		(super newRoom: newRoomNumber)
	)

	(method (dispose)
		(super dispose:)
	)
)

(instance a2s2Script of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= cycles 15)
			)
			(1
				(owl setScript: owlFlying)
				(= seconds 3)
			)
			(2
				(gEgo setCycle: Fwd setMotion: MoveTo 143 85 self)
			)
			(3
				(= seconds 2)
			)
			(4
				(= global380 1)
				(PrintDC 107 0 #at 100 10 #dispose) ; "OK...\adAh\a1 voy!"
				(= cycles 1)
			)
			(5
				(gEgo setLoop: 7 moveSpeed: 0 setCycle: End self)
			)
			(6
				(gGlobalSound number: 60 loop: 1 playBed:)
				(gEgo setLoop: 8 setMotion: MoveTo 138 88 setCycle: End self)
			)
			(7
				(gGlobalSound fade:)
				(gCurRoom newRoom: 108) ; intro9
			)
		)
	)
)

(instance owlFlying of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(owl setMotion: MoveTo 254 150 self)
			)
			(1
				(owl setCycle: End self)
			)
			(2
				(owl setLoop: 9 setCycle: End self)
			)
			(3
				(PrintDC 107 1 #at 10 10 #dispose) ; "\adAqu\a1 est\a0! \adAbajo! \adVamos!"
				(owl
					setLoop: 10
					moveSpeed: 1
					setCycle: Fwd
					setMotion: MoveTo 254 90
				)
				(= seconds (LangSwitch 4 6))
			)
			(4
				(cls)
				(owl setCycle: End self)
			)
			(5
				(owl setLoop: 11 setCycle: End self)
			)
			(6
				(owl
					setLoop: 12
					moveSpeed: 0
					setMotion: MoveTo 133 90
					setCycle: End self
				)
			)
			(7
				(owl setLoop: 13 setCycle: End setMotion: MoveTo 133 90 self)
			)
			(8
				(owl dispose:)
			)
		)
	)
)

(instance owl of Actor
	(properties)
)

