;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 14)
(include sci.sh)
(use Main)
(use station)
(use RangeOsc)
(use eRS)
(use PAvoider)
(use Talker)
(use Polygon)
(use Feature)
(use ForwardCounter)
(use Sound)
(use Motion)
(use Actor)
(use System)

(public
	rm014 0
	sonnyLocker 1
	Officer 2
	Morris_Fudley 3
)

(local
	local0
	[local1 7] = [13 14 15 16 17 18 -1]
)

(instance rm014 of PQRoom
	(properties
		noun 47
		picture 14
	)

	(method (init)
		(self
			setRegions: 134 ; station
			addObstacle:
				((Polygon new:)
					type: PBarredAccess
					init: 0 0 319 0 319 189 38 189 47 169 117 169 246 138 242 114 204 89 130 114 115 110 109 105 109 99 193 73 158 57 57 84 57 114 98 101 117 114 0 152
					yourself:
				)
				((Polygon new:)
					type: PBarredAccess
					init: 147 147 106 163 68 137 114 122
					yourself:
				)
				((Polygon new:)
					type: PBarredAccess
					init: 221 123 180 136 142 112 188 100
					yourself:
				)
				((Polygon new:)
					type: PBarredAccess
					init: 159 77 138 83 127 75 149 69
					yourself:
				)
				((Polygon new:)
					type: PBarredAccess
					init: 96 94 74 101 68 92 89 86
					yourself:
				)
		)
		(fBenches init:)
		(fPartition init:)
		(fStalls init:)
		(fShowerArea init:)
		(fLockers init:)
		(fShowerHeads init:)
		(sonnyLocker init:)
		(locker2 init:)
		(if (> (gGame _detailLevel:) 2)
			(officer2 init:)
		)
		(super init:)
		(gLongSong number: 146 loop: -1 setVol: 64 play:)
		(gEgo init: posn: 52 162)
		(fudley init:)
		(self posn: 75 140 setScript: (ScriptID 896 1)) ; sWI
	)

	(method (doit &tmp temp0)
		(super doit: &rest)
		(cond
			(script 0)
			((& (= temp0 (gEgo onControl: 0)) $0004)
				(cond
					((not (OneOf global206 124 125))
						(gCurRoom setScript: bounceFromShower 0 1)
					)
					(local0
						(gCurRoom setScript: bounceFromShower 0 0)
					)
					(else
						(gCurRoom setScript: takeShower)
					)
				)
			)
			((& temp0 $0002)
				(cond
					((and (<= global211 1) (!= global206 0))
						(self setScript: bounceFromExit 0 2)
					)
					((and (<= 30 global211 31) (!= global206 1))
						(self setScript: bounceFromExit 0 3)
					)
					((and (<= 38 global211 39) (!= global206 0))
						(self setScript: bounceFromExit 0 2)
					)
					((and (== 52 global211) (!= global206 1))
						(self setScript: bounceFromExit 0 5)
					)
					((and (<= 90 global211 91) (!= global206 2))
						(self setScript: bounceFromExit 0 1)
					)
					(else
						(gLongSong fade: 0 10 4 1)
						(self setScript: exitRoom)
					)
				)
			)
		)
	)
)

(instance exitRoom of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo setMotion: MoveTo 52 162 self)
			)
			(1
				(gCurRoom newRoom: 13)
			)
		)
	)
)

