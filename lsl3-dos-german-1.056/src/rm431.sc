;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 431)
(include sci.sh)
(use Main)
(use n021)
(use Interface)
(use FileSelector)
(use Jump)
(use Motion)
(use Game)
(use Inventory)
(use User)
(use Actor)
(use System)

(public
	rm431 0
)

(local
	[local0 6]
	[local6 6]
	[local12 9] = [999 113 127 141 155 169 183 197 999]
	[local21 120]
	[local141 66]
)

(instance rm431 of Rm
	(properties
		picture 430
		horizon 1
	)

	(method (init &tmp i)
		(Load rsSOUND 10)
		(Load rsSOUND 433)
		(Load rsSOUND 432)
		(Load rsSCRIPT 991)
		(Load rsPIC 99)
		(Load rsFONT 7)
		(super init:)
		(self setScript: RoomScript)
		(aCurtain ignoreActors: init:)
		(aActor1 ignoreActors: init:)
		(aActor2 ignoreActors: init:)
		(aActor3 ignoreActors: init:)
		(aActor4 ignoreActors: init:)
		(aActor5 ignoreActors: init:)
		(= gOldGameSpeed (gGame setSpeed: 6))
		(= [local0 1] aActor1)
		(= [local0 2] aActor2)
		(= [local0 3] aActor3)
		(= [local0 4] aActor4)
		(= [local0 5] aActor5)
		(= [local6 1] aActor1)
		(= [local6 2] aActor2)
		(= [local6 3] aActor3)
		(= [local6 4] aActor4)
		(= [local6 5] aActor5)
		(NormalEgo)
		(gEgo
			view: 431
			setLoop: 0
			setCycle: Walk
			setStep: 2 1
			setCycle: Walk
			setPri: 1
			posn: 16 75
			ignoreActors:
			init:
		)
		(HandsOff)
		(RoomScript changeState: 1)
	)
)

