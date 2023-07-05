;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 127)
(include sci.sh)
(use Main)
(use Talker)
(use LoadMany)
(use Motion)
(use Game)
(use Actor)
(use System)

(public
	rm127 0
	danteTalker 3
	beaTalker 10
	quirkTalker 14
)

(local
	local0
	local1
)

(procedure (localproc_0)
	(bobHead setCel: 0)
	(danteHead setCel: 1)
	(kaarenHead setCel: 0)
	(quirkHead setCel: 0)
	(randyHead setCel: 0)
)

(procedure (localproc_1)
	(bobHead setCel: 2)
	(danteHead setCel: 0)
	(kaarenHead setCel: 3)
	(randyHead setCel: 3)
)

(procedure (localproc_2)
	(quirkHead setLoop: 2 setCel: 1)
	(bobHead setCel: 1)
	(danteHead setCel: 1)
	(kaarenHead setCel: 1)
	(quirkHead setCel: 1)
	(randyHead setCel: 1)
)

(instance rm127 of Rm
	(properties
		picture 34
		style 10
	)

	(method (init)
		(self setRegions: 109) ; starCon
		(LoadMany rsVIEW 150 151 153 152)
		(LoadMany rsMESSAGE 127)
		(confDoor init: setPri: 9)
		(beaBody init:)
		(beaHead init:)
		(kaarenHead init:)
		(oldMan init:)
		(quirkHead init:)
		(danteHead init:)
		(randyHead init:)
		(super init:)
		(gSq5Music1 number: 15 loop: -1 play:)
		(self setScript: sArgument)
	)

	(method (dispose)
		(gSq5Music1 stop:)
		(super dispose:)
	)
)

