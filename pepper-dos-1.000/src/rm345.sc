;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 345)
(include sci.sh)
(use Main)
(use BalloonTalker)
(use ADRoom)
(use Ego)
(use Motion)
(use Actor)
(use System)

(public
	rm345 0
	benTalker 16
)

(local
	local0
	local1 = 1
	local2 = 1
	local3
	local4
	local5
)

(procedure (localproc_0)
	(ben stopUpd: setCycle: 0)
	(kite stopUpd: setCycle: 0)
)

(procedure (localproc_1)
	(ben setCycle: Fwd)
	(kite setCycle: Fwd)
)

(instance rm345 of ADRoom
	(properties
		picture 345
		horizon 75
		vanishingY -60
	)

	(method (init)
		(gEgo init: hide: normalize: posn: 107 169 setCycle: 0)
		(gLongSong number: 345 setLoop: -1 flags: 1 play:)
		(super init: &rest)
		(self setScript: startScr)
	)

	(method (dispose)
		(cloud dispose:)
		(jar dispose:)
		(kite dispose:)
		(bolt dispose:)
		(SetFlag 144)
		((ScriptID 895 0) get: 18) ; pepper, Glass_Jar
		(super dispose:)
	)
)

(instance cloudDoitScr of Script
	(properties)

	(method (doit)
		(if (and local1 (== (cloud cel:) 5))
			(kite setCycle: 0)
			(gLongSong2 number: 916 setLoop: 1 flags: 1 play:)
		)
		(super doit:)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(cloud setCycle: End)
				(= ticks 60)
			)
			(1
				(= local1 0)
				(kite view: 345 loop: 6 cel: 0 posn: 263 120 setCycle: End self)
			)
			(2
				(self dispose:)
			)
		)
	)
)

(instance startScr of Script
	(properties)

	(method (doit)
		(if (and local0 (not script) (== (kite cel:) 3) (== (kite loop:) 2))
			(self setScript: cloudDoitScr self)
		)
		(super doit:)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(ben view: 345 loop: 0 cel: 0 posn: 156 149 init: setCycle: Fwd)
				((ScriptID 895 0) ; pepper
					view: 345
					setLoop: 1
					cel: 0
					posn: 130 157
					setSpeed: 6
					show:
				)
				(kite
					view: 345
					loop: 2
					cel: 0
					posn: 263 120
					init:
					setCycle: Fwd
				)
				(cloud view: 347 loop: 1 cel: 12 posn: 282 25 init: stopUpd:)
				(= cycles 5)
			)
			(1
				(benTalker x: 10 y: 91 tailPosn: 1 dontUpd: 0)
				((ScriptID 2000 3) dontUpd: 0) ; PepperTalker
				(= cycles 2)
			)
			(2
				(gGame handsOff:)
				(= cycles 1)
			)
			(3
				((ScriptID 895 0) setCycle: End self) ; pepper
			)
			(4
				((ScriptID 895 0) setLoop: 7 setCycle: Fwd) ; pepper
				(= cycles 1)
			)
			(5
				(= seconds 2)
			)
			(6
				(bolt setScale: 100)
				(self setScript: occationalBoltScr self)
			)
			(7
				(= seconds 2)
			)
			(8
				(localproc_0)
				(gLongSong2 number: 927 setLoop: 1 flags: 1 play:)
				(gMessager say: 1 0 1 1 4 self) ; "|c3|Okay, child, let me clue you in on what's gonna happen! With this experiment, we're going to prove that lightning is actually MADE of electricity!|c|"
			)
			(9
				(localproc_1)
				(= cycles 1)
			)
			(10
				(bolt setScale: 50)
				(self setScript: occationalBoltScr self)
			)
			(11
				(= seconds 2)
			)
			(12
				(localproc_0)
				(gMessager say: 1 0 1 5 6 self) ; "Patience, child, patience! Once the lightning gets close to the kite, the electricity will groove its way down the string, and hit this key, you dig?"
			)
			(13
				(gLongSong2 number: 927 setLoop: 1 flags: 1 play:)
				(gMessager say: 1 0 1 7 8 self) ; "|c3|I get it! A Leyden jar is actually like a battery! It'll hold the electricity for us! Yeah, that IS pretty groovy!|c|"
			)
			(14
				(localproc_1)
				(= cycles 1)
			)
			(15
				(bolt setScale: 0)
				(self setScript: occationalBoltScr self)
			)
			(16
				(= seconds 2)
			)
			(17
				(gMessager say: 1 0 1 9 self) ; "Oh, no! I think the lightning just hit my totally groovy house! Man, this storm is bad! Maybe we should go inside! Maybe we shouldn't--"
			)
			(18
				(= local0 1)
			)
			(19
				(cloud dispose:)
				(gLongSong2 number: 3451 flags: 1 setLoop: 1 play:)
				(= ticks 50)
			)
			(20
				(gLongSong2 number: 3452 flags: 1 setLoop: 1 play:)
				(ben view: 346 loop: 1 cel: 0 setCycle: End self)
				(jar setPri: 13 init: stopUpd:)
				((ScriptID 895 0) view: 346 loop: 3 cel: 0 setCycle: End) ; pepper
			)
			(21
				(gLongSong number: 346 setLoop: 1 flags: 1 play:)
				(= cycles 1)
			)
			(22
				(= seconds 2)
			)
			(23
				(ben loop: 2 setCycle: End self)
			)
			(24
				(= seconds 2)
			)
			(25
				(ben loop: 4 setCycle: End self)
			)
			(26
				(gMessager say: 1 0 1 10 13 self) ; "Well then! That was a bit more electricity than I was expecting! Are you all right, lad?"
			)
			(27
				(gLongSong fade:)
				(SetFlag 40)
				(SetFlag 46)
				(SetFlag 20)
				(SetFlag 19)
				(= seconds 3)
			)
			(28
				(gCurRoom newRoom: 330)
				(= cycles 1)
			)
			(29
				(self dispose:)
			)
		)
	)
)

