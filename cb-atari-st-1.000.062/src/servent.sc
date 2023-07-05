;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 204)
(include sci.sh)
(use Main)
(use Interface)
(use Motion)
(use Actor)

(class servent of Act
	(properties
		guest1 0
		exitX 0
		exitY 0
		seconds 0
		lastSeconds 0
		serveState 0
		guestState 0
		serving 0
		outOfRoom 0
		itemX 0
		itemY 0
	)

	(method (init)
		(super init:)
		(Load rsFONT 4)
		(= serveState -1)
		(= guestState 1)
		(= serving 0)
		(|= global195 $0400)
	)

	(method (doit &tmp temp0)
		(super doit:)
		(if seconds
			(= temp0 (GetTime 1)) ; SysTime12
			(if (!= lastSeconds temp0)
				(= lastSeconds temp0)
				(if (not (-- seconds))
					(self cue:)
				)
			)
		)
		(if (and (== global167 1) (== serving 0))
			(self serve:)
			(= serving 1)
		)
	)

	(method (dispose)
		(DisposeScript 985)
		(&= global195 $fbff)
		(super dispose:)
	)

	(method (handleEvent event &tmp temp0)
		(if (event claimed:)
			(return)
		)
		(if (and (== (event type:) evSAID) (self inRect: 0 0 319 191))
			(cond
				((or (MousedOn self event 3) (Said 'look/butler,man'))
					(if (& global207 $0400)
						(Print 204 0) ; "Jeeves seems to be busy doing his chores."
					else
						(= global213 11)
						(|= global207 $0400)
						(Say 0 204 1) ; "Jeeves is the Colonel's imposing butler. Though you find him somewhat good-looking, he nevertheless gives off a disconcerting feeling of secretiveness. You have noticed that Jeeves generally keeps to himself and seems to talk in little more than monosyllables. You wonder about him."
					)
					(event claimed: 1)
				)
				((Said 'flirt//(butler,man)<with')
					(Print 204 2) ; "He's not your type!"
				)
				((Said 'ask,get/drink,glass')
					(Print 204 3) ; "You don't care for liquor, remember?"
				)
				((Said 'ask,tell[/butler]/*<about')
					(Print 204 4) ; "You attempt to talk to Jeeves but he ignores you as he goes about his business."
				)
				((or (Said 'give,show/*/butler') (Said 'give,show/*<butler'))
					(if (and global219 global224)
						(Print 204 4) ; "You attempt to talk to Jeeves but he ignores you as he goes about his business."
					else
						(DontHave) ; "You don't have it."
					)
				)
				((Said 'look/people')
					(Printf ; "It appears that Jeeves is trying to serve a drink to %s."
						204
						5
						(switch gCurRoomNum
							(32 {Wilbur})
							(36 {Gloria})
							(38 {Clarence})
							(48 {Rudy})
						)
					)
				)
				((Said 'look/men')
					(Printf ; "It appears that Jeeves is trying to serve a drink to %s."
						204
						5
						(switch gCurRoomNum
							(32 {Wilbur})
							(38 {Clarence})
							(48 {Rudy})
							(else
								(event claimed: 0)
							)
						)
					)
				)
				((Said '/butler,man>')
					(cond
						((Said 'talk')
							(Print 204 4) ; "You attempt to talk to Jeeves but he ignores you as he goes about his business."
						)
						((Said 'get')
							(Print 204 6) ; "You wouldn't want him!!"
						)
						((Said 'kill')
							(Print 204 7) ; "Now, now! There's no need for that!"
						)
						((Said 'embrace')
							(Print 204 8) ; "He's too strange."
						)
						((Said 'kiss')
							(Print 204 9) ; "He doesn't appeal to you."
						)
					)
				)
			)
		)
	)

	(method (serve)
		(self setMotion: MoveTo itemX itemY self)
	)

	(method (leave)
		(= serveState 2)
		(= outOfRoom 1)
		(self setMotion: MoveTo exitX exitY self)
	)

	(method (converse)
		(= seconds 3)
	)

	(method (cue)
		(switch (++ serveState)
			(0
				(self loop: 3)
				(Print 204 10 #at 160 10 #font 4 #draw #dispose) ; "Would you like a drink?"
				(self converse:)
			)
			(1
				(cls)
				(Print 204 11 #at 160 10 #font 4 #draw #dispose) ; "No, thank you."
				(self converse:)
			)
			(2
				(cls)
				(= serveState -1)
				(self leave:)
			)
			(3
				(if (== outOfRoom 1)
					(self setAvoider: 0 stopUpd: dispose:)
				)
			)
		)
	)
)

