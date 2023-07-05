;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 330)
(include sci.sh)
(use Main)
(use Door)
(use LoadMany)
(use RFeature)
(use Extra)
(use Jump)
(use Motion)
(use Game)
(use Actor)
(use System)

(public
	rm330 0
)

(local
	local0
	local1
	local2
	local3
	local4
)

(procedure (localproc_0)
	(HighPrint 330 0) ; "There is a sign on the door which says: "Gone Fishing"."
)

(instance rm330 of Rm
	(properties
		picture 330
		east 320
	)

	(method (dispose)
		(gMouseHandler delete: self)
		(SetFlag 97)
		(cond
			((IsFlag 117)
				(DisposeScript 991)
				(ClearFlag 117)
			)
			((IsFlag 118)
				(ClearFlag 118)
			)
		)
		(super dispose:)
	)

	(method (init)
		(LoadMany rsVIEW 300 330 515)
		(if (IsFlag 118)
			(Load rsVIEW 503)
		)
		(if (IsFlag 117)
			(Load rsVIEW 503)
			(Load rsVIEW 338)
		)
		(rm330
			style:
				(switch gPrevRoomNum
					(0 2)
					(320 2)
					(331 16)
					(332 16)
					(else 0)
				)
		)
		(super init:)
		(gMouseHandler add: self)
		(self
			setFeatures:
				onWorkShop
				onTavern
				onAlley
				onButcherShop
				onBakery
				onButcherNote
				onBakeryNote
		)
		(SL enable:)
		(self setLocales: 811 801)
		(if (and (not (IsFlag 117)) (not (IsFlag 118)))
			(NormalEgo)
			(gEgo init:)
		else
			(gEgo view: 503 init: hide:)
		)
		(if (not (IsFlag 117))
			((= local1 (Door new:))
				view: 330
				loop: 0
				cel: 0
				posn: 93 79
				doorControl: 16384
				locked: (if (> gTimeOfDay 6) 1 else 0)
				entranceTo: 331
				facingLoop: 3
				init:
				setPri: 9
				stopUpd:
			)
		)
		((View new:)
			view: 330
			posn: 110 74
			loop: 2
			cel: 1
			setPri: 9
			init:
			stopUpd:
			addToPic:
		)
		((View new:)
			view: 330
			posn: 297 65
			loop: 2
			cel: 2
			setPri: 3
			init:
			stopUpd:
			addToPic:
		)
		((View new:)
			view: 330
			posn: 189 84
			loop: 2
			cel: 0
			setPri: 11
			init:
			stopUpd:
			addToPic:
		)
		(cond
			((== gPrevRoomNum 0)
				(gEgo posn: 318 174 setMotion: MoveTo 300 174)
			)
			((== gPrevRoomNum 64)
				(gEgo posn: 63 168 setMotion: MoveTo 123 168)
			)
			((== gPrevRoomNum 320)
				(gEgo posn: 318 174 setMotion: MoveTo 300 174)
			)
			((or (== gPrevRoomNum 331) (== gPrevRoomNum 332))
				(cond
					((IsFlag 117)
						(self setScript: kickOutScript)
					)
					((IsFlag 118)
						(= [gInvNum 1] 0) ; silver
						(= [gInvNum 2] 0) ; gold
						(local1 cel: 0 doorState: 0)
						(self setScript: gotDrunkScript)
					)
					(else
						(gEgo loop: 2 posn: 112 133)
						(local1 close:)
					)
				)
			)
			((== gPrevRoomNum 999)
				(gEgo view: 515 setLoop: 3 cel: 5 init: setScript: egoWakes)
			)
			(else
				(gEgo loop: 2 posn: 148 135 setMotion: MoveTo 148 144)
			)
		)
		(if (not gNight)
			((View new:)
				view: 300
				posn: 205 120
				loop: 2
				cel: 3
				init:
				stopUpd:
				addToPic:
			)
			((View new:)
				view: 300
				posn: 304 117
				loop: 2
				cel: 3
				init:
				stopUpd:
				addToPic:
			)
		else
			((Extra new:)
				view: 330
				setLoop: 3
				ignoreActors: 1
				posn: 160 126
				setPri: 7
				cycleType: 1
				pauseCel: 1
				minCycles: 1
				maxCycles: 1
				cycleSpeed: 0
				minPause: 12
				maxPause: 30
				init:
			)
		)
		((= local3 (Prop new:))
			view: 330
			loop: 1
			cel: 3
			posn: 3 187
			init:
			ignoreActors:
			stopUpd:
			addToPic:
		)
	)

	(method (doit)
		(if (== (gEgo onControl: 1) 2048)
			(if gNight
				(gCurRoom newRoom: 334)
			else
				(gCurRoom newRoom: 333)
			)
		)
		(super doit:)
	)

	(method (notify param1)
		(cond
			((!= param1 1))
			((not (local1 locked:))
				(HighPrint 330 1) ; "The door isn't locked. Just turn around."
			)
			((not (TrySkill 9 10 global189)) ; pick locks
				(HighPrint 330 2) ; "You haven't been practicing very much."
			)
			(else
				(local1 locked: 0)
				(HighPrint 330 3) ; "That was the easiest lock you've ever encountered. It's now unlocked."
			)
		)
	)

	(method (handleEvent event)
		(switch (event type:)
			(evSAID
				(cond
					((Said 'open/door')
						(cond
							((== (gEgo onControl: 1) 16384)
								(if (> gTimeOfDay 6)
									(HighPrint 330 4) ; "The door appears to be locked."
								else
									(HighPrint 330 5) ; "Turn around."
								)
							)
							(
								(or
									(== (gEgo onControl: 1) 4096)
									(== (gEgo onControl: 1) 8192)
								)
								(HighPrint 330 4) ; "The door appears to be locked."
								(if (not gNight)
									(localproc_0)
								)
							)
							((== (gEgo onControl: 1) 1024)
								(HighPrint 330 4) ; "The door appears to be locked."
							)
							(else
								(event claimed: 0)
							)
						)
					)
					((Said 'look,read/sign,note')
						(if
							(and
								(or
									(> (gEgo x:) 230)
									(and
										(> (gEgo x:) 148)
										(< (gEgo x:) 230)
									)
								)
								(not gNight)
							)
							(localproc_0)
						else
							(HighPrint 330 6) ; "There are several signs above the various establishments on this street, indicating the nature of their business."
						)
					)
					((Said 'look>')
						(cond
							((Said '[<at,around][/!*,street,hamlet]')
								(HighPrint 330 7) ; "You are in the northwest corner of town. There are a Butcher's Shop and a Bakery on the north side of the street. Across from them are the backs of buildings on the next street over."
								(HighPrint 330 8) ; "The Tavern in the corner looks rather rundown, and the alley beside it is dark. On the other side of the tavern is a rather practical-looking building, like a workshop."
							)
							((Said '/bakery,shop[<baker]')
								(HighPrint 330 9) ; "The bakery seems to be closed, although there are some dried-up-looking cupcakes in the window."
								(if (not gNight)
									(localproc_0)
								)
							)
							((Said '/butcher,(shop[<butcher])')
								(HighPrint 330 10) ; "The Butcher's shop seems to be closed."
							)
							((Said '/shop')
								(HighPrint 330 11) ; "Which shop do you mean?"
							)
							((Said '/tavern,bar')
								(HighPrint 330 12) ; "The building looks old, dark, and a little seedy."
							)
							((Said '/shed,shed')
								(if gNight
									(HighPrint 330 13) ; "The workshop is securely locked."
								else
									(HighPrint 330 14) ; "You can hear sounds of hammering from inside. The door is securely locked, and no one responds to your knock."
								)
							)
							((Said '/door')
								(cond
									(
										(or
											(> (gEgo x:) 230)
											(and
												(> (gEgo x:) 148)
												(< (gEgo x:) 230)
											)
										)
										(if (not gNight)
											(localproc_0)
										else
											(event claimed: 0)
										)
									)
									((< 64 (gEgo x:) 148)
										(HighPrint 330 15) ; "Looks like the door to a Tavern."
									)
									((< 0 (gEgo x:) 64)
										(HighPrint 330 16) ; "Looks like this door has been closed for a long time."
									)
									(else
										(HighPrint 330 17) ; "There are signs affixed to the door knobs."
									)
								)
							)
							((Said '/alley')
								(if gNight
									(HighPrint 330 18) ; "It's very dark, but you can see something shining on the ground at the far end of the alley."
								else
									(HighPrint 330 19) ; "It's dark, but there seems to be someone in there."
								)
							)
							((Said '/window')
								(cond
									((> (gEgo x:) 230)
										(HighPrint 330 20) ; "Other than the sorry-looking goods in the window, it is too dark to make out much of anything."
										(if (not gNight)
											(localproc_0)
										)
									)
									(
										(and
											(> (gEgo x:) 148)
											(< (gEgo x:) 230)
										)
										(HighPrint 330 21) ; "The Butcher's shop seems to be closed. Through the window, you see what appears to be a layer of dust over most of the interior."
										(if (not gNight)
											(localproc_0)
										)
									)
									(else
										(HighPrint 330 22) ; "You can't see into any windows from where you're standing."
									)
								)
							)
						)
					)
				)
			)
		)
		(super handleEvent: event)
	)
)

