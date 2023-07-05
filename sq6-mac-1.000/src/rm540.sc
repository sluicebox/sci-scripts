;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 540)
(include sci.sh)
(use Main)
(use SQRoom)
(use SQNarrator)
(use Talker)
(use Osc)
(use RandCycle)
(use Motion)
(use Actor)
(use System)

(public
	rm540 0
	Dr_Beleauxs 1
	Stellar 3
	Roger 4
)

(local
	local0
	local1 = 1
	local2 = 2
	local3 = 3
	local4
)

(instance rm540 of SQRoom
	(properties
		picture 534
	)

	(method (init)
		(= local4 (gGSound1 vol:))
		(self setScript: gameEnding)
		(gGame handsOff:)
		(noseFlash init:)
		(flashRight init:)
		(flashLeft init:)
		(reflect init: hide:)
		(window2 init: hide:)
		(dr init: hide:)
		(drEye init: hide:)
		(drArm init: hide:)
		(rogMouth init: hide:)
		(rogEyes init: hide: setScript: sBlinkRog)
		(stellerMouth init: hide:)
		(stellerEyes init: hide: setScript: sBlinkSteller)
		(super init:)
	)
)

(instance Dr_Beleauxs of SmallTalker
	(properties
		name {Dr Beleauxs}
		talkView 532
		showTalk 0
	)

	(method (init)
		(= client dr)
		(super init:)
	)
)

