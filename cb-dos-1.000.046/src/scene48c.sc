;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 333)
(include sci.sh)
(use Main)
(use Interface)
(use Sound)
(use Motion)
(use Game)
(use Actor)
(use System)

(public
	scene48c 0
)

(local
	local0
	local1
	local2
)

(procedure (localproc_0 &tmp [temp0 500])
	(GetFarText &rest @temp0)
	(= local0 (+ (/ (StrLen @temp0) 3) 1))
)

(procedure (localproc_1)
	(localproc_0 &rest)
	(clarMouth setScript: cycleMouth)
	(Print &rest #at 160 110 #font 4 #width 140 #mode 1 #dispose)
)

(procedure (localproc_2)
	(localproc_0 &rest)
	(rudyMouth setScript: cycleMouth)
	(Print &rest #at 10 120 #font 4 #width 140 #mode 1 #dispose)
)

(procedure (localproc_3)
	(|= gSpyFlags $0008)
	(= [gCycleTimers 2] 1)
	(SetFlag 23)
)

(instance scene48c of Rm
	(properties
		picture 62
		style 7
	)

	(method (init)
		(super init:)
		(HandsOff)
		(if (& gSpyFlags $0008)
			(LoadMany rsSOUND 114 115)
			(snoring number: 114 loop: 1 play:)
			(Snoring
				setLoop: 0
				setPri: 1
				moveSpeed: 2
				setMotion: MoveTo 176 59 self
				init:
			)
			(Print 333 0 #width 240 #dispose) ; "You don't see anything, but you hear what sounds like someone snoring."
		else
			(Load rsFONT 4)
			(snoring number: 27 loop: -1 play:)
			(clarMouth setPri: 2 init:)
			(Clarence setPri: 1 ignoreActors: 1 init:)
			(clarEye setPri: 2 init: stopUpd: setScript: ClarsEye)
			(Rudy setPri: 1 init:)
			(rudyMouth setPri: 2 init:)
			(rudyEye setPri: 2 init: stopUpd: setScript: RudysEyes)
			(Hand setLoop: 7 setPri: 3 xStep: 5 yStep: 5 ignoreActors: 1)
			(self setScript: speech48c)
		)
	)

	(method (doit)
		(super doit:)
		(if (and (== (snoring prevSignal:) -1) (== (snoring number:) 114))
			(snoring number: 115 loop: 1 prevSignal: 0 play:)
		)
	)

	(method (dispose)
		(localproc_3)
		(super dispose:)
	)

	(method (cue)
		(cls)
		(gCurRoom newRoom: gPrevRoomNum)
	)

	(method (handleEvent event)
		(super handleEvent: event)
	)
)

(instance ClarsEye of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(clarEye cel: (^ (clarEye cel:) $0001) forceUpd:)
				(= state -1)
				(if (clarEye cel:)
					(= cycles 2)
				else
					(= seconds (Random 2 5))
				)
			)
		)
	)
)

(instance RudysEyes of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(rudyEye cel: (Random 0 2) forceUpd:)
				(= state -1)
				(if (== (rudyEye cel:) 2)
					(= cycles 2)
				else
					(= seconds (Random 2 5))
				)
			)
		)
	)
)

(instance speech48c of Script
	(properties)

	(method (handleEvent event)
		(super handleEvent: event)
		(if
			(and
				(not (event claimed:))
				(not script)
				(== evKEYBOARD (event type:))
				(or (== (event message:) KEY_S) (== (event message:) KEY_s))
			)
			(cls)
			(gCurRoom newRoom: gPrevRoomNum)
		)
	)

	(method (changeState newState)
		(if (cycleMouth client:)
			(= local1 1)
			(= cycles 1)
		else
			(switch (= state newState)
				(0
					(cond
						((not global216)
							(= state -1)
						)
						((not (& gMustDos $0004))
							(|= gMustDos $0004)
							(self setScript: (ScriptID 406 0)) ; Clock
							(= state -1)
						)
						((self script:)
							(= state -1)
						)
					)
					(= cycles 1)
				)
				(1
					(= local2
						(Display 333 1 dsCOORD 48 8 dsWIDTH 256 dsCOLOR 15 dsBACKGROUND -1 dsFONT 0 dsSAVEPIXELS) ; "Press the 'S' key to skip this scene."
					)
					(localproc_1 333 2) ; "Who is this so-called "director" that Gloria's seeing now?! Why, I oughta punch his lights out for getting between me and my gal!"
					(= seconds 10)
				)
				(2
					(localproc_2 333 3) ; "Gloria was never "your gal." Just because she went out with you a couple of times, you thought you owned her!"
					(= seconds 6)
				)
				(3
					(= cycles 1)
				)
				(4
					(localproc_2 333 4) ; "Well, I got news for you, buddy!...my sister doesn't need to settle for the likes of you! As a matter of fact, you were nothing but a mere dalliance for her!"
					(= seconds 7)
				)
				(5
					(localproc_1 333 5) ; "Dalliance! HAH! Why, YOU'RE the one who can't make a commitment to anyone! You're just trying to sink Gloria down to your lousy level!"
					(= seconds 7)
				)
				(6
					(localproc_2 333 6) ; "You ain't good enough to kiss the ground she walks on! You're nothing but a low-class jerk!"
					(= seconds 10)
				)
				(7
					(localproc_1 333 7) ; "Quit buttin' in between me and Gloria! This is none of YOUR business! I'll handle it the way I want and I WON'T be asking YOUR permission!"
					(= seconds 8)
				)
				(8
					(Hand init: setMotion: MoveTo 161 100)
					(localproc_2 333 8) ; "I'm warning you, Jack!! If I see you near my sister again, I'll cut you up in little pieces and feed them to the dog! GOT IT?!!"
					(= seconds 10)
				)
				(9
					(Hand init: setMotion: MoveTo 161 130 self)
				)
				(10
					(cls)
					(Rudy
						setLoop: 0
						setCycle: Walk
						setStep: 5 5
						setMotion: MoveTo 340 (Rudy y:) self
					)
					(rudyEye hide:)
					(rudyMouth stopUpd: hide:)
				)
				(11
					(gCurRoom newRoom: gPrevRoomNum)
				)
			)
		)
	)
)

(instance cycleMouth of Script
	(properties)

	(method (doit)
		(super doit:)
		(if local1
			(= local1 0)
			(= cycles 1)
		)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(client cel: 0 setCycle: Fwd show:)
				(= cycles local0)
			)
			(1
				(client setScript: 0 hide:)
				(self client: 0)
			)
		)
	)
)

(instance Rudy of Act
	(properties
		y 113
		x 103
		view 391
	)
)

(instance rudyMouth of Prop
	(properties
		y 97
		x 112
		view 391
		loop 2
	)
)

(instance rudyEye of Prop
	(properties
		y 74
		x 112
		view 391
		loop 8
	)
)

(instance Hand of Act
	(properties
		y 130
		x 161
		view 391
	)
)

(instance Clarence of Act
	(properties
		y 117
		x 217
		view 409
		loop 1
	)
)

(instance clarEye of Prop
	(properties
		y 74
		x 202
		view 409
		loop 9
	)
)

(instance clarMouth of Prop
	(properties
		y 96
		x 206
		view 409
		loop 3
	)
)

(instance Snoring of Act
	(properties
		y 164
		x 80
		view 146
		cel 12
	)
)

(instance snoring of Sound
	(properties)
)

