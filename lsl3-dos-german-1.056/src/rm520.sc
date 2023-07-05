;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 520)
(include sci.sh)
(use Main)
(use Interface)
(use Motion)
(use Game)
(use Actor)
(use System)

(public
	rm520 0
)

(local
	drownCount
	[string 150]
	[string2 66]
)

(instance rm520 of Rm
	(properties
		picture 520
		east 523
		south 510
	)

	(method (init)
		(Load rsVIEW 511)
		(Load rsVIEW 812)
		(Load rsVIEW 813)
		(Load rsVIEW 521)
		(Load rsSOUND 4)
		(Load rsSOUND 6)
		(if (gEgo has: 15) ; Pantyhose
			(Load rsVIEW 15)
		)
		(super init:)
		(self setScript: RoomScript)
		(aRock1 init:)
		(aRock2 init:)
		(aRock3 init:)
		(aRock4 init:)
		(aRock5 init:)
		(cond
			((== gEgoState 12)
				(gEgo posn: 69 188)
				(= gEgoState 1003)
				(RoomScript changeState: 1)
			)
			((== gPrevRoomNum 523)
				(NormalEgo 1)
			)
			(else
				(gEgo posn: 181 188)
				(NormalEgo 3)
			)
		)
		(gEgo init:)
	)
)

