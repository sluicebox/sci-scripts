;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 540)
(include sci.sh)
(use Main)
(use Interface)
(use LoadMany)
(use Wander)
(use Jump)
(use Motion)
(use Game)
(use Inventory)
(use Actor)
(use System)

(public
	rm540 0
)

(local
	local0
	local1
	seenMsg
	[string 33]
	[string2 22]
)

(instance rm540 of Rm
	(properties
		picture 540
		horizon 78
		north 550
		south 530
	)

	(method (init)
		(super init:)
		(self setScript: RoomScript)
		(if (== gPrevRoomNum 550)
			(gEgo posn: 233 80)
		else
			(gEgo posn: 233 188)
		)
		(if (not (TestFlag 68))
			(Load rsVIEW 541)
			(Load rsVIEW 542)
			(Load rsVIEW 543)
			(Load rsSCRIPT 991)
			(Load rsSCRIPT 970)
			(Load rsSOUND 540)
			(Load rsSOUND 541)
			(Load rsSOUND 12)
			(Load rsSOUND 561)
			(Load rsSOUND 530)
			(aPig init:)
			(aBra init:)
		)
		(= gNormalEgoView 803)
		((Inv at: 17) view: 31) ; Dress
		(= gEgoState 0)
		(NormalEgo 3)
		(gEgo init:)
	)

	(method (newRoom newRoomNumber)
		(super newRoom: newRoomNumber)
		(LoadMany 0 970)
	)
)

