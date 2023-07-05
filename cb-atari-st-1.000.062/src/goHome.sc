;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 785)
(include sci.sh)
(use Main)
(use Interface)
(use Motion)
(use Game)
(use Actor)
(use System)

(public
	goHome 0
)

(local
	local0
)

(instance goHome of Rm
	(properties)

	(method (init)
		(super init:)
		(HandsOff)
		(Load rsFONT 41)
		(LoadMany rsPIC 83 84)
		(Load rsVIEW 183)
		(Load rsSOUND 64)
		(self curPic: 79)
		(DrawPic 79 4 1 1)
		(actor1
			view: 204
			setLoop: 0
			posn: 310 145
			setPri: 13
			setStep: 1 1
			setScript: MainAction
			init:
		)
		(actor1 cel: (- (NumCels actor1) 1))
		(actor2
			view: 204
			loop: 1
			cel: 0
			setPri: 12
			setCycle: Fwd
			setStep: 1 1
			setScript: Polling
			init:
		)
		(Display 785 0 dsCOORD 100 30 dsWIDTH 240 dsCOLOR 15 dsBACKGROUND -1 dsFONT 0) ; "The next morning..."
		(gConMusic number: 5 loop: -1 play:)
	)

	(method (handleEvent event)
		(if (event claimed:)
			(return)
		)
	)

	(method (doit)
		(super doit:)
	)

	(method (dispose)
		(super dispose:)
	)

	(method (cue)
		(cls)
		(gCurRoom newRoom: 781) ; dock
	)
)

(instance Polling of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(if (> local0 1)
					(= state 2)
				)
				(= cycles (Random 15 50))
			)
			(1
				(if (actor1 cel:)
					(actor1 setCycle: Beg self)
				else
					(= cycles 1)
				)
			)
			(2
				(actor1 setCycle: End self)
				(= state -1)
			)
		)
	)
)

(instance MainAction of Script
	(properties)

	(method (doit)
		(switch local0
			(1
				(actor2 posn: (- (actor1 x:) 37) (+ (actor1 y:) 1))
			)
			(3
				(actor2 posn: (+ (actor1 x:) 10) (- (actor1 y:) 35))
				(actor3 posn: (- (actor1 x:) 87) (+ (actor1 y:) 2))
			)
		)
		(super doit:)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= local0 1)
				(actor1 setMotion: MoveTo 9 145 self)
			)
			(1
				(= local0 2)
				(gConMusic fade:)
				(goHome curPic: 83)
				(DrawPic 83 7 1 0)
				(actor1 stopUpd:)
				(actor2
					view: 183
					setLoop: 3
					posn: 134 137
					setPri: 14
					cycleSpeed: 1
					setCycle: End self
				)
				(Display 785 1 dsCOORD 90 30 dsWIDTH 240 dsCOLOR 15 dsBACKGROUND -1 dsFONT 0) ; "Later that same day..."
			)
			(2
				(gConMusic number: 64 loop: -1 play:)
				(actor2
					setLoop: 3
					setCel: (- (NumCels actor2) 1)
					setStep: 4 4
					setMotion: MoveTo 278 178 self
				)
			)
			(3
				(= local0 3)
				(actor1
					view: 183
					loop: 0
					posn: -13 121
					setPri: 12
					setStep: 1 1
					setMotion: MoveTo 180 121 self
				)
				(actor2
					view: 183
					setLoop: 2
					setPri: 12
					cycleSpeed: 0
					setCycle: Fwd
				)
				(actor3 view: 183 setLoop: 1 setPri: 12 setCycle: Fwd init:)
			)
			(4
				(= local0 4)
				(goHome curPic: 84)
				(DrawPic 84 7 1 0)
				(gAddToPics add: body hand eachElementDo: #init doit:)
				(actor1
					view: 284
					loop: 1
					cel: 0
					posn: 250 74
					cycleSpeed: 1
					startUpd:
					setCycle: End
					setMotion: 0
				)
				(actor2
					view: 284
					loop: 2
					cel: 0
					posn: 258 82
					priority: 14
					cycleSpeed: 1
					setCycle: 0
				)
				(actor3
					view: 284
					loop: 5
					setPri: 0
					setStep: 2 2
					x: -10
					y: 17
					cycleSpeed: 0
					setMotion: MoveTo 336 17
				)
				(Print 785 2 #at 17 135 #width 280 #dispose) ; "As you near the wharf at New Orleans, you consider last night's events. Was Rudy telling you the truth...or could there be more to the story?"
				(= seconds 8)
			)
			(5
				(actor2 setCycle: End self)
			)
			(6
				(actor2 loop: 3 cel: 0 setCycle: Fwd)
				(Print 785 3 #at 17 135 #width 280 #dispose) ; "Oh, well. You'll probably never know. Best to forget it, and go on with your life; maybe the police will find the answers. Poor Lillian...poor everybody."
				(= seconds 8)
			)
			(7
				(cls)
				(actor2 setCycle: Beg self)
			)
			(8
				(actor1 setCycle: Beg self)
				(actor2 loop: 2)
				(actor2 cel: (- (NumCels actor2) 1) setCycle: Beg)
			)
			(9
				(gConMusic fade:)
				(Display 785 4 dsCOORD 111 49 dsWIDTH 50 dsCOLOR 6 dsBACKGROUND -1 dsFONT 41) ; "The End"
				(Display 785 4 dsCOORD 110 47 dsWIDTH 50 dsCOLOR 14 dsBACKGROUND -1 dsFONT 41) ; "The End"
				(= seconds 6)
			)
			(10
				(gCurRoom newRoom: 786) ; SlthOMtr
			)
		)
	)
)

(instance body of PV
	(properties
		y 156
		x 235
		view 284
	)
)

(instance hand of PV
	(properties
		y 105
		x 248
		view 284
		loop 4
		priority 15
	)
)

(instance actor1 of Act
	(properties)
)

(instance actor2 of Act
	(properties)
)

(instance actor3 of Act
	(properties)
)