(instance RoomScript of Script
	(properties)

	(method (doit)
		(super doit:)
		(cond
			((and (& (gEgo onControl: 1) $0200) (== gEgoState 0))
				(self changeState: 1)
			)
			((and (== gEgoState 1003) (< 8 (++ drownCount)))
				(= drownCount 0)
				(gEgo setLoop: (+ (Random 0 1) (* 2 (< (gEgo y:) 107))))
			)
			((and (& (gEgo onControl:) $0002) (== gEgoState 0))
				(self changeState: 12)
			)
		)
	)

	(method (handleEvent event)
		(if (or (!= (event type:) evSAID) (event claimed:))
			(return)
		)
		(cond
			(
				(or
					(Said 'get,get/drink,drink,water')
					(Said 'drink,drink')
					(Said 'drink,drink/water')
				)
				(cond
					((TestFlag 6)
						(Print 520 0) ; "Your thirst is sufficiently quenched now, Patti."
					)
					((!= gEgoState 0)
						(NotNow) ; "Good idea. You might try that again later."
					)
					((not (& (gEgo onControl:) $0200))
						(NotClose) ; "You're not close enough."
					)
					(else
						(self changeState: 7)
					)
				)
			)
			((Said 'use,attach/bra')
				(cond
					((not (gEgo has: 16)) ; Bra
						(DontHave) ; "You don't have it."
					)
					((!= gEgoState 0)
						(NotNow) ; "Good idea. You might try that again later."
					)
					(else
						(Print 520 1) ; "You briefly consider using your bra to lower yourself over the cliff, but decide it's just too small to do any good. Perhaps it will be useful later."
					)
				)
			)
			((Said 'use/hose')
				(if (not (gEgo has: 15)) ; Pantyhose
					(DontHave) ; "You don't have it."
				else
					(Print 520 2) ; "A good idea; but how would you use them?"
				)
			)
			((Said 'drain,(off<get),(get<off)/hose')
				(cond
					((InRoom 15 484)
						(Print 520 3) ; "A good idea. How you wished you had worn yours when you left your apartment!"
					)
					((InRoom 15 -1)
						(DontHave) ; "You don't have it."
					)
					((TestFlag 72)
						(Print 520 4) ; "You already did. Now do something with it!"
					)
					((!= gEgoState 0)
						(NotNow) ; "Good idea. You might try that again later."
					)
					(else
						(self changeState: 15)
					)
				)
			)
			((Said '(drop<on),wear/hose')
				(cond
					((InRoom 15 484)
						(Print 520 3) ; "A good idea. How you wished you had worn yours when you left your apartment!"
					)
					((InRoom 15 -1)
						(DontHave) ; "You don't have it."
					)
					((!= gEgoState 0)
						(NotNow) ; "Good idea. You might try that again later."
					)
					((not (TestFlag 72))
						(Print 520 5) ; "You ARE wearing them!"
					)
					(else
						(Print 520 6) ; "O.K. They're on again. Now what?"
						(gGame changeScore: -15)
						(ClearFlag 72)
					)
				)
			)
			((Said 'attach/hose>')
				(cond
					((not (gEgo has: 15)) ; Pantyhose
						(Print 520 7) ; "A good idea, but you forgot to wear your pantyhose when you got dressed back at the casino."
					)
					((not (TestFlag 72))
						(Print 520 8) ; "You would, but you're still wearing them!"
					)
					((Said '//!*')
						(Print 520 9) ; "To what?"
					)
					((and (== (gGame parseLang:) 1) (not (Said '//boulder')))
						(Print 520 10) ; "That just won't work."
					)
					((!= gEgoState 0)
						(NotNow) ; "Good idea. You might try that again later."
					)
					((not (& (gEgo onControl:) $0010))
						(Print 520 11) ; "There IS a rock here that is suitable for your purposes; you are just unable to reach it from here."
					)
					(else
						(self changeState: 18)
					)
				)
				(event claimed: 1)
			)
			((Said 'look,look>')
				(cond
					((Said '/palm')
						(Print 520 12) ; "These trees bring back fond memories of your youth spent back on the plains of Mora, Minnesota."
					)
					((Said '/creek')
						(Print 520 13) ; "The river here sweeps down from the mountains, swiftly disappearing into the jungle ahead. Vicious rapids roil its surface."
					)
					((Said '/boulder,boob')
						(if (& (gEgo onControl:) $0010)
							(Print 520 14) ; "The rock near you has a cylindrical top, strongly resembling a boat tie down."
						else
							(Print 520 15) ; "The centuries of lava flows have left unusual rock formations everywhere on the island."
						)
					)
					((Said '/ledge,cliff,canyon')
						(Print 520 16) ; "It's a long way down from here! Evidently the bamboo forest was all uphill, as you are now considerably higher in altitude."
					)
					((Said '/cascade,cascade,water')
						(Print 520 17) ; "The river here boils and bubbles as it prepares to drop over the cliff and out of sight to the valley below."
						(Print 520 18 #at -1 144) ; "(You wonder why there are no souvenir stands here.)"
					)
					((Said '[/area]')
						(Print 520 19) ; "You are near the edge of a dramatic cliff. The river beside you hurls itself over the edge, forming a spectacular waterfall and disappearing into the canyon below."
					)
				)
			)
			((Said '(up<climb),climb/boulder,arch')
				(Print 520 20) ; "There is no way you could climb up that arch! It will never help you, Patti."
			)
			((or (Said '(climb,go)<(down,above)') (Said 'decrease/me'))
				(Print 520 21) ; "Yes, but how?"
			)
			((Said 'climb')
				(Print 520 22) ; "You MIGHT be able to climb down this cliff. Try moving closer to the edge."
				(Print 520 23 #at -1 144) ; "(Will you really "fall" for this old joke?)"
			)
			((Said 'pull,pull,grasp,get,get/farm,lasso,hemp')
				(Print 520 24) ; "The flowering vines are not sturdy enough to support you."
			)
			((Said 'get,get,use/palm')
				(Print 520 25) ; "The trees here are not close enough to the edge of the cliff to aid your descent."
			)
			((Said '/plant,bush')
				(Print 520 26) ; "The plants here are of no use to you."
			)
			((Said '/arch')
				(Print 520 27) ; "The arch is impossible to climb."
			)
			((Said '/flower')
				(Print 520 28) ; "The flowers are pretty, but unnecessary."
			)
			((Said 'jump')
				(Print 520 29) ; "It is unnecessary to jump off this cliff. Just walk a little closer to the edge."
			)
		)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0)
			(1
				(if (!= gEgoState 1003)
					(= gEgoState 1003)
					(gSoundFX stop:)
					(gMusic number: 6 loop: -1 play:)
				)
				(HandsOff)
				(gEgo
					view: 812
					setLoop: 0
					setStep: 1 3
					setCycle: Fwd
					setPri: 8
					illegalBits: 0
				)
				(if (> (gEgo y:) 137)
					(gEgo
						posn: 58 (gEgo y:)
						setMotion: MoveTo 58 137 self
					)
				else
					(gEgo posn: (- (gEgo x:) 20) (gEgo y:))
					(self cue:)
				)
			)
			(2
				(if (> (gEgo y:) 100)
					(gEgo setMotion: MoveTo 86 100 self)
				else
					(self cue:)
				)
			)
			(3
				(gEgo setMotion: MoveTo 105 83 self)
			)
			(4
				(= gEgoState 1001)
				(gSoundFX stop:)
				(gMusic number: 4 loop: 1 play:)
				(gEgo setPri: 2 setLoop: 2 setCel: 0 setCycle: End self)
			)
			(5
				(gEgo setStep: 1 8 setMotion: MoveTo (gEgo x:) 180 self)
			)
			(6
				(cls)
				(if gDebugging
					(NormalEgo)
					(= gEgoState 0)
					(gEgo posn: 178 100)
				else
					(gGame setScript: (ScriptID 40)) ; DyingScript
					((ScriptID 40) ; DyingScript
						caller: 522
						register: (Format @string 520 30) ; "Isn't it difficult to swim upstream... especially when upstream is uphill?%"
						next: (Format @string2 520 31) ; "You've found the FASTEST way down!%"
					)
				)
			)
			(7
				(HandsOff)
				(= gEgoState 3)
				(gEgo
					view: 511
					cycleSpeed: 2
					setLoop: 0
					cel: 0
					setCycle: End self
				)
			)
			(8
				(gEgo setLoop: 1 cel: 0 setCycle: Fwd)
				(= cycles (* 2 (gEgo cycleSpeed:) 4 (- (NumCels gEgo) 1)))
			)
			(9
				(gEgo setLoop: 0 setCel: 255 setCycle: Beg self)
			)
			(10
				(= seconds 3)
			)
			(11
				(gGame changeScore: 42)
				(SetFlag 6)
				(NormalEgo 1)
				(= gEgoState 0)
				(Print 520 32) ; "You find the stream's water remarkably refreshing, without a trace of caffeine."
			)
			(12
				(HandsOff)
				(Print (Format @string 520 33 global289) #at -1 10 #dispose) ; "%s"
				(= gEgoState 2)
				(gSoundFX stop:)
				(gMusic number: 4 loop: 1 play:)
				(gEgo
					view: 813
					setLoop: 0
					cel: 0
					illegalBits: 0
					ignoreActors:
					setPri: 2
					setCycle: End self
				)
			)
			(13
				(gEgo setStep: 1 8 setMotion: MoveTo (gEgo x:) 188 self)
				(if gDebugging
					(= state 5)
				)
			)
			(14
				(gCurRoom newRoom: 525)
			)
			(15
				(HandsOff)
				(Ok) ; "O.K."
				(gGame changeScore: 15)
				(SetFlag 72)
				(gEgo
					view: 521
					loop: 0
					cel: 0
					cycleSpeed: 1
					setCycle: End self
				)
			)
			(16
				(gEgo cel: 3 setCycle: Beg self)
			)
			(17
				(NormalEgo)
			)
			(18
				(HandsOff)
				(Ok) ; "O.K."
				(gGame changeScore: 40)
				(= gEgoState 13)
				(gEgo illegalBits: 0 setMotion: MoveTo 213 104 self)
			)
			(19
				(gEgo
					view: 521
					loop: 1
					cel: 0
					cycleSpeed: 1
					setPri: 10
					setCycle: End self
				)
			)
			(20
				(= cycles 11)
			)
			(21
				(gEgo loop: 2 cel: 0 setCycle: End self)
			)
			(22
				(= cycles 11)
			)
			(23
				(Print 520 34 #icon 15 0 0 #at -1 10) ; "You remove your pantyhose, tie one leg to the tip of the large rock, tie the other around your waist, then lower yourself carefully over the edge of the cliff."
				(gEgo setLoop: 3 cel: 0 posn: 212 71 setCycle: End self)
			)
			(24
				(gEgo setPri: 2)
				(= cycles 5)
			)
			(25
				(gEgo
					setStep: 1 1
					setMotion: MoveTo (gEgo x:) (+ 30 (gEgo y:)) self
				)
			)
			(26
				(Print 520 35 #at -1 10) ; "You hope these are "support" hose!"
				(gCurRoom newRoom: 525)
			)
		)
	)
)

(instance aRock1 of Prop
	(properties
		y 160
		x -18
		view 520
		cycleSpeed 1
	)

	(method (init)
		(super init:)
		(self setCycle: Fwd isExtra: 1 ignoreActors:)
	)
)

(instance aRock2 of Prop
	(properties
		y 187
		x 56
		view 520
		loop 1
		cel 1
		cycleSpeed 1
	)

	(method (init)
		(super init:)
		(self setCycle: Fwd isExtra: 1 ignoreActors:)
	)
)

(instance aRock3 of Prop
	(properties
		y 179
		x 37
		view 520
		loop 1
		cycleSpeed 1
	)

	(method (init)
		(super init:)
		(self setCycle: Fwd isExtra: 1 ignoreActors:)
	)
)

(instance aRock4 of Prop
	(properties
		y 118
		x -5
		view 520
		loop 2
		cycleSpeed 1
	)

	(method (init)
		(super init:)
		(self setCycle: Fwd isExtra: 1 ignoreActors:)
	)
)

(instance aRock5 of Prop
	(properties
		y 176
		x 12
		view 520
		loop 2
		cel 1
		cycleSpeed 1
	)

	(method (init)
		(super init:)
		(self setCycle: Fwd isExtra: 1 ignoreActors:)
	)
)

