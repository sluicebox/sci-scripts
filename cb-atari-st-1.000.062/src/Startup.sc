;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 411)
(include sci.sh)
(use Main)
(use Interface)
(use Motion)
(use Game)
(use Menu)
(use Actor)
(use System)

(public
	Startup 0
)

(instance Startup of Rgn
	(properties)

	(method (init)
		(super init:)
		(Load rsFONT 41)
		(Load rsVIEW 642)
		(LoadMany rsSOUND 29 94 95 96)
		(Load rsSCRIPT 406)
		(if (or gPossibleScore (not (IsFlag 50)))
			(gEgo loop: 2 posn: 211 109)
		else
			(TheMenuBar state: 1)
			(gEgo loop: 1 posn: 90 134)
			(global373 setCycle: Walk setPri: 10 show:)
			(daddyBow setLoop: 2 setPri: 14 init: stopUpd: hide:)
			(suitCase setPri: 7 init:)
		)
		(self setScript: beginning)
	)

	(method (doit)
		(super doit:)
	)

	(method (dispose)
		(super dispose:)
	)

	(method (handleEvent event)
		(super handleEvent: event)
	)
)

(instance beginning of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(cond
					((not global216)
						(= state -1)
					)
					((self script:)
						(= state -1)
					)
					((== gHour 6)
						(self setScript: (ScriptID 406 0)) ; Clock
						(= state -1)
					)
				)
				(= cycles 1)
			)
			(1
				(if (or gPossibleScore (not (IsFlag 50)))
					(= gPossibleScore 0)
					(= state 10)
				else
					(Print 411 0) ; "This is the guest room you share with Lillian. Though a bit tired-looking, it seems comfortable enough."
					(= global213 6)
					(Say 1 411 1) ; "Laura, dear. Please excuse me. I'm going to go freshen up in the bathroom. Why don't you explore the estate a bit?"
				)
				(= cycles 1)
			)
			(2
				(global373 setMotion: MoveTo -20 152 self)
				(gEgo loop: 2 stopUpd:)
			)
			(3
				(= global213 12)
				(Say 0 411 2) ; "Hmmmm...something doesn't feel right. Everybody's acting too strange...even Lillian. What would Daddy do in a situation like this?"
				(= cycles 1)
			)
			(4
				(daddyBow
					show:
					cycleSpeed: 0
					moveSpeed: 0
					setCycle: Walk
					setMotion: MoveTo 108 78 self
				)
			)
			(5
				(= cycles 13)
			)
			(6
				(daddyBow hide: dispose: delete:)
				(gEgo startUpd:)
				(= cycles 2)
			)
			(7
				(= global213 26)
				(Say 1 411 3) ; "Honey, if things don't feel right, they probably AREN'T. Observe the situation closely, yet be unobtrusive. Explore your surroundings quietly and carefully. Try to question the others without raising suspicion. Notice small details. Take lots of notes. And above all, be careful."
				(gEgo setMotion: MoveTo 211 109 self)
			)
			(8
				(gEgo loop: 3)
				(suitCase cycleSpeed: 1 setCycle: End self)
			)
			(9
				(Print 411 4) ; "Since you never go anywhere without your trusty notebook and pencil, you go to your suitcase, open it, and remove those two items. Yes...your father is right. Observing the situation and taking notes WOULD be a good idea."
				(suitCase setCycle: Beg self)
			)
			(10
				(if (or (!= (global373 x:) -20) (!= (gEgo loop:) 2))
					(gEgo loop: 2)
					(= state 9)
				else
					(suitCase dispose:)
				)
				(= cycles 1)
			)
			(11
				(gEgo get: 10) ; notebook_and_pencil
				(++ global203)
				(= [gCycleTimers 4] 1800)
				(HandsOn)
				(client setScript: 0)
			)
		)
	)
)

(instance suitCase of Prop
	(properties
		y 88
		x 208
		view 144
		loop 1
	)
)

(instance daddyBow of Act
	(properties
		y 87
		x 96
		view 925
		signal 16384
		illegalBits 0
	)
)