(instance takeShower of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(SetFlag 14)
				(= local0 1)
				(gEgo setMotion: MoveTo 111 102 self)
			)
			(1
				(gEgo setMotion: MoveTo 138 96 self)
			)
			(2
				(gLongSong2 number: 144 loop: 1 play:)
				(gEgo
					setCycle: 0
					view: 126
					loop: 0
					cel: 0
					setCycle: End self
				)
			)
			(3
				(gLongSong2 number: 146 loop: -1 play:)
				(showerSpray init:)
				(gEgo
					view: 121
					loop: 2
					cel: 0
					posn: 145 92
					setCycle: End self
				)
			)
			(4
				(gEgo
					view: 121
					loop: 1
					cel: 0
					posn: 136 93
					setCycle: ForwardCounter 5 self
				)
			)
			(5
				(gEgo
					view: 121
					loop: 0
					cel: 0
					posn: 141 94
					setCycle: ForwardCounter 5 self
				)
			)
			(6
				(gEgo
					view: 121
					loop: 3
					cel: 0
					posn: 144 94
					setCycle: ForwardCounter 5 self
				)
			)
			(7
				(gEgo
					view: 126
					loop: 0
					cel: (gEgo lastCel:)
					posn: 138 96
					setCycle: Beg self
				)
				(gLongSong2 number: 145 loop: 1 play:)
				(showerSpray dispose:)
			)
			(8
				(gLongSong number: 146 loop: -1 setVol: 64 play:)
				(gEgo
					view: 121
					loop: 2
					cel: 7
					posn: 145 92
					setCycle: Beg self
				)
			)
			(9
				(if (gEgo has: 15) ; Hair_Dye
					(= global206 125)
					(= global211 91)
					(((gTheIconBar at: 0) cursor:) init:)
				)
				(NormalEgo -1 2)
				(gEgo posn: 138 96 setMotion: MoveTo 111 102 self)
			)
			(10
				(gEgo setMotion: MoveTo 127 120 self)
			)
			(11
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance bounceFromShower of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(switch register
					(0
						(gMessager say: 50 0 20 0 self) ; "You've already taken a shower."
					)
					(else
						(gMessager say: 50 0 21 0 self) ; "You should think about removing your clothes first before taking a shower. You'll get cleaner that way."
					)
				)
			)
			(1
				(gEgo setMotion: MoveTo 136 124 self)
			)
			(2
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance bounceFromExit of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gMessager say: 50 0 22 register self)
			)
			(1
				(gEgo setMotion: MoveTo 75 140 self)
			)
			(2
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance gab of Script
	(properties)

	(method (changeState newState &tmp [temp0 3])
		(switch (= state newState)
			(0
				(HandsOff)
				(gMessager say: 32 44 13 0 self) ; "Hey! Watch it, hairy!"
			)
			(1
				(self dispose:)
				(HandsOn)
			)
		)
	)
)

(instance showerAllTheTime of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(fudley loop: 0 cel: 0 posn: 76 109 setCycle: CT 4 1 self)
			)
			(1
				(fudley setCycle: RangeOsc 5 4 8 self)
			)
			(2
				(fudley loop: 1 cel: 2 posn: 80 110 setCycle: End self)
			)
			(3
				(fudley
					loop: 2
					cel: 0
					posn: 77 111
					setCycle: ForwardCounter 5 self
				)
			)
			(4
				(fudley setCycle: Beg self)
			)
			(5
				(fudley loop: 1 cel: 8 posn: 80 110 setCycle: Beg self)
				(= state -1)
			)
		)
	)
)

(instance officer2Script of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= seconds 5)
			)
			(1
				(soundFX number: 957 loop: 1 play: self)
			)
			(2
				(gLongSong number: 146 loop: -1 setVol: 64 play:)
				(officer2 setCycle: End self)
				(locker2 startUpd: setCycle: End self)
			)
			(3)
			(4
				(= seconds 3)
			)
			(5
				(locker2 stopUpd:)
				(officer2 loop: 1 cel: 0 posn: 225 110 setCycle: End self)
			)
			(6
				(= seconds 3)
			)
			(7
				(officer2 loop: 2 cel: 0 posn: 217 111 setCycle: End self)
			)
			(8
				(= seconds 3)
			)
			(9
				(officer2 loop: 3 cel: 0 posn: 221 110 setCycle: End self)
			)
			(10
				(= seconds 3)
			)
			(11
				(officer2 setCycle: Beg self)
			)
			(12
				(= seconds 3)
			)
			(13
				(officer2 loop: 4 cel: 0 posn: 221 110 setCycle: End self)
			)
			(14
				(= seconds 3)
			)
			(15
				(officer2
					loop: 5
					cel: (officer2 lastCel:)
					posn: 227 112
					setCycle: Beg self
				)
				(locker2 startUpd: setCycle: Beg self)
			)
			(16)
			(17
				(soundFX number: 958 loop: 1 play: self)
			)
			(18
				(gLongSong number: 146 loop: -1 setVol: 64 play:)
				(= seconds 3)
			)
			(19
				(proc134_4 officer2 110 6 216 110)
				(officer2 setMotion: MoveTo 269 131 self setAvoider: PAvoider)
			)
			(20
				(self dispose:)
			)
		)
	)
)

