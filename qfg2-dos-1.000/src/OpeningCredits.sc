;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 770)
(include sci.sh)
(use Main)
(use HandsOffScript)
(use LoadMany)
(use Motion)
(use Game)
(use Actor)
(use System)

(public
	OpeningCredits 0
)

(local
	cycledThru
	[Star 4]
	[StarXY 12] = [152 108 280 93 20 53 68 66 270 123 28 151]
)

(procedure (InitStars &tmp I)
	(for ((= I 0)) (<= I 2) ((++ I))
		((= [Star I] (Clone Prop))
			init:
			hide:
			view: 847
			setLoop: 0
			cel: 0
			setCycle: Fwd
		)
	)
)

(procedure (StarChart &tmp room I color newX newY)
	(if (not (or (== (gCurRoom curPic:) 663) (== (gCurRoom curPic:) 780)))
		(= room
			(switch (gCurRoom curPic:)
				(901 0)
				(900 5)
			)
		)
		(for ((= I 0)) (<= I 2) ((++ I))
			(= color
				(switch I
					(0 1)
					(1 3)
					(2 5)
				)
			)
			(= newX (+ I room (- color 1)))
			(= newY (+ I room color))
			([Star I]
				show:
				x: [StarXY newX]
				y: [StarXY newY]
				cycleSpeed: I
				palette: (+ I 1)
			)
		)
	else
		(for ((= I 0)) (<= I 2) ((++ I))
			([Star I] hide:)
		)
	)
)

(instance OpeningCredits of Rm
	(properties
		picture 663
	)

	(method (init)
		(LoadMany rsPIC 663 780 661)
		(LoadMany rsVIEW 758 775 780 847)
		(Load rsSOUND 775)
		(= gDebugging 0)
		(gKeyDownHandler add: self)
		(super init: &rest)
		(carpet init:)
		(Title init:)
		(Name init:)
		(extraName init: hide:)
		(InitStars)
		(self setScript: okForFlyBy)
	)

	(method (handleEvent event)
		(super handleEvent: event)
		(if (== (event type:) evMOUSEBUTTON)
			(return 1)
		)
		(if (and (== (event type:) evKEYBOARD) (== (event message:) KEY_RETURN))
			(gCurRoom newRoom: 765) ; notice2Room
			(event claimed: 1)
		else
			(event claimed: 1)
		)
	)

	(method (dispose)
		(gKeyDownHandler delete: self)
		(super dispose:)
	)
)

(instance carpet of Actor
	(properties
		x -25
		y 138
		view 758
		signal 2048
		xStep 6
	)
)

(instance Title of View
	(properties
		x 160
		y 25
		view 775
		priority 14
		signal 16401
	)
)

(instance Name of View
	(properties
		x 160
		y 40
		view 775
		cel 1
		priority 14
		signal 16401
	)
)

(instance extraName of View
	(properties
		x 160
		view 775
		cel 2
		priority 14
		signal 16401
	)
)

(instance city of PicView
	(properties
		x 145
		y 90
		view 780
		loop 2
		priority 0
	)
)

(instance saurusLot of PicView
	(properties
		x 123
		y 94
		view 780
		loop 3
		priority 1
	)
)

(instance Enterprise of Actor
	(properties
		x -71
		y 95
		view 775
		loop 7
		priority 10
		signal 26640
	)

	(method (init)
		(super init: &rest)
		(self setScript: warpSpeed)
	)
)

(instance warpSpeed of Script
	(properties)

	(method (doit)
		(super doit:)
		(if (and (not cycledThru) (>= (Enterprise x:) 55))
			(= cycledThru 1)
			(Enterprise setCycle: End)
			(gMiscSound number: 775 loop: 0 priority: 8 play:)
		)
		(if (and (== state 0) (< (carpet y:) 70))
			(self cue:)
		)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0 0)
			(1
				(Enterprise setStep: 18 5 setMotion: MoveTo 243 56 self)
			)
			(2
				(Enterprise setLoop: 8 cel: 0 setCycle: End self)
			)
			(3
				(Enterprise dispose:)
				(self dispose:)
			)
		)
	)
)