(instance kickOutScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo
					setLoop: 2
					setCel: 0
					illegalBits: 0
					posn: 123 114
					ignoreActors:
					setPri: 8
					show:
				)
				((= local4 (View new:))
					view: 338
					loop: 1
					cel: 3
					posn: 120 126
					ignoreActors:
					init:
					setPri: 7
					stopUpd:
				)
				((= local2 (Prop new:))
					view: 330
					loop: 0
					cel: 0
					posn: 93 79
					init:
					ignoreActors:
					setPri: 9
					stopUpd:
				)
				(HandsOff)
				(= cycles 5)
			)
			(1
				(local2 setCycle: End)
				(= cycles 5)
			)
			(2
				(local2 stopUpd:)
				(gEgo setPri: 11 setMotion: JumpTo 74 166 self)
			)
			(3
				(gEgo setCel: -1 setCycle: End self)
			)
			(4
				(ShakeScreen 5)
				(local4 dispose:)
				(local2 dispose:)
				((= local1 (Door new:))
					view: 330
					loop: 0
					cel: 0
					posn: 93 79
					doorControl: 16384
					locked: (if (> gTimeOfDay 6) 1 else 0)
					entranceTo: 331
					facingLoop: 3
					doorState: 0
					init:
					setPri: 9
					stopUpd:
				)
				(= seconds 4)
			)
			(5
				(gEgo
					setLoop: 4
					setCel: 0
					posn: 62 166
					cycleSpeed: 3
					setCycle: End self
				)
			)
			(6
				(if (not (TakeDamage 5))
					(TakeDamage -5)
				)
				(HandsOn)
				(NormalEgo)
				(gEgo cycleSpeed: 0 loop: 2 cel: 2)
			)
		)
	)
)