(instance RoomScript of Script
	(properties)

	(method (doit)
		(super doit:)
		(if
			(and
				(== state 7)
				(== 541 (gEgo view:))
				(== 2 (gEgo loop:))
				(== 1 (gEgo cel:))
			)
			(gSoundFX number: 530 loop: 1 play:)
		)
	)

	(method (handleEvent event)
		(if (or (!= (event type:) evSAID) (event claimed:))
			(return)
		)
		(cond
			((Said 'use/bra,coconut')
				(Print 540 0) ; "That's an idea. The question is: "How?""
			)
			((Said 'use/marker')
				(Print 540 1) ; "The feral pig is unfamiliar with magic."
			)
			((and (gEgo has: 12) (Said '/key')) ; Penthouse_Key
				(Print 540 2) ; "Your key will not help you, Patti."
			)
			((Said 'climb/palm')
				(Print 540 3) ; "No matter which tree you climb it won't do you any good!"
			)
			((Said '(drop<on),wear/bra')
				(cond
					((InRoom 16 484)
						(Print 540 4) ; "A good idea. How you wished you had worn yours when you left your apartment!"
					)
					((InRoom 16 -1)
						(DontHave) ; "You don't have it."
					)
					((!= gEgoState 0)
						(NotNow) ; "Good idea. You might try that again later."
					)
					((not local0)
						(Print 540 5) ; "You ARE wearing it!"
					)
					(local1
						(Print 540 6) ; "First, get those coconuts out of there!"
					)
					(else
						(self changeState: 3)
					)
				)
			)
			((Said 'drain,(off<get),(get<off)/bra')
				(cond
					((InRoom 16 484)
						(Print 540 4) ; "A good idea. How you wished you had worn yours when you left your apartment!"
					)
					((InRoom 16 -1)
						(DontHave) ; "You don't have it."
					)
					(local0
						(Print 540 7) ; "You already did. Now do something with it!"
					)
					((!= gEgoState 0)
						(NotNow) ; "Good idea. You might try that again later."
					)
					(else
						(self changeState: 1)
					)
				)
			)
			((and local1 (Said 'drain,(out<get),(get<out)/coconut'))
				(Print 540 8) ; "O.K. You remove the coconuts from your brassiere. Now what?"
				(= local1 0)
				(gGame changeScore: -45)
			)
			((Said 'drop/coconut/bra')
				(cond
					((not (gEgo has: 16)) ; Bra
						(Print 540 9) ; "You're not wearing your bra."
					)
					((not (gEgo has: 19)) ; Coconuts
						(Print 540 10) ; "You have no nuts, Patti!"
						(if (>= gFilthLevel 3)
							(Print 540 11 #at -1 144) ; "(After all, you are a woman!)"
						)
					)
					((!= gEgoState 0)
						(NotNow) ; "Good idea. You might try that again later."
					)
					((not local0)
						(Print 540 12) ; "Nah! Sierra made me promise not to do any more Dolly Parton jokes!"
						(Print 540 13 #at -1 144) ; "(Better take it off first!)"
					)
					(local1
						(Print 540 14) ; "You've already loaded that thing enough!"
					)
					(else
						(self changeState: 5)
					)
				)
			)
			(
				(or
					(Said 'use/bra/throw')
					(Said 'throw/coconut/animal')
					(Said 'throw/bra')
				)
				(cond
					((InRoom 16 484)
						(Print 540 4) ; "A good idea. How you wished you had worn yours when you left your apartment!"
					)
					((not (gEgo has: 16)) ; Bra
						(DontHave) ; "You don't have it."
					)
					((not local0)
						(Print 540 15) ; "You would, but you're still in it!"
					)
					((!= gEgoState 0)
						(NotNow) ; "Good idea. You might try that again later."
					)
					((!= (PigScript state:) 2)
						(Print 540 16) ; "Good idea, but there is nothing at which to throw."
					)
					(else
						(self changeState: 7)
					)
				)
			)
			((Said 'throw/coconut')
				(if (gEgo has: 19) ; Coconuts
					(Print 540 17) ; "You are not strong enough to hurl a coconut with enough velocity to stop one of Nontoonyt's feral pigs!"
				else
					(Print 540 10) ; "You have no nuts, Patti!"
					(if (> gFilthLevel 1)
						(Print 540 18 #at -1 144) ; "(Grin.)"
					)
				)
			)
			((Said 'throw>')
				(cond
					((Said '[/!*]')
						(Print 540 19) ; "What did you wish to throw?"
					)
					((Said '/*[/!*]')
						(Print 540 20) ; "At what?"
					)
				)
			)
			((Said 'climb,crawl')
				(Print 540 21) ; "There's no way around or under or over this problem. You must eliminate that boar!"
			)
			((Said 'look>')
				(cond
					((Said '/creek')
						(Print 540 22) ; "You feel that the river is somehow a key to your success."
					)
					((Said '[/area]')
						(Print 540 23) ; "In the distance a river runs downhill."
						(Print 540 24 #at -1 144) ; "(You expected maybe, uphill?)"
					)
				)
			)
		)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0)
			(1
				(HandsOff)
				(gGame changeScore: 5)
				(Ok) ; "O.K."
				(gEgo
					view: 541
					setLoop: 0
					cel: 0
					illegalBits: 0
					cycleSpeed: 1
					setCycle: End self
				)
			)
			(2
				(Print 540 25 #at -1 10) ; "Ahh! That feels better."
				(= local0 1)
				(NormalEgo 3)
			)
			(3
				(HandsOff)
				(gGame changeScore: -5)
				(Ok) ; "O.K."
				(gEgo
					view: 541
					setLoop: 0
					setCel: 255
					illegalBits: 0
					cycleSpeed: 1
					setCycle: Beg self
				)
			)
			(4
				(Print 540 26) ; "O.K. It's on. Now what?"
				(NormalEgo 3)
				(= local0 0)
			)
			(5
				(HandsOff)
				(gGame changeScore: 45)
				(Ok) ; "O.K."
				(gEgo
					view: 541
					setLoop: 1
					cel: 0
					illegalBits: 0
					cycleSpeed: 1
					setCycle: End self
				)
			)
			(6
				(Print 540 27) ; "Good idea, Patti! You are now holding a bra containing a pair of heavy coconuts."
				(= local1 1)
				(NormalEgo 3)
				(Print 540 28 #at -1 144) ; "(Now what?)"
			)
			(7
				(HandsOff)
				(Ok) ; "O.K."
				(= local0 0)
				(gMusic stop:)
				(= gOldGameSpeed (gGame setSpeed: 6))
				(= gEgoState 540)
				(gEgo
					view: 541
					setLoop: 2
					illegalBits: 0
					cel: 0
					setCycle: Fwd
				)
				(= cycles (* 5 (- (NumCels gEgo) 1)))
			)
			(8
				(NormalEgo 3)
				(HandsOff)
				(aBra
					ignoreHorizon:
					posn: (+ (gEgo x:) 23) (- (gEgo y:) 43)
					setLoop: 3
					setCycle: Fwd
					setStep: 8 8
					setMotion: JumpTo (- (aPig x:) 2) (- (aPig y:) 13) self
				)
				(PigScript changeState: 9)
			)
			(9
				(PigScript cue:)
				(aBra dispose:)
				(if local1
					(gEgo put: 16 -1 put: 19 -1) ; Bra, Coconuts
					(self changeState: 11)
				else
					(= seconds 3)
				)
			)
			(10
				(Print 540 29) ; "Unfortunately, Patti, the pig refuses to wear your bra. Really! Attacking a pig with just a bra? You must be nuts!"
				(gGame setScript: (ScriptID 40)) ; DyingScript
				((ScriptID 40) ; DyingScript
					caller: 543
					register: (Format @string 540 30) ; "That pig has really got you up a tree, Patti."
					next: (Format @string2 540 31) ; "How boaring..."
				)
			)
			(11
				(= seconds 3)
			)
			(12
				(Print 540 32 #at -1 10) ; "You did it, Patti! Your 36C bolas has done its duty."
				(NormalEgo 3)
				(Print 540 33 #at -1 144) ; "(But have you noticed how you're running dangerously low on clothing?)"
				(gMusic number: 599 loop: gBgMusicLoops play:)
				(SetFlag 68)
				(gGame changeScore: 100)
				(gGame setSpeed: gOldGameSpeed)
			)
		)
	)
)

(instance aBra of Act
	(properties
		y 999
		x 999
		view 541
		illegalBits 0
	)
)

(instance aPig of Act
	(properties
		y 111
		x 288
		view 540
		illegalBits 0
	)

	(method (init)
		(super init:)
		(self
			ignoreHorizon:
			setLoop: 0
			setPri: 1
			setCycle: Fwd
			setStep: 4 4
			setScript: PigScript
		)
	)
)

(instance PigScript of Script
	(properties)

	(method (doit)
		(super doit:)
		(cond
			((== gEgoState 540))
			((and (< state 4) (& (gEgo onControl:) $0002))
				(self changeState: 4)
			)
			(
				(and
					(& (gEgo onControl: 1) $0010)
					(or (== state 1) (== state 2))
				)
				(self changeState: 3)
			)
			(
				(and
					(& (gEgo onControl: 1) $0004)
					(or (== state 0) (== state 3))
				)
				(self changeState: 1)
			)
		)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0)
			(1
				(gMusic number: 540 loop: -1 play:)
				(aPig setMotion: MoveTo 216 97 self)
			)
			(2
				(if (not seenMsg)
					(= seenMsg 1)
					(Print 540 34 #at 10 5 #width 290) ; "Patty, look out!! It's one of Nontoonyt Island's rare feral pigs, exercising his territorial rights -- right at you!"
				)
				(aPig illegalBits: -3 setMotion: Wander setPri: -1 setStep: 2 2)
			)
			(3
				(gMusic fade:)
				(aPig illegalBits: 0 setPri: 1 setMotion: MoveTo 288 111 self)
				(= state -1)
			)
			(4
				(= gEgoState 1001)
				(HandsOff)
				(Print 540 35 #at -1 10) ; "LOOK OUT!!"
				(gSoundFX stop:)
				(gMusic number: 541 loop: 1 play:)
				(aPig
					illegalBits: 0
					ignoreActors:
					setPri: -1
					setLoop: 1
					setCel: 0
					setCycle: End
					setStep: 4 10
					setMotion:
						MoveTo
						(- (aPig x:) (/ (- (aPig x:) (gEgo x:)) 2))
						-10
						self
				)
			)
			(5
				(aPig
					setLoop: 2
					setCycle: Fwd
					setMotion: MoveTo (gEgo x:) (- (gEgo y:) 40) self
				)
			)
			(6
				(gMusic number: 12 loop: 1 play:)
				(gEgo view: 542 cel: 0 setCycle: End)
				(aPig setMotion: MoveTo (gEgo x:) (gEgo y:) self)
			)
			(7
				(gEgo stopUpd:)
				(aPig setLoop: 0 setCycle: Fwd)
				(= seconds 3)
			)
			(8
				(if (>= gFilthLevel 3)
					(Print 540 36 #at -1 10) ; "Once again, Patti, you find yourself being porked!"
					(Print 540 37 #at -1 144) ; "...an experience not wholly unfamiliar to you!"
				else
					(Print 540 38 #at -1 10) ; "From the looks of things, Patti..."
					(Print 540 39 #at -1 10) ; "..."That's All, Folks!\05""
				)
				(gGame setScript: (ScriptID 40)) ; DyingScript
				((ScriptID 40) ; DyingScript
					caller: 543
					register: (Format @string 540 40) ; "Are you sure Oscar Mayer\05 started like this?"
					next: (Format @string2 540 41) ; "Busted flat again"
				)
			)
			(9
				(aPig setMotion: 0)
			)
			(10
				(gMusic stop:)
				(if local1
					(gSoundFX number: 12 loop: 1 play:)
					(aPig
						illegalBits: 0
						setLoop: 3
						cel: 0
						setStep: 4 4
						setCycle: End
						setMotion: JumpTo 225 69 self
					)
				else
					(self changeState: 1)
				)
			)
			(11
				(gSoundFX number: 561 loop: 1 play:)
				(aPig setLoop: 4 cel: 0 setCycle: End self)
			)
			(12
				(RoomScript changeState: 11)
				(aPig setScript: 0 dispose:)
			)
		)
	)

	(method (handleEvent event)
		(cond
			((Said '//animal>')
				(cond
					((> (aPig x:) 275)
						(Print 540 42) ; "Where?"
						(event claimed: 1)
					)
					((Said 'throw/*>')
						(if (Said '/bra')
							(event claimed: 0)
						else
							(Print 540 43) ; "That wouldn't have any effect on this wild boar!"
							(event claimed: 1)
						)
					)
					(else
						(Print 540 44) ; "The feral pig just grunts and snorts, laughing at your attempts to pass."
						(event claimed: 1)
					)
				)
			)
			((Said '/animal>')
				(cond
					((> (aPig x:) 280)
						(Print 540 42) ; "Where?"
						(event claimed: 1)
					)
					((Said 'feed/')
						(Print 540 45) ; "The only thing he's interested in eating is you, Patti!"
					)
					((Said 'hit,cut/')
						(Print 540 46) ; "You would love to, but you just can't reach the pig from here."
					)
					((Said 'talk')
						(Print 540 47) ; "As much as the feral pig would like to carry on a conversation."
					)
					((Said 'look/')
						(Print 540 48) ; "A feral pig is successfully preventing you from proceeding. He looks mean! You'd better not get too close, Patti."
					)
					(else
						(Print 540 49) ; "The feral pig just grunts and snorts."
						(event claimed: 1)
					)
				)
			)
		)
	)
)