(instance displayCredit of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0 0)
			(1
				(StarChart)
				(extraName hide:)
				(Title
					y:
						(if
							(or
								(== (gCurRoom curPic:) 663)
								(== (gCurRoom curPic:) 780)
							)
							25
						else
							80
						)
					setLoop: (+ (Title loop:) 1)
					palette:
						(if
							(or
								(== (gCurRoom curPic:) 663)
								(== (gCurRoom curPic:) 780)
							)
							0
						else
							2
						)
					forceUpd:
				)
				(Name
					y:
						(if
							(or
								(== (gCurRoom curPic:) 663)
								(== (gCurRoom curPic:) 780)
							)
							37
						else
							92
						)
					setLoop: (Title loop:)
					palette:
						(if
							(or
								(== (gCurRoom curPic:) 663)
								(== (gCurRoom curPic:) 780)
							)
							0
						else
							2
						)
					forceUpd:
				)
				(= cycles 1)
			)
			(2
				(if (or (== (Title loop:) 3) (== (Title loop:) 6))
					(extraName
						y:
							(if
								(or
									(== (gCurRoom curPic:) 663)
									(== (gCurRoom curPic:) 780)
								)
								49
							else
								104
							)
						setLoop: (Title loop:)
						setCel: 2
						palette:
							(if
								(or
									(== (gCurRoom curPic:) 663)
									(== (gCurRoom curPic:) 780)
								)
								0
							else
								2
							)
						forceUpd:
						show:
					)
				)
				(= cycles 1)
			)
			(3
				(self changeState: 0)
			)
		)
	)
)

