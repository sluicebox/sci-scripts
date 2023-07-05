;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 116)
(include sci.sh)
(use Main)
(use Interface)
(use FileSelector)
(use Avoid)
(use Motion)
(use Game)
(use Actor)
(use System)

(public
	Room116 0
)

(local
	[local0 2]
	local2
)

(instance ship of Act
	(properties)
)

(instance shadow of Act
	(properties)
)

(instance cockPit of Prop
	(properties)
)

(instance Roger of Act ; UNUSED
	(properties)
)

(instance Mark of Act
	(properties)
)

(instance Scott of Act
	(properties)
)

(instance ramp of Prop
	(properties)
)

(instance Ken of Act
	(properties)
)

(instance bigRoger of Act
	(properties)
)

(instance sMouth of Prop
	(properties)
)

(instance mMouth of Prop
	(properties)
)

(instance kMouth of Prop
	(properties)
)

(instance rMouth of Prop
	(properties)
)

(instance Room116 of Rm
	(properties
		picture 116
	)

	(method (init)
		(= local2 (DoSound sndCHECK_DRIVER))
		(Load rsSOUND 99)
		(Load rsSOUND 83)
		(Load rsSOUND 38)
		(Load rsSOUND 40)
		(if (== local2 1)
			(Load rsSOUND 16)
		)
		(= horizon -4000)
		(gGame setSpeed: 5)
		(HandsOff)
		(= global159 1)
		(super init:)
		(self setScript: Actions)
	)

	(method (newRoom newRoomNumber)
		(super newRoom: newRoomNumber)
	)
)

