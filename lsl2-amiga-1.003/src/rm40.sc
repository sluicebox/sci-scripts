;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 40)
(include sci.sh)
(use Main)
(use Interface)
(use Rev)
(use Extra)
(use Sound)
(use Motion)
(use Game)
(use User)
(use Actor)
(use System)

(public
	rm40 0
)

(local
	work
	earlyOut
	lclEgoView
	flowerHere
)

(instance theSound of Sound
	(properties
		number 8
		priority -33
		loop -1
	)
)

(instance rm40 of Rm
	(properties
		picture 40
		horizon 5
	)

	(method (init)
		(cond
			((== gCurrentEgoView 149)
				(= lclEgoView 146)
			)
			((== gCurrentEgoView 150)
				(= lclEgoView 147)
			)
			((== gCurrentEgoView 151)
				(= lclEgoView 157)
			)
			(else
				(= lclEgoView 145)
			)
		)
		(Load rsVIEW lclEgoView)
		(Load rsVIEW 415)
		(Load rsVIEW 700)
		(Load rsVIEW 414)
		(Load rsVIEW 412)
		(Load rsSOUND 113)
		(Load rsSOUND 106)
		(Load rsSOUND 8)
		(super init:)
		(theSound play:)
		(++ gTimesInRm40)
		(if gForceAtest
			(= gTimesInRm40 257)
		)
		(= flowerHere ((gInventory at: 20) ownedBy: gCurRoomNum)) ; Flower
		(aFlower setLoop: 1 stopUpd: setCel: flowerHere init:)
		(aPottedPlant setStep: 1 1 setPri: 12 init:)
		(aBird1 setLoop: 0 setPri: 15 init:)
		(aBird2 setLoop: 1 setPri: 15 init:)
		(if (== lclEgoView 145)
			(aHench illegalBits: 0 setCycle: Walk init:)
		)
		(NormalEgo 0)
		(gEgo ignoreActors: illegalBits: 0 posn: 44 188 init:)
		(User canControl: 0)
		(= gCurrentStatus 5)
		(self setRegions: 400 setScript: rm40Script) ; rm400
	)

	(method (dispose)
		(DisposeScript 969)
		(super dispose:)
	)
)

