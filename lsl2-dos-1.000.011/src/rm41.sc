;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 41)
(include sci.sh)
(use Main)
(use Interface)
(use Motion)
(use Game)
(use Actor)
(use System)

(public
	rm41 0
)

(local
	work
	bikiniHere
	henchInvited
	goto95
	aBikini
	aHench
)

(instance rm41 of Rm
	(properties
		picture 41
		horizon 5
	)

	(method (init)
		(Load rsVIEW 401)
		(Load rsVIEW 403)
		(super init:)
		((View new:) view: 401 loop: 0 cel: 0 posn: 34 111 setPri: 7 addToPic:)
		((View new:) view: 401 loop: 1 cel: 0 posn: 77 148 setPri: 11 addToPic:)
		((View new:) view: 401 loop: 2 cel: 0 posn: 119 104 setPri: 6 addToPic:)
		((View new:) view: 401 loop: 2 cel: 1 posn: 88 82 setPri: 4 addToPic:)
		((View new:) view: 401 loop: 3 cel: 1 posn: 10 80 setPri: 4 addToPic:)
		((View new:) view: 401 loop: 3 cel: 0 posn: 41 109 setPri: 7 addToPic:)
		((View new:) view: 403 loop: 0 cel: 0 posn: 86 136 setPri: 9 addToPic:)
		((View new:) view: 403 loop: 0 cel: 1 posn: 58 70 setPri: 3 addToPic:)
		((View new:) view: 403 loop: 1 cel: 0 posn: 22 109 setPri: 7 addToPic:)
		((View new:) view: 403 loop: 2 cel: 0 posn: 94 99 setPri: 6 addToPic:)
		(if (< (gEgo y:) 165)
			(gEgo y: 165)
		)
		(NormalEgo)
		(gEgo init:)
		(self setRegions: 401 setScript: rm41Script) ; rm401
		(cond
			((and ((gInventory at: 16) ownedBy: gCurRoomNum) (== gCurrentEgoView 149)) ; Bikini_Bottom
				(= bikiniHere 1)
				(Load rsVIEW 400)
				((= aBikini (View new:))
					view: 400
					ignoreActors:
					posn: 88 159
					stopUpd:
					init:
				)
			)
			((== gCurrentEgoView 100)
				(self setRegions: 8) ; rm8
				(= gHenchOnScreen 1)
				(= gCurrentHenchView 402)
				(Load rsVIEW 402)
				((= aHench (Act new:))
					view: gCurrentHenchView
					illegalBits: 0
					setLoop: 4
					setPri: 12
					posn: 106 156
					cycleSpeed: 2
					init:
					setScript: henchScript
				)
				(Notify 8 1)
			)
		)
	)
)

