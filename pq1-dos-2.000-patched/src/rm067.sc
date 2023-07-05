;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 67)
(include sci.sh)
(use Main)
(use eRS)
(use Talker)
(use Polygon)
(use Feature)
(use Sound)
(use Motion)
(use Actor)
(use System)

(public
	rm067 0
	tPalmer 1
	Rusty 2
	Suspect 3
	Lawyer 4
)

(local
	local0
)

(instance rm067 of PQRoom
	(properties
		noun 1
		picture 67
	)

	(method (init)
		(gCurRoom
			addObstacle:
				((Polygon new:)
					type: PContainedAccess
					init: 254 175 257 169 176 148 172 152
					yourself:
				)
		)
		(gLongSong number: 671 loop: -1 play:)
		(judge init:)
		(recorder init: setCycle: Fwd)
		(lawyer init:)
		(bailiff init:)
		(criminal init:)
		(super init:)
		(bench init:)
		(chair init:)
		(door init:)
		(flag init:)
		(jBench init:)
		(recMach init:)
		(painting init:)
		(railing init:)
		(seats init:)
		(stand init:)
		(windows init:)
		(HandsOn)
		(NormalEgo)
		(gEgo posn: 276 172 init: setMotion: MoveTo 236 165 there)
		(self setScript: there)
	)

	(method (doit &tmp temp0)
		(cond
			(script
				(script doit:)
			)
			((== (= temp0 (gEgo onControl: 1)) 4)
				(HandsOff)
				(gEgo setMotion: MoveTo 276 172 there)
				(self setScript: there)
			)
		)
	)

	(method (dispose)
		(if (== local0 1)
			(gLongSong number: 672 play:)
		)
		(super dispose:)
	)
)

(instance there of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(1
				(if register
					(gLongSong fade: 0 30 30 1)
					(judge setScript: 0)
					(gCurRoom newRoom: 66)
					(self dispose:)
				else
					(= register
						(cond
							((and (IsFlag 23) (IsFlag 172)) 9)
							((IsFlag 172) 3)
							(else
								(switch (Random 2 4)
									(2 10)
									(3 12)
									(4 13)
								)
							)
						)
					)
					(gMessager say: 14 0 register 0 self)
				)
			)
			(2
				(HandsOn)
				(if (not (IsFlag 172))
					(waitForIt start: 2)
					(= local0 3)
				)
				(judge setScript: waitForIt)
				(if (== register 9)
					(= local0 1)
				)
				(= register 1)
				(self dispose:)
			)
		)
	)
)

(instance judge of Prop
	(properties
		x 61
		y 133
		noun 15
		view 585
		priority 10
		signal 16
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2 ; Talk
				(switch local0
					(0
						(self setScript: confront)
					)
					(1
						(gMessager say: 15 47 4 0 self) ; "Give it to the bailiff, Bonds."
					)
					(2
						(gMessager say: 15 2 8 0 self) ; "Judge Palmer is busy."
					)
					(3
						(gMessager say: 15 2 8 0 self) ; "Judge Palmer is busy."
					)
					(4
						(gMessager say: 15 2 7 0 self) ; "Leave Judge Palmer alone, Bonds. He'll probably hold you in contempt if you irritate him."
					)
				)
			)
			(27 ; Hoffman_File
				(if (== local0 1)
					(gMessager say: 15 47 4 0 self) ; "Give it to the bailiff, Bonds."
				else
					(gMessager say: 15 2 8 0 self) ; "Judge Palmer is busy."
				)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance confront of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gMessager say: 15 2 4 0 self) ; "Your honor, I'm Acting Detective Sonny Bonds. I'm sorry to disturb you like this, but it's most urgent that I get a No Bail Warrant for one of my prisoners, Marvin Hoffman."
			)
			(1
				(= local0 1)
				(SetFlag 23)
				(self dispose:)
				(judge setScript: waitForIt)
			)
		)
	)
)

(instance waitForIt of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= seconds 20)
			)
			(1
				(gMessager say: 14 0 5 0 self) ; "Bonds, I don't have all day."
			)
			(2
				(= seconds 15)
			)
			(3
				(gMessager say: 14 0 6 0 self) ; "Bonds, I have no time for people who have no respect. Get out of my courtroom."
				(if (== local0 1)
					(gLongSong number: 672 play:)
				)
				(= local0 4)
			)
			(4
				(= seconds 10)
			)
			(5
				(HandsOff)
				(gMessager say: 14 0 11 0 self) ; "You're this close to being held in contempt of court, Bonds. GO!!!"
			)
			(6
				(gEgo setMotion: MoveTo 276 172 there)
				(self setScript: there)
			)
		)
	)
)