(instance officer2 of Officer
	(properties
		x 227
		y 112
		noun 32
		view 23
		lastPhrase -1
	)

	(method (init)
		(super init: &rest)
		(self gabScript: gab setScript: officer2Script)
	)
)

(instance fudley of Prop
	(properties
		x 76
		y 109
		noun 26
		view 120
		priority 5
		signal 16400
		detailLevel 2
	)

	(method (init)
		(super init: &rest)
		(spray2 init:)
		(self setScript: showerAllTheTime)
	)

	(method (doit)
		(if (< (gGame _detailLevel:) detailLevel)
			(= script 0)
		else
			(= script showerAllTheTime)
		)
		(super doit: &rest)
	)
)

(instance Officer of Narrator
	(properties
		x 150
		y 100
		talkWidth 130
		showTitle 1
	)

	(method (init)
		(= font gUserFont)
		(super init: &rest)
	)
)

(instance Morris_Fudley of Narrator
	(properties
		name {Morris Fudley}
		x 150
		y 100
		talkWidth 130
		showTitle 1
	)

	(method (init)
		(= font gUserFont)
		(super init: &rest)
	)
)

(instance sonnyLocker of Prop
	(properties
		x 160
		y 114
		noun 34
		approachX 145
		approachY 128
		view 119
		priority 7
		signal 20496
	)

	(method (init)
		(super init: &rest)
		(self stopUpd: approachVerbs: 4) ; Do
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(if (not (gCurRoom script:))
					(gCurRoom setScript: (ScriptID 141 0)) ; useLock
				)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance locker2 of Prop
	(properties
		x 222
		y 94
		noun 23
		view 119
		priority 2
		signal 16400
	)

	(method (init)
		(super init: &rest)
		(self stopUpd:)
	)
)

(instance showerSpray of Prop
	(properties
		x 140
		y 37
		view 123
		priority 7
		signal 16400
		detailLevel 2
	)

	(method (init)
		(super init: &rest)
		(self setCycle: Fwd)
	)
)

(instance spray1 of Prop ; UNUSED
	(properties
		x 145
		y 39
		view 123
		loop 1
		signal 16384
		detailLevel 2
	)

	(method (init)
		(super init: &rest)
		(self setCycle: Fwd)
	)
)

(instance spray2 of Prop
	(properties
		x 78
		y 53
		view 123
		signal 16384
		detailLevel 2
	)

	(method (init)
		(super init: &rest)
		(self setCycle: Fwd)
	)
)

(instance fBenches of Feature
	(properties
		noun 25
		sightAngle 40
		onMeCheck 16384
	)
)

(instance fPartition of Feature
	(properties
		noun 55
		sightAngle 40
		onMeCheck 4096
	)
)

(instance fStalls of Feature
	(properties
		noun 54
		sightAngle 40
		onMeCheck 2048
	)
)

(instance fShowerHeads of Feature
	(properties
		noun 49
		sightAngle 40
		onMeCheck 1024
	)
)

(instance fShowerArea of Feature
	(properties
		noun 45
		sightAngle 40
		onMeCheck 512
	)
)

(instance fLockers of Feature
	(properties
		noun 23
		sightAngle 40
		onMeCheck 8196
	)
)

(instance soundFX of Sound
	(properties)
)