(instance sArgument of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(= seconds 2)
			)
			(1
				(gSq5Music2 number: 145 setLoop: -1 play:)
				(Palette palSET_INTENSITY 1 254 50)
				(= cycles 2)
			)
			(2
				(Palette palSET_INTENSITY 1 254 100)
				(= cycles 2)
			)
			(3
				(Palette palSET_INTENSITY 1 254 50)
				(= cycles 2)
			)
			(4
				(Palette palSET_INTENSITY 1 254 100)
				(= cycles 5)
			)
			(5
				(Palette palSET_INTENSITY 1 254 50)
				(= cycles 2)
			)
			(6
				(Palette palSET_INTENSITY 1 254 100)
				(= cycles 2)
			)
			(7
				(Palette palSET_INTENSITY 1 254 50)
				(= cycles 2)
			)
			(8
				(Palette palSET_INTENSITY 1 254 100)
				(= cycles 2)
			)
			(9
				(Palette palSET_INTENSITY 1 254 50)
				(= cycles 2)
			)
			(10
				(Palette palSET_INTENSITY 1 254 100)
				(gSq5Music2 stop:)
				(= cycles 2)
			)
			(11
				(= local0 0)
				(gMessager say: 1 0 0 1 self) ; "Huh? What was that?"
			)
			(12
				(localproc_2)
				(= cycles 2)
			)
			(13
				(gMessager say: 1 0 0 2 self) ; "Excuse me, Captain... you didn't raise your hand."
			)
			(14
				(gMessager say: 1 0 0 3 self) ; "Now, as I was saying, Ambassador Wankmeister, we are a fairly remote installation and I simply can't spare the ships to launch the kind of operation you suggest."
			)
			(15
				(beaBody setCycle: End self)
				(rog loop: 4 cel: 0 init: posn: 115 119 setCycle: End self)
			)
			(16 0)
			(17
				(localproc_0)
				(= cycles 2)
			)
			(18
				(gMessager say: 1 0 0 4 self) ; "I'm afraid you don't understand the potential ramifications of this problem, Admiral."
			)
			(19
				(gMessager say: 1 0 0 5 self) ; "If the sludge bandits continue to illegally dump toxic wastes whenever and wherever they choose, the environmental consequences could be staggering."
			)
			(20
				(beaBody setCycle: Beg self)
				(rog loop: 5 cel: 0 posn: 249 120 setCycle: End self)
			)
			(21 0)
			(22
				(gMessager say: 1 0 0 6 self) ; "Entire planets could be devastated!"
			)
			(23
				(localproc_2)
				(= cycles 2)
			)
			(24
				(gMessager say: 1 0 0 7 self) ; "I think you overstate the issue, Ambassador. Even so, we have more than enough ships on patrol to put a stop to these `sludge bandits' as you call them."
			)
			(25
				(rog loop: 0 cel: 0 posn: 249 119 setCycle: End self)
			)
			(26
				(localproc_1)
				(= cycles 2)
			)
			(27
				(= local0 2)
				(gMessager say: 1 0 0 8 self) ; "Look, Ambassador. We have top-notch ships staffed with the finest crews in the galaxy. StarCon accepts only the best and brightest for fleet training!"
			)
			(28
				(beaHead hide:)
				(beaBody loop: 1 cel: 0 setCycle: CT 4 1 self)
			)
			(29
				(beaBody setCel: 5)
				(beaHead setCel: 0 posn: 176 97 show:)
				(localproc_0)
				(= cycles 2)
			)
			(30
				(gMessager say: 1 0 0 9 self) ; "|f8|you|f| look, rug-head! Illegal dumping is going on in this sector right under your poly-weave! Our patrols have located dumping sites on four planets in the G6 quadrant alone."
			)
			(31
				(rog loop: 1 cel: 0 setCycle: End self)
				(gSq5Music2 number: 152 setLoop: 1 play:)
			)
			(32
				(localproc_1)
				(= cycles 2)
			)
			(33
				(= local0 2)
				(gMessager say: 1 0 0 10 self) ; "Hey! This is made from real hair... er, ahem..."
			)
			(34
				(gMessager say: 1 0 0 11 self) ; "In any case, I'd like to hear more about these alleged dumping sites. Perhaps over dinner this evening?"
			)
			(35
				(localproc_0)
				(= cycles 2)
			)
			(36
				(gMessager say: 1 0 0 12 self) ; "I have already transmitted the coordinates to StarCon Central Command, along with a list of suspected sites that we haven't been able to check out yet."
			)
			(37
				(localproc_2)
				(= cycles 2)
			)
			(38
				(gMessager say: 1 0 0 13 self) ; "Well then, that settles it! Captain Quirk, you shall go to these sites and investigate Ambassador Wankmeister's allegations."
			)
			(39
				(localproc_0)
				(= cycles 2)
			)
			(40
				(gMessager say: 1 0 0 14 self) ; "Admiral, I'll be going along as an observer."
			)
			(41
				(localproc_2)
				(= cycles 2)
			)
			(42
				(gMessager say: 1 0 0 15 self) ; "I'm afraid that's impossible. Regulations strictly forbid civilian participation in military operations."
			)
			(43
				(localproc_1)
				(= cycles 2)
			)
			(44
				(= local0 1)
				(gMessager say: 1 0 0 16 self) ; "Uh... Admiral, I think having the ambassador along would be a good idea. I'm sure the two of us could develop a productive working relationship."
			)
			(45
				(localproc_0)
				(= cycles 2)
			)
			(46
				(gMessager say: 1 0 0 17 self) ; "Admiral, may I remind you that I am an |f8|official|f| representative of the people of Quadrant G-6 with full ambassadorial status and as such not subject to..."
			)
			(47
				(localproc_2)
				(= cycles 2)
			)
			(48
				(gMessager say: 1 0 0 18 self) ; "...Now, now, Ambassador, I'm sure Captain Quirk will do everything necessary to resolve the situation. There's no need for you to hinder him on this mission."
			)
			(49
				(localproc_0)
				(= cycles 2)
			)
			(50
				(gMessager say: 1 0 0 19 self) ; "This is |f8|my|f| system and |f8|my|f| people we're talking about here. I'm going on that ship and that's all there is to it! |f8|case closed! we're adjourned! good day gentlemen!|f|"
			)
			(51
				(beaHead dispose:)
				(beaBody setLoop: 3 setCel: 0 setCycle: End self)
			)
			(52
				(beaBody setLoop: 4 setCel: 0 setCycle: End self)
			)
			(53
				(confDoor setCycle: End self)
				(gSq5Music2 number: 103 setLoop: 1 play:)
			)
			(54
				(gSq5Music2 number: 102 setLoop: 1 play:)
				(beaBody setLoop: 5 setCel: 0 setCycle: End)
				(rog loop: 2 cel: 0 setPri: 10 posn: 180 146 setCycle: End self)
			)
			(55
				(gSq5Music2 number: 136 setLoop: 1 play: self)
			)
			(56
				(= local1 1)
				(localproc_0)
				(= cycles 2)
			)
			(57
				(gMessager say: 1 0 0 20 self) ; "Oh great! The savior of the universe in all his glory! Isn't there a mop somewhere with your name on it?!"
			)
			(58
				(beaBody setLoop: 6 setCel: 0 setCycle: End self)
			)
			(59
				(beaBody setCycle: Beg self)
			)
			(60
				(beaBody
					setLoop: 7
					setCel: 0
					setPri: 5
					signal: 16
					setCycle: End self
				)
			)
			(61
				(= seconds 2)
			)
			(62
				(oldMan setCel: 1 posn: 48 116)
				(rog setLoop: 3 cel: 0 setCycle: End self)
				(beaBody setLoop: 8 setCel: 0 posn: 100 102 setCycle: End self)
			)
			(63 0)
			(64
				(confDoor setCycle: Beg self)
				(gSq5Music2 number: 103 setLoop: 1 play:)
			)
			(65
				(gMessager say: 1 0 0 21 self) ; "Way to go Rog! Another sterling performance."
			)
			(66
				(SetFlag 2)
				(gCurRoom newRoom: 125)
				(self dispose:)
			)
		)
	)
)

