;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 90)
(include sci.sh)
(use Main)
(use Sound)
(use Motion)
(use Game)
(use Menu)
(use Actor)
(use System)

(public
	rm90 0
)

(local
	aBall
	aName
	sparkleCount
	heardSong
)

(instance mThemeSong of Sound
	(properties
		number 101
		priority 20
	)
)

(instance rm90 of Rm
	(properties
		picture 90
		style 5
	)

	(method (init)
		(Load rsVIEW 800)
		(Load rsVIEW 193)
		(Load rsVIEW 815)
		(Load rsVIEW 801)
		(Load rsVIEW 809)
		(Load rsSOUND 101)
		(Load rsPIC 91)
		(SL disable:)
		(TheMenuBar hide:)
		(super init:)
		(mThemeSong play:)
		(gAddToPics add: aView1 doit:)
		(aGirl
			illegalBits: 0
			setPri: 13
			setCycle: Walk
			cycleSpeed: 1
			moveSpeed: 1
			init:
			stopUpd:
		)
		(gEgo
			view: 815
			ignoreActors:
			illegalBits: 0
			setPri: 15
			moveSpeed: 0
			cycleSpeed: 0
			posn: 123 1123
			init:
		)
		(self setScript: rm90Script)
		(HandsOff)
		(gGame setSpeed: 6)
	)
)