(instance RoomScript of Script
	(properties)

	(method (doit &tmp i)
		(super doit:)
		(if (and (== -1 (gMusic prevSignal:)) (== (gMusic number:) 432))
			(self changeState: 22)
		)
		(if (== gEgoState 431)
			(cond
				((& (gEgo onControl: 1) $0002)
					(= i 1)
				)
				((& (gEgo onControl: 1) $0004)
					(= i 2)
				)
				((& (gEgo onControl: 1) $0008)
					(= i 3)
				)
				((& (gEgo onControl: 1) $0010)
					(= i 4)
				)
				((& (gEgo onControl: 1) $0020)
					(= i 5)
				)
				((& (gEgo onControl: 1) $0040)
					(= i 6)
				)
				(else
					(= i 0)
				)
			)
			(gEgo setLoop: i)
			(if (< gMachineSpeed 39)
				(return)
			)
			(aSpotlight posn: [local12 i] 52 setCel: i)
			(aFloor posn: [local12 i] 97 setCel: i)
		)
	)

	(method (handleEvent event)
		(if (or (!= (event type:) evSAID) (event claimed:))
			(return)
		)
		(cond
			((or (Said '/strip,dance,dance') (Said 'strip,dance,dance'))
				(self changeState: 15)
			)
			((Said 'talk,talk')
				(Print 431 0) ; "You begin, "Unaccustomed as I am to public speaking...""
				(Print 431 1) ; "The crowd roars its disapproval. They're not hear for a lecture, Larry. This is show biz!"
			)
			(
				(and
					(Said 'look,look>')
					(Said '[/area,backstage,couple,man,woman]')
				)
				(Print 431 2) ; "You are all alone on a large stage and runway, surrounded by men who expected to see a beautiful woman."
				(Print 431 3 #at -1 144) ; "(Now you understand the term "flop sweat!")"
			)
		)
	)

	(method (changeState newState &tmp i)
		(ShowState self newState 1 12)
		(switch (= state newState)
			(0)
			(1
				(Print 431 4 #at 10 5 #width 290) ; "The announcer's voice booms over the public address system, "And now, lady and gentlemen, the moment you've all been waiting for: the star of our show, Miss Cherri Tart!""
				(aCurtain setCycle: End self)
				(= seconds 3)
			)
			(2)
			(3
				(aCurtain stopUpd:)
				(Print (Format @local21 431 5 global304 global305) #font 7) ; ""%s"%"
				(Print 431 6) ; "You scream, "People! Hundreds of people! And every one of them staring at me!!""
				(Print 431 7) ; "You're caught, Larry! And redhanded, too! And, wearing Cherri's costume too!!"
				(= seconds 3)
			)
			(4
				(Print 431 8 #at 10 5 #width 290) ; "Lady and gentlemen, the star of our show, Miss Cherri Tart!"
				(Print 431 9) ; "In your hurry to dress in the darkness backstage, you must have grabbed the wrong clothes!"
				(Print 431 10 #at -1 144) ; "(So THAT'S why your underwear was such a tight fit!)"
				(= seconds 3)
			)
			(5
				(Print 431 11 #at -1 10) ; "Our star, Cherri Tart!"
				(= seconds 3)
			)
			(6
				(Print 431 12 #at -1 10) ; "CHERRI!"
				(Print 431 13) ; "You walk to the beginning of the runway."
				(gEgo setPri: -1 setMotion: MoveTo 36 95 self)
			)
			(7
				(Print 431 14) ; "Well, Larry, you've done it again! Now what are you going to do?"
				(= gEgoState 432)
				(User canInput: 1)
				(gMusic stop:)
				(gEgo cel: 0)
				(aCurtain setCycle: Beg self)
			)
			(8
				(aCurtain stopUpd:)
				(= seconds 3)
			)
			(9
				(Print 431 15 #at 10 5 #width 290) ; "You are mortified! How you wish you had paid more attention when your mother enrolled you in that pre-school ballet and gymnastics class!"
				(= seconds 10)
			)
			(10
				(gMusic number: 433 loop: -1 play:)
				(Print 431 16 #at -1 10) ; "Boo."
				(Print 431 17 #at -1 144) ; "Hiss."
				(Print 431 18) ; "Move it or lose it!"
				(= seconds 3)
			)
			(11
				(Print 431 19 #at -1 10) ; "Get off the stage!"
				(Print 431 20 #at -1 144) ; "Who's got the tomatoes?"
				(= cycles (Random 2 8))
			)
			(12
				(HandsOff)
				(for ((= i 1)) (<= i 5) ((++ i))
					([local6 i]
						view: 430
						setCycle: Fwd
						setStep: 6 6
						setScript: (VeggieScript new:)
					)
				)
				(= seconds 8)
			)
			(13
				(Print 431 21 #dispose #at 10 5 #width 290) ; "Too bad, Larry. You feel you could die of embarrassment."
				(= seconds 3)
			)
			(14
				(cls)
				(for ((= i 1)) (<= i 5) ((++ i))
					(([local6 i] script:) changeState: 2)
				)
				(gGame setScript: (ScriptID 40)) ; DyingScript
				((ScriptID 40) ; DyingScript
					caller: 437
					register: (Format @local21 431 22) ; "In fact, just for purposes of argument, you ARE dead of embarrassment!%"
					next: (Format @local141 431 23) ; ""Feets don't fail me now!"%"
				)
			)
			(15
				(= gEgoState 431)
				(HandsOff)
				(Ok) ; "O.K."
				(gGame changeScore: 43)
				(Print 431 24 #at 10 5 #width 290) ; "Summoning up all your courage, you begin to wiggle your way down the runway."
				(aSpotlight setLoop: 5 setPri: 14 ignoreActors: init:)
				(aFloor setLoop: 6 setPri: 7 ignoreActors: init:)
				(gEgo setMotion: MoveTo [local12 6] 95 self)
				(= cycles 4)
			)
			(16
				(gMusic number: 432 loop: 1 play: self)
			)
			(17
				(gEgo setMotion: MoveTo [local12 1] 95 self)
			)
			(18
				(Print 431 25 #at 10 5 #width 290 #dispose) ; "The audience must also appreciate your talents as they begin to throw dollar bills -- at you!"
				([local0 1] setScript: (MoneyScript new:))
				(gEgo setMotion: MoveTo [local12 3] 95 self)
			)
			(19
				([local0 2] setScript: (MoneyScript new:))
				([local0 3] setScript: (MoneyScript new:))
				(gEgo setStep: 1 1 setMotion: MoveTo [local12 6] 95 self)
			)
			(20
				(cls)
				(Print 431 26 #at 10 5 #width 290 #time (LangSwitch 6 6 12 12) #dispose) ; "Look, Larry! They're all throwing money at you. They like you! They REALLY like you!!"
				([local0 4] setScript: (MoneyScript new:))
				([local0 5] setScript: (MoneyScript new:))
				(= register 0)
				(self cue:)
			)
			(21
				(gEgo
					setMotion: MoveTo (Random [local12 1] [local12 6]) 95 self
				)
				(if (>= (/ gMachineSpeed 10) (++ register))
					(-- state)
				)
			)
			(22
				(gMusic loop: 1 play:)
				(gCurRoom drawPic: 99 6)
				(gCast eachElementDo: #hide)
				(for ((= i 1)) (<= i 5) ((++ i))
					(([local0 i] script:) changeState: 2)
				)
				(= cycles 20)
			)
			(23
				(gMusic fade:)
				(cls)
				(Print 431 27) ; "Time passes."
				(Print 431 28) ; "Time in which you dance and dance, meanwhile picking up many, many one-dollar bills."
				(Print 431 29) ; "You dance until your legs just can't take it any longer!"
				(Print 431 30 #at 10 144 #width 290) ; "(Which isn't really that long considering you are wearing a pair of high heels three sizes too small!)"
				(Load rsVIEW 708)
				(= gNormalEgoView 708)
				(= gEgoState 11)
				(= gShowroomState 5)
				(= gDollars 500)
				(Format ((Inv at: 6) name:) 431 31) ; "500 Dollar Bills%", A_Twenty_Dollar_Bill
				((Inv at: 6) view: 24) ; A_Twenty_Dollar_Bill
				(gEgo get: 6) ; A_Twenty_Dollar_Bill
				(gGame setSpeed: gOldGameSpeed)
				(gCurRoom newRoom: 420)
			)
		)
	)
)

(instance aActor1 of Act
	(properties)
)

(instance aActor2 of Act
	(properties)
)

(instance aActor3 of Act
	(properties)
)

(instance aActor4 of Act
	(properties)
)

(instance aActor5 of Act
	(properties)
)

(instance aSpotlight of Prop
	(properties
		y 999
		x 999
		view 430
	)
)

(instance aFloor of Prop
	(properties
		y 999
		x 999
		view 430
	)
)

(instance aCurtain of Prop
	(properties
		y 63
		x 15
		view 430
		cycleSpeed 1
	)

	(method (init)
		(super init:)
		(self setPri: 2 ignoreActors: stopUpd:)
	)
)

(instance VeggieScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= cycles (Random 1 9))
			)
			(1
				(client
					setLoop: (Random 8 9)
					posn: (Random 8 290) (Random 144 157)
					setMotion:
						JumpTo
						(gEgo x:)
						(- (gEgo y:) (Random 0 33))
						self
				)
				(-- state)
			)
			(2
				(client dispose:)
				(self dispose:)
			)
		)
	)
)

(instance MoneyScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(client view: 430 setLoop: 7 setCycle: Fwd setStep: 7 7)
				(= cycles (Random 1 9))
			)
			(1
				(client
					posn: (Random 8 290) (Random 144 157)
					setMotion:
						JumpTo
						(gEgo x:)
						(- (gEgo y:) (Random 0 33))
						self
				)
				(-- state)
			)
			(2
				(client dispose:)
				(self dispose:)
			)
		)
	)
)