(instance getWarrent of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(ClearFlag 23)
				(SetScore 173 7)
				(gEgo setMotion: MoveTo 183 153 self)
				(bailiff
					view: 570
					setCycle: Walk
					ignoreActors: 1
					setMotion: MoveTo 166 152 self
				)
			)
			(1)
			(2
				(gEgo setHeading: 270 self)
				(Load rsVIEW 586)
			)
			(3
				(gEgo view: 586 loop: 0 cel: 0 setCycle: CT 2 1)
				(bailiff view: 583 loop: 0 setCycle: End)
				(= ticks 35)
			)
			(4
				(gEgo setCycle: Beg self)
			)
			(5
				(gMessager say: 16 45 4 1 self) ; "Thank you, Detective."
			)
			(6
				(bailiff view: 570 setCycle: Walk setMotion: MoveTo 92 154 self)
			)
			(7
				(judge loop: 4 cel: 0 setCycle: End)
				(bailiff view: 583 setLoop: 2 setCycle: End self)
			)
			(8
				(judge loop: 3 cel: 0 setCycle: End)
				(bailiff loop: 1 cel: 7 setCycle: Beg)
				(= seconds 4)
			)
			(9
				(judge setCycle: End)
				(= seconds 3)
			)
			(10
				(gMessager say: 16 45 4 2 self) ; "Please approach the bench, Detective."
			)
			(11
				(NormalEgo)
				(gEgo setMotion: MoveTo 98 144 self)
			)
			(12
				(= cycles 2)
			)
			(13
				(gMessager say: 16 45 14 0 self) ; "Well, this certainly supports your theory, Detective Bonds. Your No Bail Warrant for Mr. Hoffman is granted."
			)
			(14
				(judge loop: 0 cel: 0)
				(= ticks 6)
			)
			(15
				(judge setCycle: End self)
			)
			(16
				(gLongSong fade: 0 1 1 1)
				(sfx number: 673 loop: 1 play:)
				(= ticks 10)
			)
			(17
				(judge loop: 4 cel: 0 setCycle: CT 0 -1 self)
				(bailiff loop: 2 cel: 0 setCycle: End)
			)
			(18
				(bailiff loop: 1 cel: 7 setCycle: CT 5 -1 self)
			)
			(19
				(= global211 58)
				(gEgo get: 12 setMotion: MoveTo 183 153 self) ; No_Bail_Warrant
				(= ticks 50)
			)
			(20
				(bailiff setCycle: Beg)
			)
			(21
				(= local0 2)
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance recorder of Actor
	(properties
		x 66
		y 171
		noun 7
		view 582
		cel 1
		priority 15
		signal 4112
	)
)

(instance lawyer of Actor
	(properties
		x 183
		y 138
		noun 17
		view 584
	)
)

(instance bailiff of Actor
	(properties
		x 92
		y 154
		noun 16
		view 583
		loop 1
		cel 8
	)

	(method (doVerb theVerb)
		(switch theVerb
			(27 ; Hoffman_File
				(if (== local0 1)
					(judge setScript: getWarrent)
				else
					(super doVerb: theVerb &rest)
				)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance criminal of Prop
	(properties
		x 197
		y 129
		noun 18
		view 584
		loop 1
	)
)

(instance tPalmer of Talker
	(properties
		x 20
		y 20
		view 1587
		cel 1
		talkWidth 140
		textX 115
		textY 1
	)

	(method (init)
		(= font gUserFont)
		(super init: 0 0 palmMouth &rest)
	)
)

(instance palmMouth of Prop
	(properties
		nsTop 48
		nsLeft 32
		view 1587
		loop 1
	)
)

(instance Rusty of Narrator
	(properties
		showTitle 1
		back 42
	)
)

(instance Suspect of Narrator
	(properties
		x 130
		y 70
		showTitle 1
		back 20
	)
)

(instance Lawyer of Narrator
	(properties
		showTitle 1
		back 62
	)
)

(instance bench of Feature
	(properties
		noun 9
		onMeCheck 8
	)
)

(instance chair of Feature
	(properties
		noun 5
		onMeCheck 8
	)
)

(instance door of Feature
	(properties
		noun 12
		onMeCheck 32
	)
)

(instance flag of Feature
	(properties
		noun 3
		onMeCheck 64
	)
)

(instance jBench of Feature
	(properties
		noun 2
		onMeCheck 8
	)
)

(instance recMach of Feature
	(properties
		noun 8
		onMeCheck 256
	)
)

(instance painting of Feature
	(properties
		noun 4
		onMeCheck 512
	)
)

(instance railing of Feature
	(properties
		noun 13
		onMeCheck 1024
	)
)

(instance seats of Feature
	(properties
		noun 10
		onMeCheck 2048
	)
)

(instance stand of Feature
	(properties
		noun 6
		onMeCheck 4096
	)
)

(instance windows of Feature
	(properties
		noun 11
		onMeCheck 8192
	)
)

(instance sfx of Sound
	(properties)
)