(instance gotDrunkScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo loop: 2 cel: 2 illegalBits: 0 posn: 74 166 show:)
				(HandsOff)
				(= seconds 7)
			)
			(1
				(HighPrint 330 23) ; "You regain consciousness."
				(gEgo
					loop: 4
					cel: 0
					posn: 62 166
					cycleSpeed: 3
					setCycle: End self
				)
			)
			(2
				(HighPrint 330 24) ; "After dusting yourself off, you check to make sure you're still in one piece."
				(HighPrint 330 25) ; "Unfortunately, you discover that while you were "out", someone managed to relieve you of all of your money."
				(HighPrint 330 26) ; "Now you'll have to find a way to get some money. The street is not the most comfortable place to sleep, and you have to eat, sooner or later."
				(HandsOn)
				(NormalEgo)
				(gEgo cycleSpeed: 0 loop: 2 cel: 2)
			)
		)
	)
)

(instance onWorkShop of RFeature
	(properties
		nsTop 59
		nsBottom 165
		nsRight 64
	)

	(method (handleEvent event)
		(cond
			((super handleEvent: event))
			((MouseClaimed onWorkShop event 3)
				(if gNight
					(HighPrint 330 13) ; "The workshop is securely locked."
				else
					(HighPrint 330 27) ; "You can hear sounds of hammering from inside. It must be some sort of workshop."
				)
			)
		)
	)
)