(instance occationalBoltScr of Script
	(properties)

	(method (changeState newState &tmp temp0)
		(switch (= state newState)
			(0
				(switch local2
					(1
						(= local4 70)
						(= local5 3)
					)
					(2
						(= local4 120)
						(= local5 6)
					)
					(3
						(= local4 190)
						(= local5 15)
					)
				)
				(bolt posn: local4 local5)
				(= ticks 30)
			)
			(1
				(bolt init: setCycle: Fwd)
				(Palette palSET_INTENSITY 0 255 (Random 300 500))
				(= ticks 3)
			)
			(2
				(Palette palSET_INTENSITY 0 255 100)
				(= seconds 2)
			)
			(3
				(bolt dispose:)
				(= cycles 1)
			)
			(4
				(switch local2
					(1
						(= local3 914)
						(= temp0 60)
					)
					(2
						(= local3 914)
						(= temp0 30)
					)
					(3
						(= local3 915)
						(= temp0 0)
					)
				)
				(if (not temp0)
					(= cycles 1)
				else
					(= ticks temp0)
				)
			)
			(5
				(gLongSong2 number: local3 setLoop: 1 flags: 1 play: self)
				(++ local2)
			)
			(6
				(self dispose:)
			)
		)
	)
)

(instance bolt of Prop
	(properties
		view 346
	)
)

(instance ben of Actor
	(properties
		x 121
		y 147
		view 345
	)
)

(instance kite of Prop
	(properties
		x 165
		y 111
		view 345
		loop 2
	)
)

(instance cloud of Prop
	(properties
		x 282
		y 25
		view 347
		loop 1
		cel 12
	)
)

(instance jar of View
	(properties
		x 121
		y 148
		view 907
		loop 4
		cel 7
	)
)

(instance peppa of Ego ; UNUSED
	(properties
		x 130
		y 157
		view 345
		loop 1
	)
)

(instance benTalker of BalloonTalker
	(properties
		x 10
		y 91
		talkWidth 150
		tailPosn 1
	)
)