(instance Actions of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(ship
					view: 215
					setLoop: 0
					posn: 0 -10
					setCel: 0
					setPri: 13
					ignoreActors:
					setMotion: MoveTo 0 39 self
					init:
				)
			)
			(1
				(gLongSong number: 83 loop: 1 play:)
				(ship setCel: 1 setMotion: MoveTo 0 92 self)
			)
			(2
				(ship setCel: 2 setMotion: MoveTo 0 132 self)
			)
			(3
				(shadow
					view: 215
					setLoop: 1
					setCel: 0
					posn: 5 191
					ignoreActors:
					setPri: 0
					setStep: 2 1
					setMotion: MoveTo 5 165
					init:
				)
				(ship setStep: 2 1 setMotion: MoveTo 0 158 self)
			)
			(4
				(gLongSong fade:)
				(shadow setMotion: 0)
				(= seconds 5)
			)
			(5
				(ship stopUpd:)
				(shadow stopUpd:)
				(ramp
					view: 215
					setLoop: 3
					posn: 67 169
					cel: 255
					ignoreActors:
					setPri: 11
					setCycle: End self
					init:
				)
			)
			(6
				(gLongSong number: 99 loop: -1 play:)
				(Mark
					view: 215
					setLoop: 4
					setCycle: Walk
					setStep: 1 1
					setPri: 12
					posn: 54 157
					setMotion: MoveTo 87 176 self
					init:
				)
			)
			(7
				(Mark setMotion: MoveTo 117 172)
				(Scott
					view: 215
					setLoop: 5
					setCycle: Walk
					setStep: 1 1
					setPri: 12
					posn: 54 157
					setMotion: MoveTo 79 174 self
					init:
				)
			)
			(8
				(cockPit
					view: 215
					setLoop: 2
					cel: 255
					cycleSpeed: 3
					setPri: 13
					posn: 70 157
					setCycle: End
					init:
				)
				(Scott setMotion: MoveTo 109 166)
				(Ken
					view: 215
					setLoop: 6
					posn: 180 132
					setPri: 0
					setStep: 1 1
					setCycle: Walk
					setMotion: MoveTo 130 162 self
					init:
				)
			)
			(9
				(= seconds 2)
			)
			(10
				(gCurRoom drawPic: 117 8)
				(gCast eachElementDo: #hide)
				(RedrawCast)
				(mMouth view: 136 loop: 0 posn: 42 74 setPri: 5 init:)
				(sMouth view: 136 loop: 1 posn: 158 109 setPri: 5 init:)
				(kMouth view: 136 loop: 2 posn: 237 157 setPri: 5 init:)
				(bigRoger
					view: 136
					setLoop: 3
					posn: -23 87
					setPri: 3
					ignoreActors:
					setMotion: MoveTo 19 87
					init:
				)
				(= seconds 3)
			)
			(11
				(if (== local2 1)
					(gLongSong stop:)
					(gLongSong number: 16 loop: -1 play:)
				)
				(mMouth setCycle: Fwd)
				(Print 116 0 #title {Mark} #dispose #at -1 156 #width 310) ; "Greetings Earthling. We are the Two Guys From Andromeda, Universally famous software authors."
				(= seconds 8)
			)
			(12
				(cls)
				(RedrawCast)
				(mMouth setCel: 0)
				(rMouth
					view: 136
					setLoop: 4
					posn: (bigRoger x:) (bigRoger y:)
					setPri: 4
					ignoreActors:
					setCycle: Fwd
					init:
				)
				(Print 116 1 #title {Roger} #dispose #at -1 156 #width 310) ; "And I am Roger Wilco, Space age swashbuckler and all around nice guy."
				(= seconds 8)
			)
			(13
				(cls)
				(RedrawCast)
				(rMouth setCel: 0)
				(kMouth setCycle: Fwd)
				(Print 116 2 #title {Ken Williams} #dispose #at -1 156 #width 310) ; "Hello, I'm Ken Williams, President and founder of Sierra On-line. Sooo... You two guys are software authors heh? What are your credits?"
				(= seconds 10)
			)
			(14
				(cls)
				(RedrawCast)
				(kMouth setCel: 0)
				(sMouth setCycle: Fwd)
				(Print 116 3 #title {Scott} #dispose #at -1 170) ; "Ever heard of ASTRO CHICKEN?"
				(= seconds 5)
			)
			(15
				(cls)
				(RedrawCast)
				(sMouth setCel: 0)
				(kMouth cel: 255 setCycle: End self)
				(Print 116 4 #title {Ken Williams} #dispose #at -1 170 #mode 1) ; "No"
			)
			(16
				(cls)
				(RedrawCast)
				(mMouth setCel: 0)
				(sMouth cel: 255 setCycle: End self)
				(Print 116 5 #title {Scott} #dispose #at -1 170 #mode 1) ; "Good!"
			)
			(17
				(cls)
				(RedrawCast)
				(sMouth setCel: 0)
				(kMouth setCycle: Fwd)
				(Print 116 6 #title {Ken Williams} #dispose #at -1 170) ; "How about you two guys coming to work for me?"
				(= seconds 8)
			)
			(18
				(cls)
				(RedrawCast)
				(kMouth setCel: 0)
				(mMouth setCycle: Fwd)
				(sMouth setCycle: Fwd)
				(Print ; "Sounds great! How many buckazoids does it pay?"
					116
					7
					#title
					{Scott and Mark}
					#dispose
					#at
					-1
					156
					#width
					310
					#mode
					1
				)
				(= seconds 5)
			)
			(19
				(cls)
				(RedrawCast)
				(sMouth setCel: 0)
				(mMouth setCel: 0)
				(kMouth cel: 255 setCycle: End self)
				(Print 116 8 #title {Ken Williams} #dispose #at -1 170) ; "Buckazoids?"
			)
			(20
				(cls)
				(RedrawCast)
				(kMouth setCel: 0)
				(rMouth setCycle: Fwd)
				(Print 116 9 #title {Roger} #dispose #at -1 170) ; "Say... Uh...Mr. Williams. Do you need a janitor?"
				(= seconds 7)
			)
			(21
				(cls)
				(RedrawCast)
				(rMouth setCel: 0)
				(kMouth cel: 255 setCycle: End self)
				(Print 116 4 #title {Ken Williams} #dispose #at -1 170 #mode 1) ; "No"
			)
			(22
				(cls)
				(RedrawCast)
				(mMouth dispose:)
				(rMouth dispose:)
				(sMouth dispose:)
				(kMouth dispose:)
				(= cycles 2)
			)
			(23
				(gLongSong fade:)
				(gCast eachElementDo: #show)
				(bigRoger dispose:)
				(gCurRoom drawPic: 116 8)
				(gEgo
					view: 68
					setStep: 1 1
					posn: 110 176
					setPri: 12
					setLoop: -1
					loop: 0
					setCel: -1
					setCycle: Walk
					setAvoider: Avoid
					init:
				)
				(RedrawCast)
				(Ken setScript: KenMoveIntoBuilding)
				(= seconds 1)
			)
			(24
				(Mark setScript: MarkMoveIntoBuilding)
				(= seconds 1)
			)
			(25
				(Scott setScript: ScottMoveIntoBuilding)
				(Print 116 10 #at -1 10 #width 310 #dispose) ; "As our space saga comes to a close, Roger, feeling a little left out, struts off to his ship with the satisfaction of knowing his mission has been accomplished."
				(gEgo setMotion: MoveTo 87 176 self)
			)
			(26
				(gEgo setMotion: MoveTo 54 157 self)
			)
			(27
				(= seconds 7)
			)
			(28
				(cockPit setCycle: Beg self)
			)
			(29
				(cls)
				(gEgo dispose:)
				(ramp setCycle: Beg)
				(= seconds 2)
			)
			(30
				(ramp dispose:)
				(cockPit dispose:)
				(ship setMotion: MoveTo 0 132 self)
				(Print 116 11 #at -1 10 #width 310 #time (LangSwitch 12 12 24 24)) ; "The Two Guys from Andromeda go on to create the Space Quest series of adventure games reaping fame and fortune. They grow fat on their success and soon become burnt out and begin a drunken tailspin into obscurity."
				(gLongSong number: 40 loop: 1 play:)
				(shadow setMotion: MoveTo 5 199)
			)
			(31
				(shadow dispose:)
				(ship setStep: 1 5 setMotion: MoveTo 0 92 self)
			)
			(32
				(ship setCel: 1 setMotion: MoveTo 0 39 self)
			)
			(33
				(ship setCel: 0 setMotion: MoveTo 0 -20 self)
			)
			(34
				(gLongSong number: 38 loop: 1 play:)
				(ship
					setLoop: 8
					setCel: 0
					posn: 279 -14
					setStep: 4 6
					setMotion: MoveTo 243 15 self
				)
			)
			(35
				(cls)
				(ship setCycle: End setMotion: MoveTo 215 43 self)
			)
			(36
				(ship setMotion: MoveTo 215 -5 self)
			)
			(37
				(= seconds 2)
			)
			(38
				(gCurRoom newRoom: 117)
			)
		)
	)
)

(instance KenMoveIntoBuilding of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(Ken setLoop: 7 setMotion: MoveTo 180 132 self)
			)
			(1
				(Ken setMotion: MoveTo 182 115)
			)
		)
	)
)

(instance MarkMoveIntoBuilding of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(Mark setMotion: MoveTo 180 132 self)
			)
			(1
				(Mark setMotion: MoveTo 182 115)
			)
		)
	)
)

(instance ScottMoveIntoBuilding of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(Scott setMotion: MoveTo 180 132 self)
			)
			(1
				(Scott setMotion: MoveTo 182 115)
			)
		)
	)
)