(instance gameEnding of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(Load 140 605) ; WAVE
				(= ticks 20)
			)
			(1
				(noseFlash
					setCel: 0
					cycleSpeed: (proc0_8 2 5)
					show:
					setCycle: End self
				)
			)
			(2
				(++ local0)
				(= ticks (proc0_8 5 50))
			)
			(3
				(noseFlash hide:)
				(if (== local0 8)
					(gCurRoom style: 0)
					(gCurRoom exitStyle: 0)
					(= ticks 1)
				else
					(self changeState: (- state 2))
				)
			)
			(4
				(flashLeft hide:)
				(flashRight hide:)
				(noseFlash hide:)
				(gCurRoom picture: 535 drawPic: 535)
				(dr view: 5340 setLoop: 1 setCel: 0 show: posn: 43 139)
				(= ticks 50)
			)
			(5
				(drEye
					view: 5340
					setLoop: 0
					setCel: 0
					cycleSpeed: 14
					posn: 76 69
					setPri: 400
					show:
					setCycle: End self
				)
			)
			(6
				(drEye hide:)
				(dr cycleSpeed: 10 setCycle: End self)
			)
			(7
				(dr hide:)
				(gCurRoom picture: 536 drawPic: 536)
				(= local0 0)
				(noseFlash
					view: 5360
					setLoop: 0
					setCel: 0
					posn: 152 58
					show:
					setCycle: End self
				)
			)
			(8
				(noseFlash show: setCycle: End self)
			)
			(9
				(= ticks (proc0_8 5 50))
			)
			(10
				(++ local0)
				(noseFlash cycleSpeed: (proc0_8 2 5) setCel: 0 hide:)
				(if (== local0 7)
					(= ticks 1)
				else
					(self changeState: (- state 2))
				)
			)
			(11
				(gCurRoom picture: 537 drawPic: 537)
				(noseFlash
					view: 5371
					posn: 157 43
					show:
					setLoop: 0
					setPri: 300
					cycleSpeed: 13
					setCycle: Fwd
				)
				(dr
					view: 5371
					show:
					cycleSpeed: 11
					setLoop: 1
					setCel: 0
					posn: 57 145
					setCycle: End self
				)
			)
			(12
				(dr hide:)
				(gCurRoom picture: 538 drawPic: 538)
				(noseFlash hide:)
				(flashRight
					view: 538
					posn: 277 39
					setLoop: 0
					setCel: 0
					setCycle: RandCycle
				)
				(drEye
					view: 538
					show:
					setLoop: 1
					setCel: 0
					posn: 93 37
					setPri: 400
					cycleSpeed: 7
					setCycle: End self
				)
			)
			(13
				(= ticks 40)
			)
			(14
				(drEye setCel: 0 cycleSpeed: 7 setCycle: End self)
			)
			(15
				(drEye hide:)
				(drArm
					view: 538
					show:
					cycleSpeed: 7
					setLoop: 2
					setCel: 0
					posn: 69 139
					setCycle: CT 6 1 self
				)
			)
			(16
				(= ticks 10)
			)
			(17
				(drArm cycleSpeed: 11 setCycle: End self)
			)
			(18
				(gGSound1 number: 609 setLoop: -1 play:)
				(gGSound2 number: 605 setLoop: 0 play:)
				(noseFlash
					setCel: 0
					setLoop: 3
					posn: 93 37
					view: 538
					show:
					cycleSpeed: 9
					setCycle: End self
				)
			)
			(19
				(gMessager say: 0 0 1 2 self) ; "Nice shot!"
			)
			(20
				(gCurRoom picture: 539 drawPic: 539)
				(drArm hide:)
				(drEye setCel: 0 setLoop: 0 view: 539 show: posn: 81 81)
				(noseFlash
					setLoop: 1
					setCel: 0
					posn: 217 41
					view: 539
					show:
					cycleSpeed: 23
					setCycle: End
				)
				(= ticks 70)
			)
			(21
				(drEye cycleSpeed: 12 setCycle: End self)
			)
			(22
				(gMessager say: 0 0 1 1 self) ; "Oh, there you are, Wilco."
			)
			(23
				(gGSound1 fade: 0 3 1 0)
				(proc0_7 1 1 self)
			)
			(24
				(window2 show:)
				(gGSound1 number: 541 setVol: local4 play:)
				(noseFlash hide:)
				(flashRight hide:)
				(flashLeft hide:)
				(dr hide:)
				(drEye hide:)
				(drArm hide:)
				(gCurRoom picture: 540 drawPic: 540)
				(proc0_7 0 1 self)
			)
			(25
				(= ticks 400)
			)
			(26
				(window2 hide:)
				(reflect show:)
				(rogMouth show:)
				(rogEyes show:)
				(stellerMouth show:)
				(stellerEyes show:)
				(gCurRoom picture: 542 drawPic: 542)
				(= ticks 60)
			)
			(27
				(rogEyes setLoop: local2)
				(stellerEyes setLoop: local1)
				(gMessager say: 0 0 1 1 self 950) ; "Boy, Stellar, with all that's happened recently, I never would have imagined that we'd be standing here together."
			)
			(28
				(rogEyes setLoop: local2)
				(stellerEyes setLoop: local3)
				(gMessager say: 0 0 1 2 self 950) ; "It is a miracle, Roger. I was afraid that by the time you got my message it would be too late. I was certain I was doomed, but you didn't let me down."
			)
			(29
				(rogEyes setLoop: local2)
				(stellerEyes setLoop: local2)
				(gMessager say: 0 0 1 3 self 950) ; "What you did was incredibly brave, Roger, not to mention intensely risky. It took Dr. Beleauxs a lot of work to clean up after you and Sharpei."
			)
			(30
				(rogEyes setLoop: local2)
				(stellerEyes setLoop: local2)
				(gMessager say: 0 0 1 4 self 950) ; "I must say, Roger, there's not a man in the universe who knows me inside the way you do."
			)
			(31
				(rogEyes setLoop: local1)
				(stellerEyes setLoop: local2)
				(gMessager say: 0 0 1 5 self 950) ; "It was a strange feeling, but I went in there all business. There wasn't a moment I wasn't thinking of your welfare."
			)
			(32
				(rogEyes setLoop: local1)
				(stellerEyes setLoop: local1)
				(gMessager say: 0 0 1 6 self 950) ; "Oh, give me a break. Let me put my boots on. It's getting deep in here."
			)
			(33
				(rogEyes setLoop: local1)
				(stellerEyes setLoop: local3)
				(gMessager say: 0 0 1 7 self 950) ; "Cheese it, Pal, or I'll rip out your larynx and you won't be able to get a job doing bad voice-over work for Chinese action pictures!"
			)
			(34
				(rogEyes setLoop: local1)
				(stellerEyes setLoop: local3)
				(gMessager say: 0 0 1 8 self 950) ; "What did you say, Roger?"
			)
			(35
				(rogEyes setLoop: local2)
				(stellerEyes setLoop: local3)
				(gMessager say: 0 0 1 9 self 950) ; "Oh, uh, I was just mumbling to myself. You know, Stellar, there was one thing I noticed while inside you that I thought I might share."
			)
			(36
				(rogEyes setLoop: local2)
				(stellerEyes setLoop: local2)
				(gMessager say: 0 0 1 10 self 950) ; "And what's that, Roger?"
			)
			(37
				(rogEyes setLoop: local2)
				(stellerEyes setLoop: local1)
				(gMessager say: 0 0 1 11 self 950) ; "You eat like a goat! You really have to change your eating habits, Stellar. I saw some things in your digestive tract that I wouldn't wish on Sludge Vohaul. You really have to clean up your consumption act."
			)
			(38
				(rogEyes setLoop: local2)
				(stellerEyes setLoop: local1)
				(gMessager say: 0 0 1 12 self 950) ; "Yes, I know, I know. Dr. Beleauxs said he was able to fix most everything done to me during Sharpei's invasion, as well as patching an ulcer that was playing havoc with my stomach. He told me the same things."
			)
			(39
				(rogEyes setLoop: local1)
				(stellerEyes setLoop: local1)
				(gMessager say: 0 0 1 13 self 950) ; "You might also try chewing. You had a hunk of a twinkoid wedged in your throat that would have gagged Linda Lovelace."
			)
			(40
				(rogEyes setLoop: local1)
				(stellerEyes setLoop: local3)
				(gMessager say: 0 0 1 14 self 950) ; "Okay, Roger, okay! I got the message. Let's change the subject, shall we? Ask me where I'm stationed next."
			)
			(41
				(rogEyes setLoop: local2)
				(stellerEyes setLoop: local3)
				(gMessager say: 0 0 1 15 self 950) ; "Why don't you just tell me."
			)
			(42
				(rogEyes setLoop: local2)
				(stellerEyes setLoop: local3)
				(gMessager say: 0 0 1 16 self 950) ; "Boy, some fun you are."
			)
			(43
				(rogEyes setLoop: local2)
				(stellerEyes setLoop: local1)
				(gMessager say: 0 0 1 17 self 950) ; "Sorry, I guess I'm a little grumpy. I had a real day. I had to clean the Captain's Log entry container. Then, somebody got a nice buzz in 8-Rear and decided to take a wormhole ride in the HoloSuite."
			)
			(44
				(rogEyes setLoop: local1)
				(stellerEyes setLoop: local1)
				(gMessager say: 0 0 1 18 self 950) ; "They hit a few wrong buttons and the next thing I know I'm cleaning Vergon Nebulasets and hors d'oeuvres off every wall and ceiling. Apparently, they truly did make the room spin. Boy, they spackled everything! Had to use a putty knife to chip loose some of the chunks of ... (INTERRUPTED BY STELLAR)"
			)
			(45
				(rogEyes setLoop: local1)
				(stellerEyes setLoop: local3)
				(gMessager say: 0 0 1 19 self 950) ; "Uh, Roger? I'm sorry you had a rough day, but can we please change the subject?"
			)
			(46
				(rogEyes setLoop: local2)
				(stellerEyes setLoop: local3)
				(gMessager say: 0 0 1 20 self 950) ; "Oh, sorry."
			)
			(47
				(rogEyes setLoop: local2)
				(stellerEyes setLoop: local3)
				(gMessager say: 0 0 1 21 self 950) ; "Anyway, I think you're going to like your next assignment."
			)
			(48
				(rogEyes setLoop: local2)
				(stellerEyes setLoop: local2)
				(gMessager say: 0 0 1 22 self 950) ; "Really? What is it? Where is it?"
			)
			(49
				(rogEyes setLoop: local2)
				(stellerEyes setLoop: local1)
				(gMessager say: 0 0 1 23 self 950) ; "Sorry. You're just going to have to wait to find out."
			)
			(50
				(= cycles 3)
			)
			(51
				(proc0_7 1 0 self 1)
			)
			(52
				(gTheIconBar hide: 1 disable:)
				(= cycles 3)
			)
			(53
				(gGSound1 number: 542 setLoop: -1 play: setVol: local4)
				(gCurRoom exitStyle: 0 newRoom: 960) ; endCredits
			)
		)
	)
)