(instance rm41Script of Script
	(properties)

	(method (doit)
		(super doit:)
		(if (== 2 (gEgo edgeHit:))
			(if (== goto95 0)
				(gCurRoom newRoom: 42)
			else
				(Print 41 0 #at 15 -1 #width 280) ; "You quickly seduce the beautiful, naked woman, then head for the resort parking lot where she leaves her personal helicopter. A short, romantic, low-altitude chopper ride across the South Pacific is followed by..."
				(= gCurrentStatus 23)
				(gCurRoom newRoom: 95)
			)
		)
		(if (and gHenchOnScreen henchInvited (> (gEgo x:) 300))
			(= henchInvited 0)
			(= goto95 1)
			(gCurRoom east: 95)
			(Print 41 1) ; "Hey, baby," you cry, "wait for me!!"
		)
	)

	(method (handleEvent event)
		(if (or (!= (event type:) evSAID) (event claimed:))
			(return)
		)
		(if (Said 'climb[<over]/boulder')
			(Print 41 2) ; "That won't help you."
		)
		(if (Said 'look>')
			(if (and gHenchOnScreen (Said '/woman'))
				(Print 41 3) ; "Suddenly, you start to perspire!"
			)
			(if (Said '/children,man,bed,woman')
				(Print 41 4 #at -1 152 #font gSmallFont) ; "(blush)"
			)
			(if (Said '/palm')
				(Print 41 5) ; "The large, straight trunk rises high into the sky above the beautiful sand beach."
				(if (> gFilthLevel 13)
					(Print 41 6 #at -1 152) ; "(Or is that the guy with the good tan?)"
				)
			)
			(if (Said '/boulder')
				(Print 41 7) ; "They effectively prevent you from joining the "beautiful people.""
				(if bikiniHere
					(Print 41 8) ; "There's a discarded bikini bottom lying that rock at the eastern edge of the sand."
				)
			)
			(if (Said '[/airport,boulder,beach]')
				(Print 41 9) ; "Say! These people have no clothes on! What kind of place is this, anyway?"
				(if bikiniHere
					(Print 41 8) ; "There's a discarded bikini bottom lying that rock at the eastern edge of the sand."
				)
			)
		)
		(if gHenchOnScreen
			(if (Said 'get/towel')
				(Print 41 10) ; "She needs it."
			)
			(if (Said 'talk/woman')
				(if (not (gEgo inRect: 75 150 160 189))
					(NotClose) ; "You're not close enough."
				else
					(Print (Format @gString 41 11 gLaffer)) ; ""Hi ya, baby," you tell her. %s"
					(if (not (henchScript state:))
						(henchScript changeState: 4)
					)
				)
			)
		)
		(if
			(or
				(Said 'wear,(alter<in),(drop<on)/job,(bra<bathing),bikini')
				(Said 'alter,(get<off),drain/bra,bra')
				(Said 'wear,(drop<on)/job,lid,bottom,(bra<bathing),bikini')
				(Said 'get<naked')
				(Said 'naked')
				(Said 'alter,(get<off),drain/bra,bra')
			)
			(Print 41 12) ; "There's already enough skin visible here!"
			(Print 41 13) ; "Try that elsewhere."
		)
		(if (Said 'get/bottom,bikini,(bottom<bikini)')
			(cond
				((not bikiniHere)
					(Print 41 14) ; "Where?"
				)
				((not (gEgo inRect: 76 179 106 189))
					(NotClose) ; "You're not close enough."
				)
				(else
					(Print 41 15) ; "It looks a little small for you, but what the heck..."
					(= bikiniHere 0)
					(gEgo get: 16) ; Bikini_Bottom
					(aBikini dispose:)
					(gGame changeScore: 4)
				)
			)
		)
	)
)

(instance henchScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= cycles (Random 30 50))
			)
			(1
				(aHench setCycle: Fwd)
				(= cycles (Random 5 22))
			)
			(2
				(aHench setCel:)
				(= seconds 5)
			)
			(3
				(switch (Random 1 3)
					(1
						(Print 41 16) ; "Oooh, I find clothed men so appealing!"
					)
					(2
						(Print 41 17) ; "Isn't polyester comfortable?"
					)
					(3
						(Print 41 18) ; "Are you new around here, good lookin'?"
					)
				)
				(Print 41 19 #at -1 152) ; "(Was that naked woman talking to you?)"
				(self changeState: 0)
			)
			(4
				(= cycles 0)
				(aHench setCel: 0)
				(Print 41 20 #at 15 -1 #width 280 #draw) ; "Well, hello yourself, big boy," says the totally naked woman lying on the rock. "Aren't you the overdressed one? Say, since you're all dressed and I was just thinking of leaving, why don't we go to my place together. I know a wonderful spot near here where we can be alone. Come on, Larry, just follow me!"
				(= seconds 5)
			)
			(5
				(aHench
					setAvoider: (Avoid new:)
					setStep: 3 2
					setLoop: -1
					setPri: -1
					cycleSpeed: 0
					loop: 0
					posn: 105 183
					setCycle: Walk
					setAvoider: Avoid
					setMotion: MoveTo 333 183 self
				)
				(= cycles 20)
			)
			(6
				(if (> (aHench x:) (gEgo x:))
					(Print 41 21) ; "Well, Tiger? What are you waiting for? Follow me!"
				else
					(Print 41 22) ; "C'mon Larry; let's go to my vehicle!"
				)
				(= henchInvited 1)
			)
			(7
				(= seconds 10)
			)
			(8
				(aHench dispose:)
				(= gCurrentHenchView 0)
				(= gHenchOnScreen 0)
				(= henchInvited 0)
			)
		)
	)
)

