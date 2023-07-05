;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 905)
(include sci.sh)
(use Main)
(use Talker)
(use RandCycle)
(use LoadMany)
(use Sound)
(use Motion)
(use Game)
(use Actor)
(use System)

(public
	rm905 0
)

(instance rm905 of Room
	(properties
		picture 905
		style 0
	)

	(method (init)
		(gTheIconBar disable:)
		(Platform 0 2 1)
		(LoadMany rsVIEW 904 905 900 906 901 907 902)
		(gThePlane picture: -1 back: 0 style: 0 setRect: 0 0 319 199 1)
		(FrameOut)
		(super init: &rest)
		(gGlobalSound1 number: 505 setLoop: 1 play: hold: 1)
		(tv init: signal: (| (tv signal:) $4000))
		(self setScript: tvScr)
	)
)

(instance switchSnd of Sound
	(properties
		number 999
	)
)

(instance tv of Prop
	(properties
		x 217
		y 117
		priority 4
		fixPriority 1
		view 905
	)
)

(instance body of View
	(properties
		priority 4
		fixPriority 1
		view 908
	)
)

(instance backGrd of View
	(properties
		x 158
		y 117
		priority 3
		fixPriority 1
		view 903
	)
)

(instance blinkOff of Prop
	(properties
		x 158
		y 117
		priority 6
		fixPriority 1
		view 904
		loop 1
	)
)

(instance kristyTitle of Prop
	(properties
		priority 5
		fixPriority 1
		view 908
		loop 2
	)
)

(instance tvScr of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= register (Narrator modeless:))
				(Narrator y: 125 modeless: 2)
				(tv view: 905 cel: 0 setCycle: End self)
				(backGrd init: signal: (| (backGrd signal:) $4000))
			)
			(1
				(gMessager say: 0 2 1 0) ; ""I'm here to tell you, the cops are doggin' this investigation! No answers, just hype!"
				(tv view: 900 cel: 0 setCycle: End self)
			)
			(2
				(tv view: 906 cel: 0 setCycle: End self)
			)
			(3
				(tv view: 901 cel: 0 setCycle: End self)
			)
			(4
				(tv view: 907 cel: 0 setCycle: End self)
			)
			(5
				(tv setCycle: Beg self)
			)
			(6
				(tv setCycle: End self)
			)
			(7
				(tv setCycle: Beg self)
			)
			(8
				(tv setCycle: End self)
			)
			(9
				(tv view: 902 cel: 0 setCycle: End self)
			)
			(10
				(LoadMany rsVIEW 904 908)
				(= cycles 1)
			)
			(11
				(backGrd view: 904)
				(tv view: 908 setLoop: 1 cel: 0 x: 157 y: 68)
				(FrameOut)
				(body
					x: (- (tv x:) 2)
					y: (+ (tv y:) 47)
					init:
					signal: (| (body signal:) $4000)
				)
				(kristyTitle
					x: (- (tv x:) 67)
					y: (+ (tv y:) 40)
					init:
					signal: (| (kristyTitle signal:) $4000)
				)
				(= cycles 2)
			)
			(12
				(gMessager say: 0 2 2 0 self) ; "Believing that the discovery of murdered police officer Rene Garcia earlier this week is a vicious plot manufactured to discredit him and his music,"
				(tv cycleSpeed: 7 setCycle: RandCycle -1 self 1)
			)
			(13
				(tv setCycle: 0 cel: 0)
				(FrameOut)
				(= seconds 2)
			)
			(14
				(blinkOff
					init:
					signal: (| (blinkOff signal:) $4000)
					cel: 0
					setCycle: End self
				)
				(switchSnd play:)
				(gGlobalSound1 fade: 0 30 10 1 self)
			)
			(15
				(backGrd dispose:)
				(body dispose:)
				(tv dispose:)
				(kristyTitle dispose:)
				(blinkOff dispose:)
				0
			)
			(16
				(Narrator y: 15 modeless: register)
				(gPqFlags set: 43)
				(gCurRoom newRoom: 910)
			)
		)
	)
)

