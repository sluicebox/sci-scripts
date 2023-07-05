;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 178)
(include sci.sh)
(use Main)
(use Interface)
(use Motion)
(use Game)
(use Actor)
(use System)

(public
	rm178 0
)

(local
	work
	aBarber
	aChair
	aThoughtBalloon
	aThought
	aHandle
)

(instance rm178 of Rm
	(properties
		picture 125
	)

	(method (init)
		(Load rsVIEW 196)
		(Load rsVIEW 711)
		(Load rsVIEW 712)
		(Load rsVIEW 713)
		(Load rsVIEW 232)
		(Load rsPIC 178)
		(super init:)
		((= aThoughtBalloon (Prop new:))
			view: 717
			setLoop: 3
			setCel: 0
			setPri: 14
			ignoreActors:
			posn: 160 1128
			setPri: 14
			init:
		)
		((= aHandle (View new:))
			view: 717
			setLoop: 3
			setCel: 1
			ignoreActors:
			posn: 160 1129
			setPri: 14
			init:
		)
		((= aThought (Prop new:))
			view: 717
			setLoop: 3
			setCel: 2
			ignoreActors:
			posn: 161 1120
			setPri: 15
			init:
		)
		((= aChair (Prop new:))
			view: 232
			loop: 1
			cel: 0
			posn: 164 118
			setPri: 8
			ignoreActors:
			stopUpd:
			init:
		)
		((= aBarber (Act new:))
			view: 711
			loop: 3
			setCycle: Walk
			illegalBits: 0
			posn: 151 161
			ignoreActors:
			init:
		)
		(gEgo posn: 171 161 illegalBits: 0 ignoreActors: init:)
		(self setRegions: 7 setScript: rm178Script) ; rm7
		(HandsOff)
	)
)

(instance rm178Script of Script
	(properties)

	(method (doit)
		(super doit:)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo setMotion: MoveTo 181 132)
				(aBarber setMotion: MoveTo 159 122 self)
			)
			(1
				(gEgo loop: 3)
				(Print 178 0 #at -1 152 #draw) ; "(Don't all witch doctor huts look alike?)"
				(= seconds 3)
			)
			(2
				(Print 178 1) ; "Just a moment, Larry, while I ready this special preparation!"
				(aBarber view: 713 setCycle: Fwd)
				(= cycles 50)
			)
			(3
				(aChair view: 712 setLoop: 0 setCycle: Fwd)
				(aBarber view: 712 posn: 157 1120)
				(= cycles 50)
			)
			(4
				(aChair setLoop: 1 cel: 0 setCycle: End self)
			)
			(5
				(aBarber
					view: 712
					setLoop: 2
					posn: 157 121
					cel: 0
					setCycle: End self
					show:
				)
			)
			(6
				((View new:)
					view: 712
					ignoreActors:
					posn: 162 111
					loop: 2
					cel: 2
					setPri: 8
					addToPic:
				)
				(aBarber
					setLoop: 3
					setStep: 3 3
					posn: 144 135
					setMotion: MoveTo 130 159 self
					forceUpd:
				)
			)
			(7
				(Print 178 2 #draw) ; "All right, son; come on over here."
				(= cycles 10)
			)
			(8
				(gEgo setMotion: MoveTo 157 122 self)
			)
			(9
				(gEgo setLoop: 2)
				(= cycles 10)
			)
			(10
				(aChair view: 232 loop: 1 cel: 0 posn: 164 118 show:)
				(gEgo
					view: 196
					posn: 157 120
					setLoop: 0
					cel: 0
					cycleSpeed: 1
					setCycle: End self
				)
			)
			(11
				(aChair stopUpd:)
				(gEgo setLoop: 1 setCycle: Fwd)
				(= cycles 20)
			)
			(12
				(gEgo setLoop: 0 setCel: 255 setCycle: Beg self)
			)
			(13
				(aBarber view: 711 setLoop: 2 posn: 159 121)
				(gEgo setLoop: 2 cel: 0 setCycle: End self)
			)
			(14
				(aBarber stopUpd:)
				(gEgo setLoop: 3 cel: 0 setCycle: Fwd)
				(= cycles 30)
			)
			(15
				(gEgo setLoop: 4 cel: 0 setCycle: End self)
			)
			(16
				(gEgo setLoop: 5 cel: 0 setCycle: End self)
			)
			(17
				(gEgo setLoop: 6 cel: 0 setCycle: Fwd)
				(= cycles 32)
			)
			(18
				(gEgo setLoop: 7 cycleSpeed: 1 cel: 0 setCycle: End self)
			)
			(19
				(gEgo setLoop: 8 setCycle: Fwd)
				(= cycles 30)
			)
			(20
				(gEgo setLoop: 7 setCel: 255 setCycle: Beg self)
			)
			(21
				(gEgo setLoop: 6 cycleSpeed: 0 cel: 0 setCycle: Fwd)
				(= cycles 30)
			)
			(22
				(gEgo setLoop: 5 setCel: 255 setCycle: Beg self)
			)
			(23
				(gEgo setLoop: 4 setCel: 255 setCycle: Beg self)
			)
			(24
				(gEgo setLoop: 3 cel: 0 setCycle: Fwd)
				(= cycles 30)
			)
			(25
				(gEgo setLoop: 2 setCel: 255 setCycle: Beg self)
			)
			(26
				(aBarber hide:)
				(gEgo setLoop: 9)
				(Print 178 3 #at -1 20 #draw) ; "Geez," you exclaim, "that's some powerful stuff!"
				(= seconds 3)
			)
			(27
				(Print 178 4) ; "Here," says the witch doctor, "take a look in this mirror and tell me what you think."
				(gEgo stopUpd:)
				(aThoughtBalloon posn: 160 127 stopUpd:)
				(aHandle posn: 160 128 stopUpd:)
				(aThought posn: 161 119)
				(= seconds 2)
			)
			(28
				(Print 178 5 #at -1 20) ; "YOU DID IT! YOU REALLY DID IT!!"
				(= seconds 5)
			)
			(29
				(aThoughtBalloon posn: 160 1128)
				(aHandle posn: 160 1229)
				(aThought posn: 161 1320)
				(= seconds 3)
			)
			(30
				(Print 178 6) ; "This is great! I look like a young man again; I'm stranded in paradise, broke but happy; and the most beautiful woman I've ever seen is madly in love with me!!"
				(Print 178 7) ; "My dreams have all come true!"
				(= seconds 3)
			)
			(31
				(aThoughtBalloon
					setLoop: 0
					cel: 0
					posn: 154 91
					cycleSpeed: 3
					setCycle: End self
				)
			)
			(32
				(aThoughtBalloon stopUpd:)
				(aThought
					posn: 115 47
					cycleSpeed: 3
					setLoop: 1
					cel: 0
					setCycle: End self
				)
			)
			(33
				(aThoughtBalloon posn: 154 1092)
				(aThought posn: 154 91 setLoop: 2 cel: 0 setCycle: End self)
			)
			(34
				(gCurRoom drawPic: 178 16)
				(aChair posn: 999 999)
				(gEgo posn: 999 999)
				(aThought forceUpd:)
				(gCurRoom newRoom: 86)
			)
		)
	)
)