(instance beaBody of Actor
	(properties
		x 182
		y 139
		view 150
		priority 11
		signal 16
	)
)

(instance beaHead of Actor
	(properties
		x 178
		y 95
		view 150
		loop 10
		cel 1
		priority 12
		signal 16
	)
)

(instance rog of Actor
	(properties
		view 151
		priority 15
		cycleSpeed 8
	)
)

(instance confDoor of Prop
	(properties
		x 181
		y 134
		view 152
		priority 11
	)
)

(instance beaMouth of Prop
	(properties
		nsTop 8
		nsLeft 3
		view 150
		loop 2
		signal 16384
	)
)

(instance danteMouth of Prop
	(properties
		nsTop 25
		nsLeft 5
		view 153
		loop 6
		signal 16384
	)
)

(instance quirkMouth of Prop
	(properties
		view 153
		signal 16384
	)
)

(instance beaTalker of Talker
	(properties
		view 150
		loop 10
		talkWidth 200
		textX -120
		textY -80
	)

	(method (init)
		(if (== (beaBody loop:) 0)
			(self cel: 1 x: 174 y: 87)
		else
			(self cel: 0 x: 172 y: 89)
		)
		(if (== local1 1)
			(self loop: 11 cel: 0 x: 180 y: 110)
			(beaMouth loop: 11 cel: 1)
		)
		(= font gUserFont)
		(= gSystemWindow gSpeakWindow)
		(gSystemWindow tailX: 171 tailY: 75 xOffset: 0)
		(super init: 0 0 beaMouth &rest)
	)

	(method (dispose)
		(= gSystemWindow gSq5Win)
		(super dispose: &rest)
	)
)

(instance danteTalker of Talker
	(properties
		x 260
		y 105
		view 153
		loop 5
		cel 1
		talkWidth 200
		textX -240
	)

	(method (init)
		(= font gUserFont)
		(= gSystemWindow gSpeakWindow)
		(gSystemWindow tailX: 244 tailY: 82 xOffset: -40)
		(super init: 0 0 danteMouth &rest)
	)

	(method (dispose)
		(= gSystemWindow gSq5Win)
		(super dispose: &rest)
	)
)

(instance quirkTalker of Talker
	(properties
		view 153
		loop 2
		talkWidth 170
	)

	(method (init)
		(switch local0
			(0
				(self cel: 3 x: 79 y: 101)
				(quirkMouth loop: 13 nsLeft: 0 nsTop: 12)
				(quirkHead setCel: 3)
			)
			(1
				(self cel: 1 x: 80 y: 100)
				(quirkMouth loop: 3 nsLeft: 2 nsTop: 13)
				(quirkHead setCel: 1)
			)
			(else
				(self cel: 0 x: 81 y: 101)
				(quirkMouth loop: 8 nsLeft: 7 nsTop: 8)
				(quirkHead setCel: 0)
			)
		)
		(= font gUserFont)
		(= gSystemWindow gSpeakWindow)
		(gSystemWindow tailX: 100 tailY: 82 xOffset: 13)
		(super init: 0 0 quirkMouth &rest)
	)

	(method (dispose)
		(if (== local0 0)
			(randyHead setCel: 3 posn: 218 114)
			(bobHead init:)
		)
		(= gSystemWindow gSq5Win)
		(super dispose: &rest)
	)
)

(instance kaarenHead of View
	(properties
		x 20
		y 110
		view 153
		cel 4
		priority 15
		signal 16400
	)
)

(instance oldMan of View
	(properties
		x 45
		y 112
		view 153
		loop 1
		cel 2
		priority 12
		signal 16400
	)
)

(instance quirkHead of View
	(properties
		x 88
		y 115
		view 153
		loop 2
		cel 3
		priority 15
		signal 16400
	)
)

(instance danteHead of View
	(properties
		x 260
		y 106
		view 153
		loop 5
		cel 2
		priority 8
		signal 16400
	)
)

(instance randyHead of View
	(properties
		x 223
		y 104
		view 153
		loop 4
		cel 4
		priority 15
		signal 16400
	)
)

(instance bobHead of View
	(properties
		x 222
		y 105
		view 153
		loop 7
		cel 2
		priority 15
		signal 16400
	)
)