(instance rm90Script of Script
	(properties)

	(method (doit)
		(super doit:)
		(if (and (== -1 (mThemeSong prevSignal:)) (== state 40))
			(gCurRoom newRoom: 91)
		)
	)

	(method (handleEvent event)
		(if (not (event claimed:))
			(gGame restart:)
		)
	)

	(method (changeState newState &tmp bx by ex ey)
		(switch (= state newState)
			(0
				(= cycles 20)
			)
			(1
				(gAddToPics add: aView2 doit:)
				(= cycles 30)
			)
			(2
				(gAddToPics add: aView3 doit:)
				(= cycles 20)
				(gGame setSpeed: 3)
			)
			(3
				(switch (Random 0 16)
					(0
						(= bx 149)
						(= by 39)
					)
					(1
						(= bx 64)
						(= by 47)
					)
					(2
						(= bx 161)
						(= by 77)
					)
					(3
						(= bx 234)
						(= by 88)
					)
					(4
						(= bx 114)
						(= by 116)
					)
					(5
						(= bx 91)
						(= by 97)
					)
					(6
						(= bx 179)
						(= by 29)
					)
					(7
						(= bx 61)
						(= by 97)
					)
					(8
						(= bx 255)
						(= by 64)
					)
					(9
						(= bx 130)
						(= by 86)
					)
					(10
						(= bx 143)
						(= by 80)
					)
					(11
						(= bx 212)
						(= by 85)
					)
					(12
						(= bx 48)
						(= by 107)
					)
					(13
						(= bx 205)
						(= by 125)
					)
					(14
						(= bx 275)
						(= by 121)
					)
					(15
						(= bx 92)
						(= by 129)
					)
					(16
						(= bx 182)
						(= by 132)
					)
				)
				(gEgo posn: bx by cel: 0 setCycle: End self)
				(if (< (++ sparkleCount) 10)
					(= state 2)
				)
			)
			(4
				(gEgo hide:)
				(gGame setSpeed: 6)
				(aGirl setMotion: MoveTo 109 100 self)
			)
			(5
				(aGirl setMotion: MoveTo 175 100 self)
				(gEgo
					view: 193
					loop: 0
					cel: 0
					posn: 86 79
					setPri: 15
					show:
					setCycle: End self
				)
			)
			(6
				(gEgo setCycle: Beg self)
			)
			(7
				(gEgo hide:)
			)
			(8
				(aGirl setMotion: MoveTo 220 100 self)
				(gEgo loop: 1 cel: 0 posn: 148 106 show: setCycle: End self)
			)
			(9
				(gEgo setCycle: Beg self)
			)
			(10
				(gEgo hide:)
			)
			(11
				(aGirl setMotion: MoveTo 268 100 self)
				(gEgo loop: 2 cel: 0 posn: 199 57 show: setCycle: End self)
			)
			(12
				(gEgo setCel: setStep: 1 15 setMotion: MoveTo 199 234)
			)
			(13
				(gEgo hide:)
				(aGirl hide:)
				(= aBall gEgo)
				(= aName aGirl)
				(gCurRoom drawPic: 91 4)
				(= cycles 10)
			)
			(14
				(gGame setSpeed: 3)
				(= bx (- (Random 0 420) 50))
				(aBall
					view: 801
					setLoop: 0
					setCycle: 0
					setCel: (Random 0 8)
					posn: bx 233
					setStep: 15 15
					illegalBits: 0
					ignoreActors:
					show:
					setMotion: MoveTo 159 47 self
				)
			)
			(15
				(= bx (- (Random 0 420) 50))
				(= ex (Random 50 270))
				(= ey (Random 70 180))
				(aBall
					setCel: (Random 0 8)
					posn: bx -33
					setMotion: MoveTo ex ey self
				)
				(aName
					view: 801
					setLoop: 1
					setCycle: 0
					setCel: 0
					setPri: 1
					setMotion: 0
					ignoreActors:
					illegalBits: 0
					posn: 159 46
					show:
				)
			)
			(16
				(aBall setLoop: 1 setCel: 1)
				(= cycles 35)
			)
			(17
				(= bx (- (Random 0 420) 50))
				(= ex (Random 50 270))
				(= ey (Random 70 180))
				(aBall
					setLoop: 0
					setCel: (Random 0 8)
					posn: bx -33
					setMotion: MoveTo ex ey self
				)
			)
			(18
				(aBall setLoop: 1 setCel: 2)
				(= cycles 35)
			)
			(19
				(= bx (- (Random 0 420) 50))
				(= ex (Random 50 270))
				(= ey (Random 70 180))
				(aBall
					setLoop: 0
					setCel: (Random 0 8)
					posn: bx -33
					setMotion: MoveTo ex ey self
				)
			)
			(20
				(aBall setLoop: 1 setCel: 3)
				(= cycles 35)
			)
			(21
				(aName hide:)
				(= bx (- (Random 0 420) 50))
				(aBall
					setLoop: 0
					setCel: (Random 0 8)
					posn: bx 233
					setMotion: MoveTo 159 47 self
				)
			)
			(22
				(= bx (- (Random 0 420) 50))
				(= ex (Random 50 270))
				(= ey (Random 70 180))
				(aBall
					setCel: (Random 0 8)
					posn: bx -33
					setMotion: MoveTo ex ey self
				)
				(aName setLoop: 4 setCel: 0 posn: 159 46 show:)
			)
			(23
				(aBall setLoop: 4 setCel: 1)
				(= cycles 35)
			)
			(24
				(= bx (- (Random 0 420) 50))
				(= ex (Random 50 270))
				(= ey (Random 70 180))
				(aBall
					setLoop: 0
					setCel: (Random 0 8)
					posn: bx -33
					setMotion: MoveTo ex ey self
				)
			)
			(25
				(aBall setLoop: 4 setCel: 2)
				(= cycles 35)
			)
			(26
				(= bx (- (Random 0 420) 50))
				(= ex (Random 50 270))
				(= ey (Random 70 180))
				(aBall
					setLoop: 0
					setCel: (Random 0 8)
					posn: bx -33
					setMotion: MoveTo ex ey self
				)
			)
			(27
				(aBall setLoop: 4 setCel: 3)
				(= cycles 35)
			)
			(28
				(= bx (- (Random 0 420) 50))
				(= ex (Random 50 270))
				(= ey (Random 70 180))
				(aBall
					setLoop: 0
					setCel: (Random 0 8)
					posn: bx -33
					setMotion: MoveTo ex ey self
				)
			)
			(29
				(aBall setLoop: 4 setCel: 4)
				(= cycles 35)
			)
			(30
				(aName hide:)
				(= bx (- (Random 0 420) 50))
				(aBall
					setLoop: 0
					setCel: (Random 0 8)
					posn: bx 233
					setMotion: MoveTo 159 47 self
				)
			)
			(31
				(= bx (- (Random 0 420) 50))
				(= ex (Random 50 270))
				(= ey (Random 70 180))
				(aBall
					setCel: (Random 0 8)
					posn: bx -33
					setMotion: MoveTo ex ey self
				)
				(aName setLoop: 5 setCel: 0 posn: 159 46 show:)
			)
			(32
				(aBall setLoop: 5 setCel: 1)
				(= cycles 35)
			)
			(33
				(= bx (- (Random 0 420) 50))
				(= ex (Random 50 270))
				(= ey (Random 70 180))
				(aBall
					setLoop: 0
					setCel: (Random 0 8)
					posn: bx -33
					setMotion: MoveTo ex ey self
				)
			)
			(34
				(aBall setLoop: 5 setCel: 2)
				(= cycles 35)
			)
			(35
				(= bx (- (Random 0 420) 50))
				(= ex (Random 50 270))
				(= ey (Random 70 180))
				(aBall
					setLoop: 0
					setCel: (Random 0 8)
					posn: bx -33
					setMotion: MoveTo ex ey self
				)
			)
			(36
				(aBall setLoop: 5 setCel: 3)
				(= cycles 35)
			)
			(37
				(aName hide:)
				(= bx (- (Random 0 420) 50))
				(aBall
					setLoop: 0
					setCel: (Random 0 8)
					posn: bx 233
					setMotion: MoveTo 159 47 self
				)
			)
			(38
				(= bx (- (Random 0 420) 50))
				(= ex (Random 50 270))
				(= ey (Random 70 180))
				(aBall
					setLoop: 0
					cel: (Random 0 8)
					posn: bx -33
					setMotion: MoveTo ex ey self
				)
				(aName setLoop: 2 cel: 0 show:)
			)
			(39
				(gGame setSpeed: 6)
				(aBall setLoop: 3 setCel: 0)
				(aName cycleSpeed: 2 setCycle: Fwd)
				(= cycles 72)
			)
			(40
				; COMPILER BUG: GAME WILL CRASH
			)
		)
	)
)

(instance aView1 of PV
	(properties
		y 47
		x 159
		view 800
		priority 8
		signal 16384
	)
)

(instance aGirl of Act
	(properties
		y 99
		x 22
		view 809
		signal 16384
	)
)

(instance aView2 of PV
	(properties
		y 98
		x 159
		view 800
		loop 1
		priority 10
		signal 16384
	)
)

(instance aView3 of PV
	(properties
		y 134
		x 162
		view 800
		loop 2
		priority 12
		signal 16384
	)
)

