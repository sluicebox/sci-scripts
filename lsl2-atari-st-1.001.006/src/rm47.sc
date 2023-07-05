;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 47)
(include sci.sh)
(use Main)
(use Interface)
(use Motion)
(use Game)
(use Actor)
(use System)

(public
	rm47 0
)

(local
	aPlane
	aWave
	henchStatus
	aHench1
	aHench2
	aWaveEast
)

(instance rm47 of Rm
	(properties
		picture 47
		horizon 5
		east 48
		west 42
	)

	(method (init)
		(Load rsVIEW 410)
		(Load rsVIEW 411)
		(Load rsVIEW 413)
		(Load rsVIEW 511)
		(Load rsVIEW 406)
		(super init:)
		((View new:)
			view: 410
			loop: 0
			cel: 1
			posn: 181 143
			setPri: 10
			addToPic:
		)
		((View new:) view: 410 loop: 1 cel: 0 posn: 282 124 setPri: 8 addToPic:)
		((View new:)
			view: 410
			loop: 0
			cel: 0
			posn: 200 125
			setPri: 8
			ignoreActors:
			addToPic:
		)
		((= aWave (Prop new:))
			view: 406
			ignoreActors:
			posn: 268 49
			setCycle: Fwd
			cycleSpeed: 6
			isExtra: 1
			init:
		)
		((= aPlane (Act new:))
			view: 511
			setLoop: 5
			setCel: 0
			setPri: 3
			posn: 322 24
			illegalBits: 0
			ignoreActors:
			setStep: 1 1
			init:
			hide:
		)
		((= aHench1 (Act new:))
			view: 411
			setLoop: 1
			setCycle: Walk
			setStep: 4 3
			ignoreControl: 16384
			posn: 159 133
			init:
			setAvoider: (Avoid new:)
		)
		((= aHench2 (Act new:))
			view: 411
			setLoop: 0
			setCycle: Walk
			setStep: 4 3
			posn: 54 151
			init:
			setAvoider: (Avoid new:)
		)
		(cond
			((> 99 (gEgo y:))
				(gEgo y: 98)
			)
			((< 134 (gEgo y:))
				(gEgo y: 133)
			)
		)
		(NormalEgo)
		(gEgo x: 3 observeControl: 16384 init:)
		(if (and gBodyWaxed (== gCurrentEgoView 151))
			(= henchStatus 8)
		)
		(self setRegions: 401 setScript: rm47Script) ; rm401
	)
)

(instance rm47Script of Script
	(properties)

	(method (doit)
		(super doit:)
		(cond
			((and (== henchStatus 0) (gEgo inRect: 86 2 333 140))
				(= henchStatus 1)
				(aHench1 setScript: hench1Script)
				(aHench2 setScript: hench2Script)
			)
			((and (== henchStatus 8) (gEgo inRect: 86 2 333 140))
				(= henchStatus 9)
				(Print 47 0) ; "Whoa-aaah! Hellooo, baaabee," cries the KGB agent, "Oooh, honey, I thinks I loves ya!!"
				(Print 47 1 #at -1 152) ; "(Vhat happened to his accent?)"
			)
			((== 2 (gEgo edgeHit:))
				(HandsOff)
				(gGame changeScore: 12)
				(Print 47 2) ; "You did it! You made it across the beach without being caught by the KGB agents!!"
				(Print 47 3) ; "What lies ahead now?!"
			)
		)
	)

	(method (handleEvent event)
		(if (or (!= (event type:) evSAID) (event claimed:))
			(return)
		)
		(if (Said 'talk/agent,man')
			(Print 47 4) ; "Don't! They might recognize your voice."
		)
		(if (Said 'look>')
			(if (Said '/man,agent')
				(Print 47 5) ; "Two particularly interesting guys are wearing slouch hats and trench coats."
			)
			(if (Said '[/airport,bush]')
				(Print 47 6) ; "Funny. This entire beach is filled with men."
			)
		)
	)
)

(instance hench1Script of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(aHench1 setMotion: MoveTo 138 134 self)
			)
			(1
				(aHench1 setScript: (henchScript new:))
			)
		)
	)
)

(instance hench2Script of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(aHench2 setMotion: MoveTo 123 152 self)
			)
			(1
				(aHench2 setScript: (henchScript new:))
			)
		)
	)
)

(instance henchScript of Script
	(properties)

	(method (changeState newState &tmp tmpX tmpY)
		(switch (= state newState)
			(0
				(client setLoop: -1 setMotion: Chase gEgo 11 self)
			)
			(1
				(if (== henchStatus 1)
					(= gCurrentStatus 1000)
					(= henchStatus 2)
					(Print 47 7) ; ""I have him!" cries the agent."
					(HandsOff)
					(gEgo stopUpd:)
					(aPlane show: setMotion: MoveTo 116 13)
					(= tmpY (- (gEgo y:) 1))
					(if (< (gEgo x:) (client x:))
						(= tmpX (+ (gEgo x:) 11))
						(client setLoop: 1)
					else
						(= tmpX (- (gEgo x:) 11))
						(client setLoop: 0)
					)
					(client
						view: 413
						ignoreActors:
						illegalBits: 0
						posn: tmpX tmpY
						setMotion: 0
						setPri: (+ (gEgo priority:) 1)
						cel: 0
						setCycle: End self
					)
				)
			)
			(2
				(= seconds 3)
				(cond
					((== gCurrentEgoView 151)
						(Print 47 8) ; ""Ve caught ju, ju vicious villian of the People!" shouts the KGB agent, by now growing quite hoarse."
						(Print 47 9) ; ""How did you know it was me?" you ask."
						(Print 47 10) ; ""Only in Russia do vomen have such body hair!" he answers."
					)
					((== gCurrentEgoView 150)
						(Print 47 11) ; ""Ve caught ju, ju pawn of the proletariat!" screams the poorly disguised KGB agent."
						(Print 47 9) ; ""How did you know it was me?" you ask."
						(Print 47 12) ; ""Only in Russia do vomen have such flat chests!" he responds."
					)
					((== gCurrentEgoView 149)
						(Print 47 13) ; "Ve caught ju, ju capitalist slime-sucking pig," shouts the KGB agent, "we vill make you ze best-looking fashion model in all U.S.S.R!"
						(Print 47 9) ; ""How did you know it was me?" you ask."
						(Print 47 14) ; ""Only in Russia do women wear leisure suits to beach!" he replies."
					)
					((== gCurrentEgoView 100)
						(Print 47 15) ; ""Ve caught ju, ju capitalist bourgeois enlistee of the Evil Empire!" shouts the KGB agent, looking ill-at-ease in his ill-fitted trench coat and oversized Speedo."
					)
					(else
						(Print 47 16) ; "Got you!"
					)
				)
			)
			(3
				(Print 47 17) ; "The KGB have recognized you, captured you, and will now take you to their headquarters for questioning..."
				(Print 47 18) ; "...and other fun stuff!"
				(= seconds 4)
			)
			(4
				(Print 47 19) ; "Too bad, too, since you were nearing the airport... and your freedom from this resort!"
				(= gCurrentStatus 23)
				(gCurRoom newRoom: 96)
			)
		)
	)
)