(instance onTavern of RFeature
	(properties
		nsTop 8
		nsLeft 65
		nsBottom 128
		nsRight 132
	)

	(method (handleEvent event)
		(cond
			((super handleEvent: event))
			((MouseClaimed onTavern event 3)
				(HighPrint 330 28) ; "The Tavern in the corner looks rather rundown."
			)
		)
	)
)

(instance onAlley of RFeature
	(properties
		nsTop 12
		nsLeft 133
		nsBottom 133
		nsRight 164
	)

	(method (handleEvent event)
		(cond
			((super handleEvent: event))
			((MouseClaimed onAlley event 3)
				(if gNight
					(HighPrint 330 18) ; "It's very dark, but you can see something shining on the ground at the far end of the alley."
				else
					(HighPrint 330 19) ; "It's dark, but there seems to be someone in there."
				)
			)
		)
	)
)

(instance onButcherShop of RFeature
	(properties
		nsTop 15
		nsLeft 165
		nsBottom 142
		nsRight 238
	)

	(method (handleEvent event)
		(cond
			((super handleEvent: event))
			((MouseClaimed onButcherNote event 3)
				(cond
					(
						(and
							(> (gEgo x:) 148)
							(< (gEgo x:) 230)
							(not gNight)
						)
						(localproc_0)
					)
					((not gNight)
						(NotClose)
					)
					(else
						(HighPrint 330 10) ; "The Butcher's shop seems to be closed."
					)
				)
			)
			((MouseClaimed onButcherShop event 3)
				(HighPrint 330 10) ; "The Butcher's shop seems to be closed."
			)
		)
	)
)

(instance onBakery of RFeature
	(properties
		nsTop 7
		nsLeft 261
		nsBottom 140
		nsRight 320
	)

	(method (handleEvent event)
		(cond
			((super handleEvent: event))
			((MouseClaimed onBakeryNote event 3)
				(cond
					((and (> (gEgo x:) 230) (not gNight))
						(localproc_0)
					)
					((not gNight)
						(NotClose)
					)
					(else
						(HighPrint 330 9) ; "The bakery seems to be closed, although there are some dried-up-looking cupcakes in the window."
					)
				)
			)
			((MouseClaimed onBakery event 3)
				(HighPrint 330 9) ; "The bakery seems to be closed, although there are some dried-up-looking cupcakes in the window."
			)
		)
	)
)

(instance onButcherNote of RFeature
	(properties
		nsTop 115
		nsLeft 201
		nsBottom 122
		nsRight 208
	)
)

(instance onBakeryNote of RFeature
	(properties
		nsTop 112
		nsLeft 300
		nsBottom 119
		nsRight 308
	)
)

(instance egoWakes of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo setCycle: Beg self)
			)
			(1
				(NormalEgo)
				(HighPrint 330 29) ; "However, this was not a good place to sleep. You're stiff and sore all over and your wallet feels very light."
				(= [gInvNum 1] 0) ; silver
				(= [gInvNum 2] 0) ; gold
				(HandsOn)
			)
		)
	)
)