(instance rm40Script of Script
	(properties)

	(method (doit)
		(super doit:)
	)

	(method (handleEvent event)
		(if (or (!= (event type:) evSAID) (event claimed:))
			(return)
		)
		(if (Said 'look>')
			(if (Said '/carpet')
				(Print 40 0) ; "The grounds of the resort are covered with elaborate, hand-carved and inlaid patterns, none of which show up on that cheap graphics board and monitor you're using!"
			)
			(if (and flowerHere (Said '/flower'))
				(Print 40 1) ; "There is one beautiful flower growing directly under that parrot sitting in the palm tree."
			)
			(if (Said '<below/bush')
				(Print 40 2) ; "You discover Jim Walls testing "Police Quest II!" Jim! You were supposed to be on vacation!"
			)
			(if (Said '/feather')
				(Print 40 3) ; "The peacock is beautiful, but of no use to you."
			)
			(if (Said '/bird')
				(Print 40 4) ; "You hesitate to look up, but grab a quick peek. They are beautiful birds, but unfortunately they cannot tell you how to escape this place!"
			)
			(if (Said '/agent')
				(if (and (>= state 50) (<= state 57))
					(Print 40 5) ; "LAND SHARK!!"
				else
					(Print 40 6) ; "Where?"
				)
			)
			(if (Said '[/airport,palm]')
				(Print 40 7) ; "This resort has lovely landscaping, but it's so dense that you cannot find anything. You wander about aimlessly, searching for a break in the vegetation to return you to civilization!"
			)
		)
		(if (and (>= state 50) (<= state 57) (Said 'talk/man'))
			(Print 40 8) ; "He's not interested in talk."
		)
		(if (Said 'climb/palm')
			(Print 40 9) ; "Sit back; relax; enjoy."
		)
		(if (Said 'get/coconuts')
			(Print 40 10) ; "You have all the nuts you need for this game."
		)
		(if (Said 'get/feather,agent,feather,bird')
			(Print 40 11) ; "That won't help you."
		)
		(if
			(or
				(Said 'get<off')
				(Said 'stop,disembark,disembark')
				(Said 'explore/disembark')
			)
			(if (> gTimesInRm40 1)
				(Print 40 12) ; "Ok. Let's see if we can find a shortcut!"
				(= earlyOut 1)
			else
				(Print 40 13) ; "Sorry; maybe next time!"
			)
		)
		(if (Said 'get,cut,get/flower')
			(cond
				((!= gCurrentStatus 5)
					(NotNow) ; "Not now!"
				)
				((not flowerHere)
					(AlreadyTook) ; "You already took it."
				)
				((not (gEgo inRect: 128 150 160 167))
					(NotClose) ; "You're not close enough."
				)
				(else
					(gEgo get: 20) ; Flower
					(= flowerHere 0)
					(gGame changeScore: 3)
					(aFlower setCel: flowerHere stopUpd:)
					(Print 40 14 #at -1 20 #draw) ; "You reach over and break off the beautiful flower at its base. "Aw," you rationalize, "they'll never miss just one flower!""
				)
			)
		)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo posn: 16 170 setMotion: MoveTo 91 171 self)
			)
			(1
				(if (== gTimesInRm40 257)
					(= state 62)
				)
				(= cycles 15)
			)
			(2
				(gEgo setLoop: 3)
				(= cycles 15)
			)
			(3
				(gEgo setLoop: 2)
				(= cycles 15)
			)
			(4
				(gEgo setLoop: 0)
				(= cycles 15)
			)
			(5
				(gEgo setLoop: -1 setMotion: MoveTo 19 175 self)
			)
			(6
				(= cycles 30)
				(if earlyOut
					(= state 62)
				)
			)
			(7
				(gEgo posn: 249 159 setMotion: MoveTo 157 160 self)
			)
			(8
				(= cycles 15)
			)
			(9
				(gEgo setLoop: 3)
				(= cycles 15)
			)
			(10
				(gEgo setLoop: 2)
				(= cycles 15)
			)
			(11
				(gEgo setLoop: 0)
				(= cycles 15)
			)
			(12
				(gEgo setLoop: -1 setMotion: MoveTo 324 160 self)
			)
			(13
				(= cycles 30)
				(if (or earlyOut (> gTimesInRm40 8))
					(= state 62)
				)
			)
			(14
				(gEgo
					view: lclEgoView
					setLoop: -1
					setPri: -1
					setStep: 2 1
					posn: 228 135
					setMotion: MoveTo 180 136 self
				)
			)
			(15
				(= cycles 15)
			)
			(16
				(gEgo setLoop: 3)
				(= cycles 15)
			)
			(17
				(gEgo setLoop: 2)
				(= cycles 15)
			)
			(18
				(gEgo setLoop: 0)
				(= cycles 15)
			)
			(19
				(gEgo setLoop: -1 setMotion: MoveTo 318 136 self)
			)
			(20
				(= cycles 30)
			)
			(21
				(gEgo posn: 119 142 setMotion: MoveTo 2 143 self)
			)
			(22
				(= cycles 30)
				(if (or (!= lclEgoView 145) earlyOut (> gTimesInRm40 7))
					(= state 62)
				)
			)
			(23
				(gEgo
					setLoop: 4
					setPri: 12
					posn: 117 25
					setCel: 255
					setCycle: Rev
					setMotion: MoveTo 117 63 self
				)
			)
			(24
				(gEgo setCycle: Walk)
				(= cycles 30)
			)
			(25
				(gEgo setCycle: Fwd setMotion: MoveTo 117 26 self)
			)
			(26
				(= cycles 50)
				(if (or earlyOut (> gTimesInRm40 6))
					(= state 62)
				)
			)
			(27
				(gEgo
					setLoop: 7
					cel: 0
					posn: 243 140
					setPri: 15
					setCycle: End self
				)
			)
			(28
				(= cycles 30)
			)
			(29
				(gEgo setCycle: Beg self)
			)
			(30
				(gEgo hide:)
				(= cycles 30)
				(if (or earlyOut (> gTimesInRm40 5))
					(= state 62)
				)
			)
			(31
				(aPottedPlant setMotion: MoveTo 103 151)
				(gEgo
					setLoop: 5
					cel: 0
					posn: 102 163
					setPri: 14
					show:
					cycleSpeed: 0
					setCycle: End self
				)
			)
			(32
				(= cycles 30)
			)
			(33
				(gEgo setCycle: CT 5 1 self)
			)
			(34
				(aPottedPlant setMotion: MoveTo 103 161)
				(gEgo setCycle: Beg self)
			)
			(35
				(gEgo hide:)
				(= cycles 30)
				(if (or earlyOut (> gTimesInRm40 4))
					(= state 62)
				)
			)
			(36
				(gEgo
					setLoop: 6
					cel: 0
					posn: 218 88
					setPri: 10
					show:
					setCycle: CT 5 1 self
				)
			)
			(37
				(= cycles 7)
			)
			(38
				(gEgo setCycle: End self)
			)
			(39
				(gEgo setCel: setStep: 1 6 setMotion: MoveTo 218 143 self)
			)
			(40
				(= cycles 30)
				(if (or earlyOut (> gTimesInRm40 3))
					(= state 62)
				)
			)
			(41
				(aHench
					view: 412
					setLoop: 1
					setStep: 1 1
					posn: 177 135
					setCycle: Walk
					setMotion: MoveTo 162 138 self
				)
			)
			(42
				(aHench setMotion: MoveTo 162 155 self)
			)
			(43
				(aHench setLoop: 0 cel: 0 setCycle: End self)
			)
			(44
				(= cycles 30)
			)
			(45
				(gEgo
					loop: 2
					setLoop: -1
					setPri: -1
					setCycle: Walk
					setStep: 2 1
					posn: 163 151
				)
				(aHench setCycle: Beg self)
			)
			(46
				(aHench
					setLoop: 1
					setCycle: Walk
					setMotion: MoveTo 162 196 self
				)
			)
			(47
				(gEgo setMotion: MoveTo 163 147 self)
			)
			(48
				(gEgo setMotion: MoveTo 0 147 self)
				(aHench hide:)
			)
			(49
				(= cycles 30)
				(if (or earlyOut (> gTimesInRm40 2))
					(= state 62)
				)
			)
			(50
				(gEgo
					view: lclEgoView
					setLoop: -1
					setPri: -1
					posn: 321 146
					setCycle: Walk
					setMotion: MoveTo 214 147 self
				)
			)
			(51
				(gEgo setLoop: 0 setMotion: MoveTo 170 147 self)
			)
			(52
				(aHench
					view: 414
					setLoop: -1
					setPri: -1
					setCycle: Walk
					setStep: 2 1
					posn: 249 152
					setMotion: MoveTo 214 153 self
					show:
				)
				(theSound dispose:)
				(theSound number: 113 loop: 1 play:)
			)
			(53
				(gEgo setLoop: -1 setMotion: MoveTo 117 147 self)
			)
			(54
				(aHench setMotion: MoveTo 170 153 self)
			)
			(55
				(aHench loop: 0)
				(theSound dispose:)
				(theSound number: 106 loop: 1 play:)
				(= cycles 15)
			)
			(56
				(aHench loop: 1)
				(= cycles 15)
			)
			(57
				(aHench setMotion: MoveTo 333 153 self)
				(if (or earlyOut (> gTimesInRm40 1))
					(= state 62)
				)
			)
			(58
				(theSound dispose:)
				(theSound number: 8 loop: -1 play:)
				(gEgo
					loop: 7
					setLoop: -1
					cel: 0
					posn: 264 16
					setPri: 15
					cycleSpeed: 1
					setCycle: End self
				)
			)
			(59
				(= cycles 30)
			)
			(60
				(gEgo setCycle: Beg self)
			)
			(61
				(gEgo cycleSpeed: 1 hide:)
				(= cycles 30)
			)
			(62
				(= cycles 30)
				(= seconds 0)
			)
			(63
				(cond
					((== gRmAfter40 0)
						(= gRmAfter40 43)
					)
					((> (++ gRmAfter40) 45)
						(= gRmAfter40 42)
					)
				)
				(if (!= lclEgoView 145)
					(Print 40 15) ; "Say, you're getting faster at this!"
				else
					(Print 40 16) ; "At last you find an exit."
					(Print 40 17 #at -1 130) ; "(But where does it lead?)"
					(switch gRmAfter40
						(42
							(Print 40 18) ; "Why, here you are back at the beach!"
						)
						(43
							(Print 40 19) ; "Why, you've found a lovely restaurant!"
						)
						(44
							(Print 40 20) ; "Why, you've found an empty guest room!"
						)
						(45
							(Print 40 21) ; "Why, you've found the resort's barber shop!"
						)
					)
				)
				(gCurRoom newRoom: gRmAfter40)
			)
		)
	)
)

(instance aPottedPlant of Act
	(properties
		y 160
		x 103
		view 415
		signal 16384
	)
)

(instance aBird1 of Extra
	(properties
		y 58
		x 279
		view 700
		signal 16384
		minPause 22
		maxPause 44
		minCycles 11
		maxCycles 22
	)
)

(instance aBird2 of Extra
	(properties
		y 49
		x 140
		view 700
		signal 16384
		minPause 22
		maxPause 55
		minCycles 11
		maxCycles 22
	)
)

(instance aFlower of View
	(properties
		y 156
		x 139
		view 415
		signal 16384
	)
)

(instance aHench of Act
	(properties
		y 1221
		x 222
		view 412
		loop 1
		signal 16384
	)
)

