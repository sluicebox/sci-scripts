;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 390)
(include sci.sh)
(use Main)
(use n021)
(use Interface)
(use Motion)
(use Game)
(use Actor)
(use System)

(public
	rm390 0
)

(local
	seenMsg
	[string 200]
)

(procedure (PrintBambi)
	(cls)
	(Print @string #at 5 10 #title {Bambi says...} #width 130 #mode 1 #dispose)
)

(procedure (PrintLarry)
	(cls)
	(Print @string #at 160 10 #title {You say...} #width 140 #mode 1 #dispose)
)

(instance rm390 of Rm
	(properties
		picture 390
	)

	(method (init)
		(aMike init:)
		(super init:)
		(if (and (not (TestFlag 52)) (not (TestFlag 53)))
			(aMonitorRight init:)
			(aMonitorLeft init:)
			(aBambi init:)
		)
		(self setScript: RoomScript)
		(if (== gPrevRoomNum 395)
			(gEgo posn: 135 155 loop: 2)
			(if (!= gEgoState 1)
				(= gEgoState 0)
			else
				(gMusic stop:)
				(Load rsVIEW 392)
				(Load rsVIEW 393)
				(Load rsVIEW 397)
				(Load rsSOUND 390)
				(aBambi setScript: 0)
				(RoomScript changeState: 1)
			)
		else
			(gEgo posn: 243 134 setLoop: 1)
		)
		(if (!= gEgoState 1)
			(NormalEgo)
			(if (gCast contains: aBambi)
				(BambiScript changeState: 1)
			)
		)
		(gEgo init:)
	)
)

(instance RoomScript of Script
	(properties)

	(method (doit)
		(super doit:)
		(if (< (gEgo priority:) 5)
			(if (not seenMsg)
				(= seenMsg 1)
				(ShakeScreen 1 ssUPDOWN)
				(Print 390 0) ; "Jeez, it's dark back here!" you cry, ramming your nose into the rear wall of the studio. "OW!"
				(gEgo setMotion: 0)
			)
		else
			(= seenMsg 0)
		)
		(if (& (gEgo onControl:) $0002)
			(gCurRoom newRoom: 360)
		)
	)

	(method (handleEvent event)
		(if (or (!= (event type:) evSAID) (event claimed:))
			(return)
		)
		(cond
			((Said 'rise,nightstand,get,get,jump,climb<on/backstage')
				(Print 390 1) ; "Stay on the floor."
			)
			((Said 'get,get')
				(Print 390 2) ; "There is nothing in the studio that you need."
			)
			((Said 'open,activate,(pull<on)/camera')
				(Print 390 3) ; "Leave the equipment alone!"
			)
			((Said 'make/tape')
				(Print 390 4) ; "Who would want a video of you?"
			)
			(
				(or
					(Said '/exercise,(work<out),aerobic')
					(Said '//exercise,(work<out),aerobic')
					(Said
						'exercise,class,dance,dance,strip,strip,(work<out),exercise'
					)
				)
				(if gEgoIsHunk
					(Print 390 5) ; "You've done enough exercising for one game!"
				else
					(Print 390 6) ; "You need to, but this is not the place. Try the weight room, tubby!"
				)
			)
			((Said 'look,look>')
				(cond
					((Said '/camera,equipment,camera,tape,microphone')
						(Print 390 7) ; "The room is filled with enough professional video equipment to produce a complete movie."
					)
					((Said '/burn,burn')
						(Print 390 8) ; "The glare is frightening."
					)
					((Said '[/area]')
						(Printf ; "You are in Fat City's Aerobics Studio, which is presently filled with audio/video equipment. %s"
							390
							9
							(cond
								((gCast contains: aBambi) {A beautiful blond woman stands on the stage with a puzzled expression on her face.})
								((TestFlag 53) {It looks like someone was recently here making a video.})
								(else {The equipment seems to have suffered some sort of meltdown!})
							)
							(cond
								((gCast contains: aBambi) {GAuf der B\81hne steht eine h\81bsche Blonde. Sie blickt ratlos drein.})
								((TestFlag 53) {Anscheinend hat hier k\81rzlich jemand ein Video gedreht.})
								(else {Die Ger\84te sehen aus, als h\84tten sie schon viel \81ber sich ergehen lassen m\81ssen!})
							)
						)
					)
				)
			)
		)
	)

	(method (changeState newState)
		(ShowState self newState 1 2)
		(switch (= state newState)
			(0)
			(1
				(HandsOff)
				(gMusic stop:)
				(= cycles 2)
				(= seconds 3)
			)
			(2
				(gMusic stop:)
			)
			(3
				(gMusic stop:)
				(= gOldGameSpeed (gGame setSpeed: 6))
				(Print 390 10) ; ""Tell me what you think of these moves, Larry," Bambi says."
				(gMusic number: 390 loop: -1 play: self)
				(aSpeakerLeft init:)
				(aSpeakerRight init:)
				(aBambi cycleSpeed: 1 setCycle: Fwd)
				(= cycles 30)
			)
			(4
				(aBambi setLoop: 0)
				(= cycles 30)
			)
			(5
				(aBambi setLoop: 1)
				(= cycles 30)
			)
			(6
				(aBambi setLoop: 2 setCel: 0 setCycle: End self)
			)
			(7
				(aBambi setLoop: 3 setCycle: Fwd)
				(= cycles 30)
			)
			(8
				(aBambi setLoop: 2 setCel: 255 setCycle: Beg self)
			)
			(9
				(aBambi setLoop: 4 setCycle: Fwd)
				(= cycles 30)
			)
			(10
				(Format @string 390 11) ; "It's needs to be a little hotter, Bambi," you say. "Come on, honey, really turn me on!"
				(PrintLarry)
				(aBambi view: 392 setLoop: 0 cycleSpeed: 0)
				(= cycles 30)
			)
			(11
				(Format @string 390 12) ; "How about this?"
				(PrintBambi)
				(aBambi setLoop: 1)
				(= cycles 30)
			)
			(12
				(Format @string 390 13) ; "You're getting there!"
				(PrintLarry)
				(= cycles 30)
			)
			(13
				(aMike setCycle: End self)
				(= cycles 30)
			)
			(14
				(aMike stopUpd:)
			)
			(15
				(aBambi setLoop: 2 setCel: 0 setCycle: End self)
			)
			(16
				(aBambi setLoop: 3 setCycle: Fwd)
				(= cycles 30)
			)
			(17
				(Format @string 390 14) ; "Go, Bambi, GO!"
				(PrintLarry)
				(aBambi setLoop: 4)
				(= cycles 30)
			)
			(18
				(aBambi setLoop: 5 setCel: 0 setCycle: End self)
			)
			(19
				(Format @string 390 15) ; ""Here's a little move that could put us `over the top!'" Bambi yells."
				(PrintBambi)
				(aBambi setLoop: 6 setCycle: Fwd)
				(= cycles 30)
			)
			(20
				(aMonitorLeft dispose:)
				(aMonitorRight dispose:)
				(aLens init: setCycle: End self)
			)
			(21
				(aLens stopUpd:)
				(= seconds 5)
			)
			(22
				(= seconds 0)
				(Format @string 390 16) ; "I can't stand this any longer, Larry! All these movements have turned ME on! Come on, Larry! Enough of this rehearsal. IT'S SHOW TIME!!"
				(cls)
				(Print
					@string
					#at
					5
					10
					#title
					{Bambi says...}
					#width
					180
					#mode
					1
					#dispose
				)
				(gMusic fade:)
				(aBambi
					view: 393
					setPri: -1
					setLoop: 0
					posn: 157 155
					setCycle: Walk
					setMotion: MoveTo 180 154 self
				)
			)
			(23
				(aBambi setMotion: MoveTo 200 134 self)
			)
			(24
				(gEgo
					setCycle: Walk
					setLoop: -1
					illegalBits: 0
					ignoreActors:
					setMotion: MoveTo 180 154 self
				)
				(aBambi setScript: BambiScript)
				(BambiScript changeState: 6)
				(gGame setSpeed: gOldGameSpeed)
			)
			(25
				(gEgo setMotion: MoveTo 200 134 self)
			)
			(26
				(gEgo setMotion: MoveTo 333 134)
			)
		)
	)
)

(instance aBambi of Actor
	(properties
		x 160
		y 155
		view 391
	)

	(method (init)
		(super init:)
		(self
			illegalBits: 0
			ignoreHorizon:
			ignoreActors:
			setPri: 14
			setScript: BambiScript
		)
	)
)

(instance BambiScript of Script
	(properties)

	(method (handleEvent event)
		(if (or (!= (event type:) evSAID) (event claimed:))
			(return)
		)
		(cond
			((Said 'look,look/woman,woman,dale,bambi')
				(cond
					((not (& (gEgo onControl:) $0008))
						(Print 390 17) ; "A tall statuesque blond is working out on a stage surrounded by video equipment."
					)
					((TestFlag 8)
						(Print 390 18) ; "Phew!" she cries, "we DO have showers here, you know! I suggest you try one before I pass out!"
					)
					((TestFlag 10)
						(Print 390 19) ; "Phew! Have you ever tried using soap? It wouldn't kill you to practice a little self-hygiene."
					)
					((TestFlag 62)
						(Print 390 20) ; "Phew!" squeeks Bambi. "What B.O. you have!"
					)
					(else
						(self changeState: 4)
					)
				)
			)
			((Said '/boob,body')
				(Print 390 21) ; "What a body!"
				(Print 390 22 #at -1 144) ; "(You vow to get more exercise in the future!)"
			)
			((Said '/woman,woman,dale,bambi')
				(if (not (& (gEgo onControl:) $0008))
					(NotClose) ; "You're not close enough."
				else
					(Print 390 23) ; "Perhaps you should look at her first."
				)
			)
		)
	)

	(method (changeState newState)
		(ShowState self newState 2 2)
		(switch (= state newState)
			(0)
			(1
				(aBambi
					setCycle: Fwd
					setLoop:
						(switch (Random 0 2)
							(0 0)
							(1 1)
							(else 4)
						)
				)
				(= seconds (Random 5 11))
			)
			(2
				(aBambi setLoop: 1 setCel: 0)
				(= seconds (Random 2 4))
				(= state 0)
			)
			(3)
			(4
				(aBambi setLoop: 1 setCel: 0)
				(if (TestFlag 71)
					(Print 390 24) ; "I'm back, Bambi!"
				else
					(Printf 390 25 global386 global387) ; ""Hello, beautiful," you say, %s"
				)
				(= seconds 3)
			)
			(5
				(if (TestFlag 71)
					(Print 390 26) ; "Hi, Larry. How's it going?"
				else
					(SetFlag 71)
					(if gEgoIsHunk
						(Print 390 27) ; "Wow, Larry! How come I've never seen you before? A hunk like you would be hard to forget!"
					else
						(Print 390 28) ; "It's nice to meet you, Larry Laffer. From the looks of that stomach, you've come to the right place!"
					)
				)
				(= gEgoState 14)
				(gCurRoom newRoom: 395)
			)
			(6
				(aBambi setMotion: MoveTo 333 134)
			)
		)
	)
)

(instance aSpeakerLeft of Prop
	(properties
		x 36
		y 154
		view 390
		loop 2
		cel 1
	)

	(method (init)
		(super init:)
		(self setPri: 15 setCycle: Fwd)
	)
)

(instance aSpeakerRight of Prop
	(properties
		x 294
		y 153
		view 390
		loop 3
		cel 1
	)

	(method (init)
		(super init:)
		(self setPri: 15 setCycle: Fwd)
	)
)

(instance aLens of Prop
	(properties
		x 60
		y 73
		view 390
		cycleSpeed 1
	)

	(method (init)
		(super init:)
		(self setPri: 9 ignoreActors:)
	)
)

(instance aMike of Prop
	(properties
		x 168
		y 61
		view 390
		loop 1
		cycleSpeed 2
	)

	(method (init)
		(super init:)
		(self setPri: 2 stopUpd:)
	)
)

(instance aMonitorLeft of Prop
	(properties
		x 93
		y 121
		view 396
	)

	(method (init)
		(super init:)
		(self setPri: 11 ignoreActors:)
	)

	(method (doit)
		(self
			view: (+ 5 (aBambi view:))
			loop: (aBambi loop:)
			cel: (aBambi cel:)
		)
		(super doit:)
	)
)

(instance aMonitorRight of Prop
	(properties
		x 229
		y 121
		view 396
	)

	(method (init)
		(super init:)
		(self setPri: 11 setCycle: Fwd ignoreActors:)
	)

	(method (doit)
		(self
			view: (+ 5 (aBambi view:))
			loop: (aBambi loop:)
			cel: (aBambi cel:)
		)
		(super doit:)
	)
)