(instance sBlinkSteller of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(client setCel: 0 cycleSpeed: 4 setCycle: Osc 1 self)
			)
			(1
				(= ticks (proc0_8 200 500))
			)
			(2
				(client setCel: 0)
				(self changeState: 0)
			)
		)
	)
)

(instance sBlinkRog of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(client setCel: 0 cycleSpeed: 4 setCycle: Osc 1 self)
			)
			(1
				(= ticks (proc0_8 300 400))
			)
			(2
				(client setCel: 0)
				(self changeState: 0)
			)
		)
	)
)

(instance Stellar of Talker
	(properties
		disposeWhenDone 0
	)

	(method (init)
		(super init: stellerMouth)
	)
)

(instance Roger of Talker
	(properties
		disposeWhenDone 0
	)

	(method (init)
		(super init: rogMouth)
	)
)

(instance rogMouth of Prop
	(properties
		x 183
		y 39
		view 543
	)
)

(instance rogEyes of Prop
	(properties
		x 183
		y 25
		view 543
		loop 1
	)
)

(instance stellerMouth of Prop
	(properties
		x 120
		y 52
		view 542
	)
)

(instance stellerEyes of Prop
	(properties
		x 120
		y 42
		view 542
		loop 1
	)
)

(instance dr of Prop
	(properties
		view 5340
	)
)

(instance drEye of Prop
	(properties
		view 5340
	)
)

(instance drArm of Prop
	(properties
		view 534
	)

	(method (init)
		(self setLoop: 2 setCel: 0 cycleSpeed: 6 posn: 154 73)
		(super init:)
	)
)

(instance noseFlash of Prop
	(properties
		view 534
	)

	(method (init)
		(self setLoop: 2 setCel: 0 cycleSpeed: 6 posn: 154 73)
		(super init:)
	)
)

(instance flashLeft of Prop
	(properties
		view 534
	)

	(method (init)
		(self setLoop: 0 posn: 41 68 setCycle: Fwd)
		(super init:)
	)
)

(instance window2 of Prop
	(properties
		view 4311
		signal 20513
	)

	(method (init)
		(self setLoop: 0 posn: 61 0 setPri: 10 cycleSpeed: 12 setCycle: Fwd)
		(super init:)
	)
)

(instance reflect of Prop
	(properties
		view 544
		signal 20513
	)

	(method (init)
		(self setLoop: 0 posn: 14 115 setPri: 200 cycleSpeed: 6 setCycle: Fwd)
		(super init:)
	)
)

(instance flashRight of Prop
	(properties
		view 534
	)

	(method (init)
		(self setLoop: 1 posn: 266 63 setCycle: Fwd)
		(super init:)
	)
)

