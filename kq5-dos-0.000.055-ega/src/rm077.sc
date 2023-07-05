;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 77)
(include sci.sh)
(use Main)
(use Interface)
(use Motion)
(use Game)
(use Actor)
(use System)

(public
	rm077 0
)

(local
	local0
	local1
)

(instance rm077 of Rm
	(properties
		picture 77
		south 13
	)

	(method (init)
		(super init:)
		(HandsOff)
		(self setScript: cartoon)
		(muscha init:)
		(gEgo normal: 0 view: 776 loop: 3 cel: 1 posn: 175 150 init:)
		((gEgo head:) hide:)
		(gGlobalSound number: 800 loop: -1 vol: 127 playBed:)
	)

	(method (doit &tmp temp0)
		(cond
			(script
				(script doit:)
			)
			((= temp0 (self edgeToRoom: (gEgo edgeHit:)))
				(gCurRoom newRoom: temp0)
			)
		)
	)

	(method (handleEvent event)
		(cond
			((event claimed:)
				(return)
			)
			(script
				(return)
			)
		)
	)

	(method (dispose)
		(super dispose:)
	)
)

(instance cartoon of Script
	(properties)

	(method (doit &tmp temp0 temp1)
		(super doit:)
		(if local1
			(= temp1 ((= temp0 (Event new:)) type:))
			(if (proc0_15 temp1 1 4)
				(= seconds 0)
				(= cycles 1)
			)
			(temp0 dispose:)
		)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(smallArm cycleSpeed: 3 setCycle: End self init:)
				(muscha loop: 0 cel: 0)
			)
			(1
				(= local1 1)
				(smallArm loop: 5 setCycle: Fwd)
				(= cycles 25)
			)
			(2
				(gCurRoom drawPic: 78)
				(smallArm dispose:)
				(ball1 init:)
				(ball2 cycleSpeed: 3 setCycle: Fwd init:)
				(muscha
					view: 778
					loop: 0
					cycleSpeed: 0
					setScript: (catMove new:)
					posn: 156 70
				)
				(mouth cycleSpeed: 3 setScript: (mouthMove new:) init:)
				(wArm cycleSpeed: 2 setScript: (catMove new:) init:)
				(eArm cycleSpeed: 2 setScript: (catMove new:) init:)
				(gEgo hide:)
				((gEgo head:) hide:)
				(PrintDC 77 0 #at 20 10 #width 270 #dispose) ; "So, you are here to see Madame Mushka, no? Vell, come closer. Seet down."
				(= seconds 10)
			)
			(3
				(cls)
				(gCurRoom drawPic: 77)
				(ball1
					view: 776
					loop: 7
					posn: 126 100
					setCycle: Fwd
					cycleSpeed: 3
				)
				(ball2 dispose:)
				(muscha
					view: 776
					loop: 0
					cel: 0
					setScript: (muschaMove new:)
					posn: 127 105
				)
				(mouth setScript: 0 hide:)
				(wArm hide:)
				(eArm hide:)
				(gEgo
					normal: 0
					view: 776
					loop: 3
					setCel: 0
					posn: 152 136
					setPri: 9
					show:
				)
				(PrintDC 77 1 #at 20 10 #width 270 #dispose) ; "I veel tell you your fortune. Already I can tell zat you are on a quest of great urgency. Ve vill see vat we can find out for you."
				(= seconds 10)
			)
			(4
				(PrintDC 77 2 #at 20 10 #width 270 #dispose) ; "Look, King Graham. Look into zee crystal ball."
				(= seconds 7)
			)
			(5
				(= local1 0)
				(muscha loop: 2 cel: 0 setCycle: End self)
			)
			(6
				(= local1 1)
				(gGlobalSound number: 801 loop: -1 playBed:)
				(cls)
				(ball1 dispose:)
				(muscha hide:)
				(gEgo hide:)
				(gCurRoom drawPic: 79)
				(mordac setScript: (mouthMove new:) init:)
				(mHand cycleSpeed: 2 setCycle: Fwd init:)
				(cat cycleSpeed: 1 setScript: catMove init:)
				(PrintDC 77 3 #at 20 160 #width 270 #dispose) ; "Look, Manannan, look what I have for you."
				(= seconds 5)
			)
			(7
				(cls)
				(PrintDC 77 4 #at 20 130 #width 270 #dispose) ; "Take a good look at what you did to my brother, Alexander. Because of you he's doomed to spend the rest of his days as a cat and there's nothing I can do about it."
				(= seconds 10)
			)
			(8
				(cls)
				(PrintDC 77 5 #at 20 140 #width 270 #dispose) ; "But YOU can do something about it. Since you're the one that did this to him you're the only one who can turn him back again...back to the wizard Manannan."
				(= seconds 10)
			)
			(9
				(cls)
				(PrintDC 77 6 #at 20 10 #dispose) ; "GRAHAM: "Alexander!""
				(= seconds 3)
			)
			(10
				(cls)
				(gCurRoom drawPic: 80)
				(mordac hide:)
				(mHand hide:)
				(cat hide:)
				(wArm hide:)
				(eArm hide:)
				(alex init: setScript: faceMove cycleSpeed: 3)
				(alexFace init: hide:)
				(PrintDC 77 7 #at 20 130 #width 270 #dispose) ; "I don't know how, Mordack! I'm not a wizard. I just happened to stumble across some magic spells and accidentally turned him into a cat."
				(= seconds 12)
			)
			(11
				(cls)
				(PrintDC 77 8 #at 20 130 #width 270 #dispose) ; "I didn't mean it! Please believe me, Mordack. I don't know HOW to turn him back into a wizard!"
				(= seconds 8)
			)
			(12
				(cls)
				(alex dispose:)
				(alexFace dispose:)
				(gCurRoom drawPic: 79)
				(mordac show:)
				(mHand show:)
				(cat show:)
				(PrintDC 77 9 #at 20 130 #width 270 #dispose) ; "You're holding out on me, little man! You're taking advantage of my good nature...but not for long! If I don't get a change of tune from you soon, I'll feed your family to the cat...starting with your dear mother!"
				(= seconds 15)
			)
			(13
				(cls)
				(PrintDC 77 10 #at 20 140 #width 270 #dispose) ; "Remember what I said. I'll only give you a little more time to decide before your family becomes cat food!"
				(= seconds 8)
			)
			(14
				(gGlobalSound number: 802 loop: -1 playBed:)
				(cls)
				(gCurRoom drawPic: 77)
				(mordac dispose:)
				(mHand dispose:)
				(cat dispose:)
				(muscha
					view: 776
					loop: 0
					cel: 0
					posn: 127 105
					setCycle: 0
					setScript: 0
					show:
				)
				(smallMouth setScript: mouthMove init:)
				(gEgo show:)
				(PrintDC 77 11 #at 20 10 #width 270 #dispose) ; "Zat eez all. But I see zat your mission eez very dangerous indeed."
				(= seconds 7)
			)
			(15
				(PrintDC 77 12 #at 20 10 #width 270 #dispose) ; "I veel give you somezink to help you. Here...wear zis. Eet eez a magic amulet. Eet veel protect you against all but zee most powerful magic."
				(muscha loop: 8 cel: 0 cycleSpeed: 4 setCycle: End self)
				(gEgo get: 27) ; Amulet
				(SetScore 2)
			)
			(16
				(muscha loop: 9 cel: 0 setCycle: End)
				(= seconds 10)
			)
			(17
				(smallMouth dispose:)
				(cls)
				(gCurRoom drawPic: 78)
				(gEgo hide:)
				(muscha view: 778 setScript: (mouthMove new:) posn: 156 70)
				(mouth
					view: 778
					loop: 1
					cel: 2
					posn: 156 92
					cycleSpeed: 3
					setScript: (mouthMove new:)
					show:
				)
				(wArm show:)
				(eArm show:)
				(PrintDC 77 13 #at 20 10 #width 270 #dispose) ; "Good luck, King Graham. Be careful; zat Mordack eez a bad one!"
				(= seconds 7)
			)
			(18
				(mouth setScript: 0 setCycle: 0 cel: 0)
				(muscha setScript: 0 setCycle: 0 cel: 0)
				(cls)
				(PrintDC 77 14 #at 20 150 #dispose) ; "Thank you, Madame Mushka"
				(= seconds 4)
			)
			(19
				(gGlobalSound fade:)
				(cls)
				(gCurRoom newRoom: 13)
			)
		)
	)
)

(instance catMove of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(client setCycle: Beg)
				(= state -1)
				(= seconds (Random 5 8))
			)
		)
	)
)

(instance mouthMove of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(client cel: (Random 0 8))
				(= state -1)
				(= cycles 3)
			)
		)
	)
)

(instance muschaMove of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(client cycleSpeed: 5 loop: 0 cel: 0 setCycle: End self)
			)
			(1
				(client loop: 1 cel: 0 setCycle: Fwd)
			)
		)
	)
)

(instance faceMove of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(alexFace hide:)
				(alex setCycle: Beg self)
			)
			(1
				(alexFace show: setCycle: Fwd)
				(= seconds (Random 3 5))
				(= state -1)
			)
		)
	)
)

(instance alex of Prop
	(properties
		y 102
		x 173
		view 784
	)
)

(instance alexFace of Prop
	(properties
		y 65
		x 181
		view 784
		loop 1
		cel 5
		priority 15
		signal 16
		cycleSpeed 3
	)
)

(instance smallArm of Prop
	(properties
		y 105
		x 127
		view 776
		loop 4
		priority 4
		signal 16
	)
)

(instance smallMouth of Prop
	(properties
		y 94
		x 126
		view 776
		loop 6
		priority 4
		signal 16
	)
)

(instance muscha of Prop
	(properties
		y 105
		x 127
		view 776
		priority 3
		signal 16
	)
)

(instance mouth of Prop
	(properties
		y 92
		x 156
		view 778
		loop 1
		cel 2
		priority 5
		signal 16
	)
)

(instance wArm of Prop
	(properties
		y 121
		x 130
		view 778
		loop 3
		priority 8
		signal 16
	)
)

(instance eArm of Prop
	(properties
		y 125
		x 182
		view 778
		loop 2
		priority 8
		signal 16
	)
)

(instance mordac of Prop
	(properties
		y 60
		x 166
		view 782
		loop 3
		priority 9
		signal 16
	)
)

(instance mHand of Prop
	(properties
		y 82
		x 167
		view 782
		cel 4
		priority 7
		signal 16
	)
)

(instance cat of Prop
	(properties
		y 80
		x 189
		view 782
		loop 1
		priority 7
		signal 16
	)
)

(instance ball1 of Prop
	(properties
		y 112
		x 161
		view 778
		loop 4
		priority 15
		signal 17
	)
)

(instance ball2 of Prop
	(properties
		y 112
		x 161
		view 778
		loop 5
		cel 2
		priority 14
		signal 16
	)
)