(instance okForFlyBy of HandsOffScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= cycles 1)
			)
			(1
				(SetCursor gTheCursor 0)
				(self setScript: displayCredit)
				(carpet setCycle: Fwd setMotion: MoveTo 96 138 self)
			)
			(2
				(carpet
					setLoop: 1
					cel: 0
					cycleSpeed: 2
					setCycle: CT 3 1 self
					setMotion: MoveTo 140 114
				)
			)
			(3
				(carpet
					setLoop: 12
					cel: 0
					setCycle: Fwd
					cycleSpeed: 0
					setMotion: MoveTo 171 63 self
				)
			)
			(4
				(carpet
					setLoop: 1
					posn: 171 55
					cel: 3
					cycleSpeed: 3
					setCycle: CT 5 1
					setMotion: MoveTo 170 43 self
				)
			)
			(5
				(carpet
					setLoop: 13
					posn: 169 51
					cel: 0
					cycleSpeed: 0
					setCycle: Fwd
					setMotion: MoveTo 134 7 self
				)
			)
			(6
				(gCurRoom drawPic: 901 43)
				(displayCredit cue:)
				(carpet posn: 134 190)
				(= cycles 2)
			)
			(7
				(carpet
					setLoop: 1
					cel: 5
					cycleSpeed: 3
					setPri: 15
					setCycle: CT 3 -1
					setMotion: MoveTo 133 179 self
				)
			)
			(8
				(carpet
					setLoop: 12
					setCel: -1
					cel: 0
					posn: 133 187
					cycleSpeed: 0
					setCycle: Fwd
					setMotion: MoveTo 181 76 self
				)
			)
			(9
				(carpet setLoop: 6 cel: 0 setPri: 13 setCycle: End self)
			)
			(10
				(carpet
					setLoop: 8
					setPri: 13
					setStep: 3 6
					setCycle: Fwd
					setMotion: MoveTo 205 190 self
				)
			)
			(11
				(gCurRoom drawPic: 663 42)
				(displayCredit cue:)
				(carpet posn: 205 5)
				(= cycles 2)
			)
			(12
				(carpet setLoop: 9 setPri: 15 setMotion: MoveTo 164 59 self)
			)
			(13
				(carpet
					setLoop: 10
					cel: 0
					setStep: 3 2
					setPri: 13
					setMotion: MoveTo 130 59
					setCycle: End self
				)
			)
			(14
				(carpet setLoop: 13 setCycle: Fwd setMotion: MoveTo 104 6 self)
			)
			(15
				(gCurRoom drawPic: 901 43)
				(displayCredit cue:)
				(carpet posn: 104 190)
				(= cycles 2)
			)
			(16
				(carpet setPri: 15 setMotion: MoveTo 81 153 self)
			)
			(17
				(carpet
					setLoop: 1
					cel: 5
					posn: 81 145
					cycleSpeed: 3
					setCycle: CT 3 -1
					setMotion: MoveTo 80 135 self
				)
			)
			(18
				(carpet
					posn: 80 144
					cycleSpeed: 0
					setLoop: 12
					cel: 0
					setMotion: MoveTo 99 117 self
					setCycle: Fwd
				)
			)
			(19
				(carpet
					posn: 99 117
					setLoop: 6
					cel: 0
					setCycle: End
					setMotion: MoveTo 117 115 self
				)
			)
			(20
				(carpet
					setLoop: 11
					cel: 0
					setCycle: CT 4 1
					setMotion: MoveTo 128 124 self
				)
			)
			(21
				(carpet setPri: 13 setCycle: End setMotion: MoveTo 135 117 self)
			)
			(22
				(carpet
					setLoop: 12
					posn: 134 116
					cel: 0
					setCycle: Fwd
					setMotion: MoveTo 163 57 self
				)
			)
			(23
				(carpet
					setLoop: 1
					posn: 163 49
					cel: 3
					cycleSpeed: 3
					setCycle: CT 5 1
					setMotion: MoveTo 162 34 self
				)
			)
			(24
				(carpet
					setLoop: 13
					cel: 0
					posn: 160 41
					setCycle: Fwd
					setMotion: MoveTo 140 7 self
				)
			)
			(25
				(gCurRoom drawPic: 900 43)
				(Enterprise init:)
				(displayCredit cue:)
				(carpet posn: 140 190)
				(= cycles 2)
			)
			(26
				(carpet setPri: 15 cel: 0 setMotion: MoveTo 114 145 self)
			)
			(27
				(carpet
					setLoop: 1
					cel: 5
					posn: 114 136
					cycleSpeed: 2
					setCycle: CT 3 -1
					setMotion: MoveTo 113 127 self
				)
			)
			(28
				(carpet
					cycleSpeed: 0
					setLoop: 12
					cel: 0
					posn: 113 136
					setCycle: Fwd
					setMotion: MoveTo 160 61 self
				)
			)
			(29
				(= cycles 4)
			)
			(30
				(carpet setStep: 3 4 setPri: 13 setMotion: MoveTo 160 72 self)
			)
			(31
				(carpet
					setLoop: 1
					cel: 3
					setCycle: Fwd
					setMotion: MoveTo 160 212 self
				)
			)
			(32
				(gCurRoom drawPic: 901 42)
				(carpet posn: 160 12)
				(displayCredit cue:)
				(= cycles 2)
			)
			(33
				(carpet setPri: 15 setStep: 3 5 setMotion: MoveTo 160 212 self)
			)
			(34
				(gCurRoom drawPic: 780 42)
				(displayCredit cue:)
				(carpet posn: 160 12)
				(InitAddToPics city saurusLot)
				(= cycles 1)
			)
			(35
				(carpet illegalBits: 0 setMotion: MoveTo 160 71 self)
			)
			(36
				(carpet setCycle: End self setMotion: MoveTo 160 100)
			)
			(37
				(carpet
					setLoop: 7
					cel: 3
					y: (+ (carpet y:) 9)
					setCycle: CT 6 1
					setMotion: MoveTo 150 108 self
				)
			)
			(38
				(carpet
					setLoop: 9
					cel: 0
					setPri: 2
					posn: 147 110
					setCycle: Fwd
					setMotion: MoveTo 129 153 self
				)
			)
			(39
				(carpet
					setLoop: 13
					cel: 0
					posn: 88 162
					setMotion: MoveTo 77 139 self
				)
			)
			(40
				(carpet
					setLoop: 2
					cel: 0
					posn: 75 131
					setCycle: End self
					setMotion: MoveTo 138 85 self
				)
			)
			(41 0)
			(42
				(gCurRoom drawPic: 2 6)
				(gCast eachElementDo: #hide)
				(= cycles 1)
			)
			(43
				(displayCredit dispose:)
				(carpet dispose:)
				(gCurRoom newRoom: 785) ; CarpetLand
			)
		)
	)
)

