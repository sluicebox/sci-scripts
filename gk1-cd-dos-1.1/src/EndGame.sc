;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 899)
(include sci.sh)
(use Main)
(use n013)
(use GKNarrator)
(use Array)
(use Talker)
(use RandCycle)
(use MCyc)
(use PolyPath)
(use Polygon)
(use Feature)
(use LoadMany)
(use StopWalk)
(use Rev)
(use Grooper)
(use Orbit)
(use Jump)
(use Motion)
(use Game)
(use Actor)
(use System)

(public
	EndGame 0
)

(local
	local0
	local1
	local2
	local3
	local4
	local5
	local6
	local7
	local8
	local9
	local10
	local11
	local12
	local13
	local14 = 95
	local15
	local16
	local17
)

(instance EndGame of Room
	(properties
		modNum 900
		noun 15
		picture 900
		style 14
		exitStyle 13
	)

	(method (init)
		(super init:)
		(if (DoSound sndGET_AUDIO_CAPABILITY)
			(Load 140 482) ; WAVE
		)
		(if (== (GK detailLevel:) 3)
			(gGkSound2 setLoop: -1 number: 482 play:)
		)
		(gGkMusic1
			number: 480
			setLoop: -1
			stop:
			play:
			setVol: 0
			fade: (gGkMusic1 musicVolume:) 5 10 0
		)
		(Load rsMESSAGE 900)
		(= local16 1)
		(gCurRoom
			addObstacle:
				((Polygon new:)
					type: PBarredAccess
					init: 114 72 115 86 94 88 81 84 84 71 98 69
					yourself:
				)
				((Polygon new:)
					type: PBarredAccess
					init: 36 94 29 101 20 108 6 106 6 92 23 87
					yourself:
				)
				((Polygon new:)
					type: PBarredAccess
					init: 139 85 169 86 187 93 185 108 151 110 126 106 117 96
					yourself:
				)
				((Polygon new:)
					type: PBarredAccess
					init: 281 91 307 94 313 105 298 108 277 96
					yourself:
				)
				((Polygon new:)
					type: PBarredAccess
					init: 183 79 168 71 184 62 225 64 235 70 225 77 210 80
					yourself:
				)
		)
		(Load rsMESSAGE 900)
		(LoadMany
			rsVIEW
			835
			888
			889
			8881
			8882
			891
			8911
			8912
			8913
			892
			8920
			8921
			8931
			8932
			894
		)
		((ScriptID 898 4) init: setCycle: Fwd) ; xc1
		((ScriptID 898 5) init: setCycle: Fwd) ; xc2
		(if (> (GK detailLevel:) 1)
			((ScriptID 898 6) init: setCycle: Fwd) ; xc3
			((ScriptID 898 10) init: setCycle: Fwd) ; xc7
		)
		(if (> (GK detailLevel:) 2)
			((ScriptID 898 7) init: setCycle: Fwd) ; xc4
			((ScriptID 898 8) init: setCycle: Fwd) ; xc5
			((ScriptID 898 9) init: setCycle: Fwd) ; xc6
		)
		(gWalkHandler add: self)
		((ScriptID 898 15) init:) ; xlDrums
		((ScriptID 898 16) init:) ; xrDrums
		(= local17
			(IntArray
				with:
					0
					1
					34
					138
					0
					2
					63
					136
					0
					3
					93
					136
					0
					4
					101
					136
					0
					5
					130
					134
					0
					6
					163
					132
					0
					7
					170
					132
					0
					8
					199
					131
					0
					9
					226
					129
					0
					10
					257
					121
					0
					11
					257
					121
					32768
			)
		)
		((ScriptID 898 3) init: setCycle: Fwd) ; xdrummer
		((ScriptID 898 19) init:) ; xpole
		((ScriptID 898 17) init:) ; xtable
		((ScriptID 898 18) init:) ; xfirePit
		((ScriptID 898 2) init: setCycle: Fwd) ; xfire
		((ScriptID 898 12) setPri: 180 init:) ; xsnake_cage
		((ScriptID 898 13) setPri: 180 init:) ; xchicken_cage
		((ScriptID 898 14) init: setPri: 1) ; xveve
		(gEgo
			view: 888
			setCel: 0
			setLoop: 0 1
			setSpeed: 6
			posn: 0 0
			init:
			actions: gabeActions
			ignoreActors: 1
			get: 69 ; talisman
			setScript: sPart1
		)
	)

	(method (doit)
		(super doit:)
		(if local16
			(cond
				((and (>= (GK detailLevel:) 2) local15)
					(if (> local14 85)
						(-= local14 5)
					else
						(= local15 0)
					)
				)
				((< local14 100)
					(+= local14 5)
				)
				(else
					(= local15 1)
				)
			)
			(Palette 2 0 255 local14) ; PalIntensity
		)
	)

	(method (doVerb theVerb)
		(if (not (OneOf theVerb 8 6 12 10 11 9 7 13)) ; Operate, Open, Pickup, Ask, Talk, Move, Look, Walk
			(gMessager say: noun 0 4 0 0 900) ; "That won't help now!"
			(return 1)
		else
			(switch theVerb
				(7 ; Look
					(cond
						(local8
							(gMessager say: 9 theVerb 28 0 0 900) ; "Malia's fingers barely grip the edge of the crevasse!"
						)
						(local7
							(gMessager say: 11 theVerb 25 0 0 900) ; "Mosely looks ready to defend Grace with his life."
						)
						(else
							(gMessager say: noun theVerb 4 0 0 900) ; "The circle has become hellishly surreal as animals whirl, oiled flesh gleams, and drums pound in ecstasy!"
						)
					)
					(return 1)
				)
				(13 ; Walk
					(gMessager say: 6 13 4 0 0 900) ; "There's no escaping now!"
					(return 1)
				)
				(else
					(gMessager say: noun theVerb 4 0 0 900)
					(return 1)
				)
			)
		)
	)

	(method (dispose)
		(gWalkHandler delete: self)
		(local17 dispose:)
		(gGkSound2 stop:)
		(super dispose:)
	)
)

(instance sMoselyPart1 of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gMessager say: 13 0 15 1 self 900) ; "Come, Damballah! Come Ogoun Badagris!"
			)
			(1
				(gMessager say: 13 0 15 2 self 900) ; "D\83bala-w\8ado, papa! M'ap\82 r\82l\82 kul\8av-o!"
			)
			(2
				(gMessager say: 13 0 15 3 self 900) ; "(WHISPERING URGENTLY)Damn it! She's already being ridden by Tetelo!"
			)
			(3
				(gMessager say: 13 0 15 4 self 900) ; "(WHISPERING LOUDLY)What? What? But you said...."
			)
			(4
				(gMessager say: 13 0 15 5 self 900) ; "(WHISPERING)Shhh! Yeah, yeah, I know."
			)
			(5
				(gMessager say: 13 0 15 6 self 900) ; "(WHISPERING)Great! Now what?"
			)
			(6
				(gMessager say: 13 0 15 7 self 900) ; "(WHISPERING)I don't know!"
			)
			(7
				(malia setMotion: MoveTo 216 138 self)
				(gMessager say: 13 0 15 8 self 900) ; "R\82l\82 loa yo! Badagri j\82n\82ral s\83gl\83!"
			)
			(8 0)
			(9
				(gMessager say: 13 0 15 9 self 900) ; "H\82, \83h\82, h\82 \83h\82, h\82 h\82 h\82!"
			)
			(10
				(gMessager say: 13 0 15 10 self 900) ; "Dya r\82l\82, dy dya k\82k\82k\82k\82, Tetelo r\82l\82!"
			)
			(11
				(self dispose:)
			)
		)
	)
)

(instance sNoMoselyPart1 of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gMessager say: 13 0 36 1 self 900) ; "Come, Damballah! Come Ogoun Badagris!"
			)
			(1
				(gMessager say: 13 0 36 2 self 900) ; "D\83bala-w\8ado, papa! M'ap\82 r\82l\82 kul\8av-o!"
			)
			(2
				(gMessager say: 13 0 36 3 self 900) ; "Uh-oh! Malia is already being ridden by Tetelo!"
			)
			(3
				(malia setMotion: MoveTo 216 138 self)
				(gMessager say: 13 0 36 4 self 900) ; "R\82l\82 loa yo! Badagri j\82n\82ral s\83gl\83!"
			)
			(4 0)
			(5
				(gMessager say: 13 0 36 5 self 900) ; "H\82, \83h\82, h\82 \83h\82, h\82 h\82 h\82!"
			)
			(6
				(gMessager say: 13 0 36 6 self 900) ; "Dya r\82l\82, dy dya k\82k\82k\82k\82, Tetelo r\82l\82!"
			)
			(7
				(self dispose:)
			)
		)
	)
)

(instance sPart1 of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(= gNarrator endGameNarrator)
				(= cycles 2)
			)
			(1
				(gEgo
					posn: 16 200
					setCycle: Walk
					setMotion: MoveTo 37 154 self
				)
			)
			(2
				(SetFlag 200)
				(gEgo setMotion: MoveTo 75 141 self)
				(if (IsFlag 351)
					(mosely
						view: 888
						setCel: 0
						setLoop: 2 1
						posn: 16 200
						init:
						ignoreActors: 1
						setCycle: Walk
						setMotion: MoveTo 26 152
					)
				)
			)
			(3
				(gEgo setCel: 0 setLoop: 3 1 posn: 78 138)
				(if (IsFlag 351)
					(mosely setMotion: MoveTo 46 137 self)
				else
					(= cycles 1)
				)
			)
			(4
				(if (IsFlag 351)
					(mosely setCel: 1 setLoop: 3 0 posn: 46 137)
				)
				(drJohn init: setCycle: Walk setMotion: MoveTo 1 138 self)
			)
			(5
				(drJohn setPri: 115 setMotion: MoveTo 127 103 self)
			)
			(6
				(drJohn setCel: 0 setLoop: 1 1 setCycle: End self)
			)
			(7
				(grace init: setPri: 115)
				(drJohn
					view: 835
					setCel: 6
					setLoop: 8 0
					setLooper: Grooper
					ignoreActors: 1
					setCycle: StopWalk -1
				)
				(= cycles 1)
			)
			(8
				(Face drJohn 127 150 self)
			)
			(9
				(malia
					init:
					setCel: 0
					setLoop: 0 1
					setCycle: Fwd
					ignoreActors: 1
					setMotion: MoveTo 216 138 self
				)
			)
			(10
				(drJohn
					fixPriority: 1
					setPri: 116
					setMotion: MoveTo 177 142 self
				)
			)
			(11
				(malia view: 8912 setCel: 0 setLoop: 2 1 posn: 206 140)
				(drJohn
					fixPriority: 0
					view: 8912
					setCel: 0
					setLoop: 0 1
					setCycle: CT 3 1 self
				)
			)
			(12
				(gGkSound1 setLoop: 1 number: 871 play:)
				(= seconds 1)
			)
			(13
				(drJohn setCycle: CT 7 1 self)
			)
			(14
				(malia hide:)
				(drJohn setCel: 8 setCycle: End self)
				(UpdateScreenItem drJohn)
			)
			(15
				(drJohn
					view: 835
					setCel: 0
					setLoop: 0
					posn: 166 141
					setLooper: Grooper
					setCycle: StopWalk -1
				)
				(malia
					view: 8912
					show:
					posn: 216 138
					setCel: 0
					setLoop: 1 1
					setCycle: End self
				)
			)
			(16
				(malia
					view: 892
					setCel: 0
					setLoop: 0 1
					setCycle: Fwd
					setMotion: MoveTo 220 100
				)
				(if (IsFlag 351)
					(self setScript: sMoselyPart1 self)
				else
					(self setScript: sNoMoselyPart1 self)
				)
			)
			(17
				(malia
					view: 8912
					posn: 216 138
					setCel: 3
					setLoop: 1 1
					setCycle: Beg self
				)
			)
			(18
				(malia hide:)
				(drJohn
					view: 8912
					setCel: 12
					setLoop: 0 1
					posn: 177 142
					setCycle: CT 8 -1 self
				)
				(UpdateScreenItem drJohn)
			)
			(19
				(malia view: 8912 setCel: 0 setLoop: 2 1 show: posn: 206 140)
				(drJohn view: 8913 setCel: 0 setLoop: 6 1 posn: 166 141)
				(= cycles 1)
			)
			(20
				(malia setScript: sDance)
				(= cycles 6)
			)
			(21
				(drJohn setCycle: Fwd setMotion: MoveTo 230 107 self)
			)
			(22
				(drJohn view: 8913 setCel: 0 setLoop: 0 1 setCycle: Fwd)
				(= seconds 6)
			)
			(23
				(drJohn view: 8913 setCel: 0 setLoop: 1 1 setCycle: CT 3 1 self)
			)
			(24
				((ScriptID 898 11) init:) ; xdeadChicks
				(drJohn setCel: 4 setCycle: End self)
			)
			(25
				(drJohn
					view: 835
					setCel: 0
					setLoop: 0 0
					setLooper: Grooper
					setCycle: StopWalk -1
					setMotion: PolyPath 180 82 self
				)
			)
			(26
				(drJohn setMotion: PolyPath 143 82 self)
			)
			(27
				(drJohn setMotion: MoveTo 129 100 self)
			)
			(28
				(Face drJohn (ScriptID 898 13) self) ; xchicken_cage
			)
			(29
				(drJohn
					view: 894
					fixPriority: 1
					setPri: 116
					setCel: 0
					setLoop: 0 1
					posn: 125 100
					setSpeed: 12
					setCycle: End self
				)
			)
			(30
				(self setScript: sPaintGrace self)
				(if (IsFlag 351)
					(gMessager say: 13 0 15 11 self 900) ; "(WHISPERING LOUDLY, ANGRY)If he TOUCHES her....!"
				else
					(self cue:)
				)
			)
			(31
				(if (IsFlag 351)
					(gMessager say: 13 0 15 12 self 900) ; "Shhhh!"
				else
					(= cycles 1)
				)
			)
			(32 0)
			(33
				(malia
					view: 8882
					setCel: 0
					setLoop: 1 1
					setScript: 0
					setMotion: PolyPath 169 80 self
				)
			)
			(34
				(malia setCel: 0 setLoop: 2 1 setMotion: MoveTo 182 94 self)
			)
			(35
				(malia setCel: 0 setLoop: 3 1 posn: 177 97 setCycle: End self)
			)
			(36
				(malia
					view: 8920
					fixPriority: 1
					setPri: 116
					setCel: 0
					setLoop: 0 1
					posn: 164 74
					setCycle: End self
				)
			)
			(37
				(malia setCel: 0 setLoop: 1 1 setCycle: Fwd)
				(if (IsFlag 351)
					(gMessager say: 13 0 15 13 self 900) ; "(RRCC. RERECORD. PROUNCE BAD-A-GREE, WITH ACCENT ON GREE. EVIL PRAYING)Oh, great Badagri, take this sacrifice!"
				else
					(gMessager say: 13 0 36 7 self 900) ; "(RRCC. RERECORD. PROUNCE BAD-A-GREE, WITH ACCENT ON GREE. EVIL PRAYING)Oh, great Badagri, take this sacrifice!"
				)
			)
			(38
				(if (IsFlag 351)
					(gMessager say: 13 0 15 14 self 900) ; "(URGENT, WHISPERING LOUDLY)DO something! Quick!"
				else
					(gMessager say: 13 0 36 8 self 900) ; "Gabriel had better do something quick!"
				)
			)
			(39
				(= gNarrator GKNarrator)
				(= cycles 2)
			)
			(40
				(gGame handsOn:)
				(= local5 1)
				(malia setCel: 0 setLoop: 2 1 setCycle: Fwd)
				(= seconds 10)
			)
			(41
				(if (gTalkers size:)
					(-- state)
				)
				(= cycles 1)
			)
			(42
				(= local5 0)
				(if local11
					(self setScript: sGraceLives self)
				else
					(self setScript: sGraceDies)
				)
			)
			(43
				(if (IsFlag 351)
					(gEgo setScript: sPart2)
				else
					(gEgo setScript: sDrJohnPunchGrace)
				)
			)
		)
	)
)

(instance sPaintGrace of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(drJohn setCel: 0 setLoop: 1 1 setCycle: End self)
			)
			(1
				(drJohn setCel: 0 setLoop: 2 1 setCycle: End self)
			)
			(2
				(grace view: 8920 setCel: 0 setLoop: 3 1)
				(drJohn
					view: 835
					setCel: 0
					setLoop: 0
					fixPriority: 0
					setSpeed: 6
					setLooper: Grooper
					setCycle: StopWalk -1
					setMotion: MoveTo 124 94 self
				)
			)
			(3
				(Face drJohn 130 100 self)
			)
			(4
				(self dispose:)
			)
		)
	)
)

(instance sPart2 of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gCast eachElementDo: #show)
				(malia
					view: 8992
					setCel: 0
					setLoop: 2 1
					posn: 204 95
					fixPriority: 0
				)
				(mosely view: 895 setCel: 0 setLoop: 0 1 posn: 29 138)
				(drJohn
					setPri: 116
					view: 8941
					setCel: 0
					setLoop: 0 1
					noun: 0
					posn: 124 103
				)
				(gEgo posn: 78 128)
				(grace z: 0 view: 895 setCel: 0 setLoop: 1 1 posn: 257 121)
				((ScriptID 898 0) init: hide:) ; xlid_up
				((ScriptID 898 1) init: hide:) ; xlid_glow
				(gCurRoom drawPic: 900)
				(= cycles 2)
			)
			(1
				(mosely setCycle: MCyc local17 self)
			)
			(2
				(mosely setCel: 12 posn: 257 121)
				(grace hide:)
				(UpdateScreenItem mosely)
				(= cycles 1)
			)
			(3
				(mosely setCel: 0 setLoop: 2 1 setCycle: End self)
			)
			(4
				(drJohn setCycle: CT 6 1 self)
			)
			(5
				((ScriptID 898 0) show:) ; xlid_up
				(drJohn setCel: 7 setCycle: End self)
			)
			(6
				(drJohn fixPriority: 1 setPri: 116)
				((ScriptID 898 1) ; xlid_glow
					show:
					setPri: 115
					fixPriority: 1
					setCycle: Fwd
				)
				(= seconds 3)
			)
			(7
				((ScriptID 898 1) dispose:) ; xlid_glow
				(gGkSound1 setLoop: 1 number: 734 play:)
				((ScriptID 898 0) setCycle: CT 5 1 self) ; xlid_up
			)
			(8
				(idol init:)
				((ScriptID 898 0) cel: 6) ; xlid_up
				(= cycles 3)
			)
			(9
				(malia view: 8981 setCel: 0 setLoop: 1 1 setCycle: RandCycle)
				(gMessager say: 9 124 43 3 self 900) ; "(TO GABRIEL--RAGING)You have killed my chosen one, Witch-hunter!"
			)
			(10
				(gMessager say: 9 124 43 4 self 900) ; "For that, you shall pay!"
			)
			(11
				(malia setCel: 0 setCycle: 0)
				(mosely
					view: 8950
					setSpeed: 10
					setCel: 0
					setLoop: 0 1
					posn: 240 135
					setCycle: End self
				)
			)
			(12
				(malia view: 8950 setCel: 0 setLoop: 2 1 setCycle: End self)
			)
			(13
				(gGkSound1 setLoop: 1 number: 909 play:)
				(mosely setCel: 0 setLoop: 1 1 setCycle: End self)
			)
			(14
				(malia
					view: 8992
					setCel: 0
					setLoop: 0 1
					fixPriority: 0
					setCycle: Fwd
					setMotion: MoveTo 166 130 self
				)
			)
			(15
				(malia view: 8981 setCel: 0 setLoop: 1 1 setCycle: RandCycle)
				(gMessager say: 9 124 43 5 self 900) ; "But first, these intruders shall DIE! Give me the talisman, Witch-hunter, or your friends will die horribly--right now!"
			)
			(16
				(malia setCel: 0 setCycle: 0)
				(gGame handsOn:)
				(= local7 1)
				(= seconds 10)
			)
			(17
				(if (gTalkers size:)
					(-- state)
				)
				(= cycles 1)
			)
			(18
				(gGame handsOff:)
				(= local7 0)
				(if local12
					(gEgo setScript: sPart3)
				else
					(= cycles 1)
				)
			)
			(19
				(if local13
					(self setScript: sTossToMalia self)
				else
					(gMessager say: 13 0 19 1 self 900) ; "Very well. I should have known you wouldn't lift a finger to save your friends!"
					(malia
						view: 8981
						setCel: 0
						setLoop: 1 1
						setCycle: RandCycle
					)
				)
			)
			(20
				(if local13
					(= cycles 1)
				else
					(malia view: 8950 setCel: 0 setLoop: 2 1 setCycle: End self)
				)
			)
			(21
				(gMessager say: 13 0 19 2 self 900) ; "(WATCHING GRACE AND MOSELY DIE)NO!"
				(gGkSound1 setLoop: 1 number: 906 play:)
				(mosely view: 899 setCel: 0 setLoop: 1 1 setCycle: End self)
			)
			(22 0)
			(23
				(if local13
					(= cycles 1)
				else
					(malia
						view: 8981
						setCel: 0
						setLoop: 1 1
						setCycle: RandCycle
					)
					(gMessager say: 13 0 30 1 self 900) ; "Now it is between you and I. I want that talisman!"
				)
			)
			(24
				(malia view: 898 setCel: 0 setLoop: 0 1 setCycle: End self)
			)
			(25
				(gGkSound1 setLoop: 1 number: 915 play:)
				(malia setCel: 0 setLoop: 1 1 setCycle: End self)
			)
			(26
				(if local13
					(+= state 2)
					(= cycles 1)
				else
					(malia setCel: 0 setLoop: 2 1 setCycle: End self)
					(UpdateScreenItem malia)
					(gEgo hide:)
				)
			)
			(27
				(gMessager say: 13 0 30 2 self 900) ; "(SHE GETS THE TALISMAN FROM HIM--HE SHOUTS IN PROTEST)The talisman!"
			)
			(28
				(gGkSound1 setLoop: 1 number: 915 play:)
				(malia setCel: 0 setLoop: 1 1 setCycle: End self)
				(UpdateScreenItem malia)
				(gEgo view: 898 setCel: 0 setLoop: 3 1 show:)
			)
			(29
				(malia setCel: 0 setLoop: 4 1 setCycle: End self)
				(UpdateScreenItem malia)
				(gEgo hide:)
				(gGkMusic1
					number: 901
					setLoop: 1
					stop:
					setVol: (gGkMusic1 musicVolume:)
					play:
				)
			)
			(30
				(gMessager say: 13 0 30 3 self 900) ; "(EVIL LAUGH)Hah, hah, hah, hah, hah!"
			)
			(31
				(= seconds 3)
			)
			(32
				(gCurRoom newRoom: 770) ; deathRm
			)
		)
	)
)

(instance sTossToMalia of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gMessager say: 9 124 25 1 self 900) ; "(GIVING HIS FAMILY TALISMAN TO TETELO TO SAVE GRACE & MOSELY)All right. Take it."
			)
			(1
				(gEgo
					view: 8981
					setCel: 0
					setLoop: 0 1
					setCycle: CT 4 1 self
				)
				(gGkSound1 setLoop: 1 number: 910 play:)
			)
			(2
				(malia hide:)
				(gEgo setCel: 5 setCycle: End self)
				(UpdateScreenItem gEgo)
				(gMessager say: 9 124 25 2 self 900) ; "Gabriel, no!"
			)
			(3 0)
			(4
				(malia show:)
				(gMessager say: 9 124 25 3 self 900) ; "Thank you, Witch-hunter. Now die like the dog that you are!"
				(gEgo view: 8952 setCel: 0 setLoop: 0 1)
			)
			(5
				(malia view: 899 setCel: 0 setLoop: 0 1 setCycle: End self)
			)
			(6
				(self dispose:)
			)
		)
	)
)

(instance sDaggerOnMalia of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gMessager say: 9 101 25 1 self 900) ; "(THREATENS HER WITH DAGGER)I'll kill you, Tetelo!"
			)
			(1
				(gMessager say: 9 101 25 2 0 900) ; "(OUTRAGED)You dare attack ME?"
				(gEgo
					view: 8991
					setCel: 0
					setLoop: 0 1
					posn: 131 129
					setSpeed: 12
					setCycle: End self
				)
				(UpdateScreenItem gEgo)
				(malia hide:)
			)
			(2
				(gGkMusic1
					number: 901
					setLoop: 1
					stop:
					setVol: (gGkMusic1 musicVolume:)
					play:
				)
				(gEgo setCel: 0 setLoop: 1 1 setCycle: End self)
			)
			(3
				(= seconds 3)
			)
			(4
				(gCurRoom newRoom: 770) ; deathRm
			)
		)
	)
)

(instance sDaggerOnMalia2 of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo
					view: 8961
					setCel: 0
					setLoop: 0 1
					posn: 153 117
					setSpeed: 9
					setCycle: End self
				)
			)
			(1
				(gMessager say: 9 101 28 1 self 900) ; "You will die now, once and for all!"
				(gEgo
					setCel: 0
					setLoop: 2 1
					posn: 160 120
					setCycle: CT 5 1 self
				)
			)
			(2
				(malia hide:)
				(gEgo setCel: 6 setCycle: End self)
				(UpdateScreenItem gEgo)
			)
			(3 0)
			(4
				(gMessager say: 9 101 28 2 self 900) ; "Tetelo was right! You betrayed me!"
			)
			(5
				(gEgo
					view: 8964
					posn: 160 120
					setCel: 0
					setLoop: 0 1
					setCycle: End self
				)
				(UpdateScreenItem gEgo)
				(malia
					view: 8963
					setSpeed: 9
					ignoreActors: 1
					show:
					setCel: 0
					setLoop: 1 1
					posn: 160 120
				)
			)
			(6
				(malia setCycle: CT 9 1 self)
			)
			(7
				(gEgo posn: 1000 0)
				(malia setCel: 10 setCycle: End self)
				(gGkSound1 setLoop: 1 number: 915 play:)
			)
			(8
				(Palette 2 0 255 0) ; PalIntensity
				(FrameOut)
				(gCast eachElementDo: #hide)
				(= cycles 2)
			)
			(9
				(self setScript: (ScriptID 894 0) self) ; sCutPanel4
			)
			(10
				(SetFlag 407)
				(gCurRoom newRoom: 670)
			)
		)
	)
)

(instance sDrJohnPunchGrace of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(drJohn setMotion: MoveTo 113 115 self)
			)
			(1
				(drJohn hide:)
				(grace
					view: 8933
					setCel: 0
					setLoop: 0 1
					posn: 134 113
					z: 0
					setCycle: End self
				)
				(UpdateScreenItem grace)
			)
			(2
				(gMessager say: 9 124 42 1 self 900) ; "(WATCHING GRACE BEING KILLED)GRACE, NO!"
				(grace setCel: 0 setLoop: 1 1 setCycle: End self)
			)
			(3 0)
			(4
				(gMessager say: 9 124 42 2 self 900) ; "(TO DR JOHN)And now, get the intruder! I cannot touch him while he bears the talisman, but YOU can!"
				(grace setCel: 0 setLoop: 2 1)
				(drJohn show:)
			)
			(5
				(drJohn
					setCel: 0
					setLoop: 5 1
					setCycle: Fwd
					setPri: 135
					fixPriority: 1
					setMotion: PolyPath 109 138 self
				)
			)
			(6
				(gGkMusic1
					number: 901
					setLoop: 1
					stop:
					setVol: (gGkMusic1 musicVolume:)
					play:
				)
				(drJohn hide:)
				(gEgo view: 8971 setCel: 0 setLoop: 1 1 setCycle: End self)
				(UpdateScreenItem gEgo)
			)
			(7
				(gMessager say: 9 124 42 3 self 900) ; "(EVIL LAUGH)Hah, hah, hah, hah, hah!"
			)
			(8
				(gCurRoom newRoom: 770) ; deathRm
			)
		)
	)
)

(instance sPart3 of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gMessager say: 11 124 25 1 self 900) ; "(IS GOING TO THROW THE TALISMAN TO MOSELY OVER HER HEAD)Sure, Tetelo! You want the talisman? Here, catch!"
			)
			(1
				(gEgo
					setCel: 0
					view: 8951
					setLoop: 0 1
					posn: 78 128
					setCycle: CT 4 1 self
				)
			)
			(2
				(talisman
					init:
					posn: 110 84
					setCycle: Fwd
					setMotion: JumpTo 209 77 self
				)
				(UpdateScreenItem talisman)
				(gGkSound1 setLoop: 1 number: 910 play:)
				(gEgo setCel: 5 setCycle: End)
				(mosely view: 8951 setCel: 0 setLoop: 1 1 setCycle: CT 4 1)
			)
			(3
				(talisman dispose:)
				(mosely setCel: 5 setCycle: End self)
				(UpdateScreenItem mosely)
				(gMessager say: 11 124 25 2 self 900) ; "(RAGE)AHHHHHHH!"
			)
			(4
				(DisposeScript 64991)
			)
			(5
				(gMessager say: 11 124 25 3 self 900) ; "(TO MOSELY)Go on! Get Grace out of here! The talisman will protect you!"
				(gEgo view: 8952 setCel: 0 setLoop: 0 1 setCycle: End self)
			)
			(6 0)
			(7
				(gMessager say: 11 124 25 4 self 900) ; "What about...."
				(mosely view: 8952 setCel: 0 setLoop: 1 1 setCycle: End self)
			)
			(8 0)
			(9
				(gMessager say: 11 124 25 5 self 900) ; "Just GO!"
			)
			(10
				(mosely setCel: 0 setLoop: 2 1 setCycle: End self)
			)
			(11
				(mosely setCel: 0 setLoop: 3 1 setCycle: End self)
			)
			(12
				(mosely dispose:)
				(grace dispose:)
				(gMessager say: 11 124 25 6 self 900) ; "(TETELO TURNS ON NOW UNARMED GABRIEL)You are unarmed now, Witch-hunter!"
			)
			(13
				(malia
					view: 8992
					setCel: 0
					setLoop: 1 1
					fixPriority: 1
					priority: 116
					setCycle: Fwd
					setMotion: MoveTo 141 113 self
				)
			)
			(14
				(gMessager say: 11 124 25 7 self 900) ; "(COMMANDING)Approach me and kneel!"
				(malia
					view: 8953
					setCel: 0
					setLoop: 0 1
					posn: 137 109
					setCycle: forRepeat
				)
			)
			(15
				(gEgo view: 8953 setCel: 0 setLoop: 1 1 setCycle: End self)
			)
			(16
				(gEgo hide:)
				(malia
					setCel: 0
					setLoop: 2 1
					fixPriority: 1
					setPri: 116
					setCycle: End self
				)
				(UpdateScreenItem malia)
			)
			(17
				(gMessager say: 11 124 25 8 self 900) ; "(IS IN THE GRIP OF TETELO)Malia??? Are you...<gasp>there?"
				(malia setCel: 0 setLoop: 3 1 setCycle: End self)
			)
			(18 0)
			(19
				(gMessager say: 11 124 25 9 self 900) ; "(STRUGGLING TO FIGHT EVIL SPIRIT POSSESSION)She's...too...powerful!"
			)
			(20
				(= local6 1)
				(gGame handsOn:)
				(= seconds 10)
			)
			(21
				(if (gTalkers size:)
					(-- state)
				)
				(= cycles 1)
			)
			(22
				(= local6 0)
				(gGame handsOff:)
				(if local10
					(gEgo setScript: sPart4)
				else
					(= cycles 1)
				)
			)
			(23
				(gMessager say: 13 0 31 1 self 900) ; "DIE!"
			)
			(24
				(gGkMusic1
					number: 901
					setLoop: 1
					stop:
					setVol: (gGkMusic1 musicVolume:)
					play:
				)
				(gMessager say: 13 0 31 2 self 900) ; "(HIS THROAT IS SLIT)<gurgle>"
				(malia view: 8954 setCel: 0 setLoop: 0 1 setCycle: End self)
			)
			(25 0)
			(26
				(= seconds 3)
			)
			(27
				(gCurRoom newRoom: 770) ; deathRm
			)
		)
	)
)

(instance sPart4 of Script
	(properties)

	(method (changeState newState &tmp temp0)
		(switch (= state newState)
			(0
				(gMessager say: 7 12 26 1 self 900) ; "(HORRIFIED! CAN'T BELIEVE SHE DIDN'T SEE THIS COMING)NO!!! STOP!!!!"
				(malia setCel: 0 view: 8955 setLoop: 0 1 setCycle: CT 2 1 self)
			)
			(1
				(idol dispose:)
			)
			(2
				(malia setCel: 3 setCycle: End self)
				(gGkSound1 setLoop: 1 number: 911 play:)
			)
			(3
				(for ((= temp0 10)) (>= temp0 0) ((-= temp0 1))
					(ShakeScreen 5 ssUPDOWN)
					(Palette 2 0 255 (Random 5 75)) ; PalIntensity
					(FrameOut)
				)
				(ShakeScreen 5 ssUPDOWN)
				(gGkSound1 setLoop: -1 number: 912 play:)
				(gGkMusic1
					number: 903
					setLoop: -1
					stop:
					play:
					setVol: 0
					fade: (gGkMusic1 musicVolume:) 5 10 0
				)
				(malia view: 8956 setCel: 0 setLoop: 0 1 setCycle: forRepeat)
				(gEgo
					view: 8956
					setCel: 0
					setLoop: 1 1
					posn: 215 119
					show:
					setCycle: End self
				)
				(Palette 2 0 255 50) ; PalIntensity
			)
			(4
				(gMessager say: 7 12 26 2 self 900) ; "(MAJOR EARTHQUAKE HAPPENS)Oh! Shit!"
			)
			(5
				(Palette 2 0 255 0) ; PalIntensity
				(FrameOut)
				(= cycles 1)
			)
			(6
				(gCurRoom drawPic: 901 0)
				(Palette 2 0 255 0) ; PalIntensity
				(malia setCycle: 0)
				(gGkSound1 setLoop: 1 number: 914 play:)
				((ScriptID 898 4) ; xc1
					view: 896
					cycleSpeed: 20
					setCel: 0
					setLoop: 0 1
					init:
					noun: 0
					posn: 86 135
				)
				(FrameOut)
				(= cycles 1)
			)
			(7
				(Palette 2 0 203 0) ; PalIntensity
				(= cycles 1)
			)
			(8
				(drJohn dispose:)
				((ScriptID 898 13) dispose:) ; xchicken_cage
				((ScriptID 898 12) dispose:) ; xsnake_cage
				((ScriptID 898 2) dispose:) ; xfire
				((ScriptID 898 0) dispose:) ; xlid_up
				((ScriptID 898 14) dispose:) ; xveve
				((ScriptID 898 11) dispose:) ; xdeadChicks
				(malia hide:)
				(gEgo view: 8961 setCel: 0 setLoop: 0 1 posn: 153 117)
				((ScriptID 898 5) ; xc2
					view: 8965
					setCel: 0
					setLoop: 0 1
					noun: 0
					posn: 66 59
					init:
				)
				((ScriptID 898 6) ; xc3
					view: 8960
					cycleSpeed: 20
					setCel: 0
					setLoop: 0 1
					noun: 0
					init:
					hide:
					posn: 197 95
				)
				(= cycles 1)
			)
			(9
				(ShakeScreen 1 ssUPDOWN)
				(Palette 2 204 255 100) ; PalIntensity
				((ScriptID 898 4) setCel: 1) ; xc1
				(= ticks 20)
			)
			(10
				(ShakeScreen 5 ssUPDOWN)
				((ScriptID 898 4) setCel: 2) ; xc1
				(= ticks 20)
			)
			(11
				(ShakeScreen 2 ssUPDOWN)
				((ScriptID 898 4) setCel: 3) ; xc1
				(= ticks 20)
			)
			(12
				(ShakeScreen 5 ssUPDOWN)
				((ScriptID 898 4) setCel: 4) ; xc1
				(= ticks 20)
			)
			(13
				(ShakeScreen 3 ssUPDOWN)
				((ScriptID 898 4) setCel: 5) ; xc1
				(= ticks 20)
			)
			(14
				(ShakeScreen 5 ssUPDOWN)
				((ScriptID 898 4) setCel: 6) ; xc1
				(Palette 2 0 203 20) ; PalIntensity
				(= ticks 20)
			)
			(15
				(ShakeScreen 1 ssUPDOWN)
				((ScriptID 898 4) setCel: 7) ; xc1
				(Palette 2 0 203 30) ; PalIntensity
				(= ticks 20)
			)
			(16
				(ShakeScreen 5 ssUPDOWN)
				((ScriptID 898 4) setCel: 8) ; xc1
				(Palette 2 0 203 40) ; PalIntensity
				(= ticks 20)
			)
			(17
				(ShakeScreen 5 ssUPDOWN)
				((ScriptID 898 8) ; xc5
					view: 8960
					cycleSpeed: 20
					setCel: 0
					setLoop: 2 1
					init:
					posn: 26 94
					setCycle: End
				)
				((ScriptID 898 4) setCel: 9) ; xc1
				(Palette 2 0 203 55) ; PalIntensity
				(= ticks 20)
			)
			(18
				(ShakeScreen 1 ssUPDOWN)
				((ScriptID 898 4) setCel: 10) ; xc1
				(Palette 2 0 203 70) ; PalIntensity
				(= ticks 20)
			)
			(19
				((ScriptID 898 7) ; xc4
					view: 8960
					setCel: 0
					setLoop: 1 1
					init:
					noun: 0
					posn: 240 112
					cycleSpeed: 20
					setCycle: End
				)
				((ScriptID 898 4) setCel: 11) ; xc1
				(Palette 2 0 203 85) ; PalIntensity
				(= ticks 20)
			)
			(20
				(ShakeScreen 1 ssUPDOWN)
				((ScriptID 898 6) show: setCycle: End) ; xc3
				((ScriptID 898 4) setCel: 12) ; xc1
				(Palette 2 0 203 100) ; PalIntensity
				(= ticks 20)
			)
			(21
				(ShakeScreen 5 ssUPDOWN)
				((ScriptID 898 9) ; xc6
					view: 8960
					setCel: 0
					setLoop: 3 1
					init:
					posn: 55 83
				)
				((ScriptID 898 4) setCycle: End self) ; xc1
			)
			(22
				(malia view: 8966 show: setCel: 0 setLoop: 0 1 posn: 122 113)
				(= cycles 1)
			)
			(23
				((ScriptID 898 4) posn: 1000 0) ; xc1
				((ScriptID 898 5) posn: 1000 0) ; xc2
				(ShakeScreen 5 ssUPDOWN)
				(= cycles 2)
			)
			(24
				(gGkSound1 stop:)
				(Palette 2 0 255 0) ; PalIntensity
				(FrameOut)
				(gCast eachElementDo: #hide)
				(= cycles 2)
			)
			(25
				(self setScript: (ScriptID 892 0) self) ; sCutPanel2
			)
			(26
				(gCurRoom drawPic: 901)
				(gCast eachElementDo: #show)
				(= cycles 1)
			)
			(27
				(gMessager say: 13 0 32 0 self 900) ; "(RESURFACING, STRUGGLING)Gabriel...please!"
			)
			(28
				((ScriptID 898 4) dispose:) ; xc1
				((ScriptID 898 5) dispose:) ; xc2
				(gGame handsOn:)
				(= local8 1)
				(= seconds 15)
			)
			(29
				(if (gTalkers size:)
					(-- state)
				)
				(= cycles 1)
			)
			(30
				(gGame handsOff:)
				(switch local9
					(1
						(gEgo setScript: sFinale)
					)
					(else
						(= cycles 1)
					)
				)
			)
			(31
				(gEgo
					view: 8962
					setCel: 0
					setLoop: 0 1
					setSpeed: 12
					posn: 219 117
					setCycle: End self
				)
			)
			(32
				(gEgo
					setCel: 0
					setLoop: 1
					posn: 208 116
					setCycle: Fwd
					setMotion: MoveTo 146 118 self
				)
			)
			(33
				(gEgo
					view: 8963
					setCel: 0
					setLoop: 2
					posn: 86 135
					setCycle: 0
				)
				(UpdateScreenItem gEgo)
				(malia hide:)
				(gMessager say: 13 0 34 0 self 900) ; "(HURT, BEWILDERED)Tetelo...was right! You do nothing! You betray me!"
			)
			(34
				(gMessager say: 13 0 33 1 self 900) ; "(FIRM)I'm sorry. I have no choice."
			)
			(35
				(gEgo setCycle: CT 10 1 self)
			)
			(36
				(gGkSound1 setLoop: 1 number: 915 play:)
				(gEgo setCel: 11 setCycle: End self)
			)
			(37
				(Palette 2 0 255 0) ; PalIntensity
				(FrameOut)
				(malia show:)
				(gCast eachElementDo: #hide)
				(= cycles 2)
			)
			(38
				(self setScript: (ScriptID 894 0) self) ; sCutPanel4
			)
			(39
				(SetFlag 407)
				(gCurRoom newRoom: 670)
			)
		)
	)
)

(instance sFinale of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gMessager say: 9 12 28 1 self 900) ; "(TRYING TO PULL MALIA UP FROM CLIFF EDGE)I've got you, Malia!"
			)
			(1
				(gEgo
					view: 8961
					setCel: 0
					setLoop: 0 1
					posn: 153 117
					setSpeed: 8
					setCycle: End self
				)
			)
			(2
				(gEgo
					setCel: 0
					setLoop: 1 1
					posn: 153 117
					setCycle: End self
				)
			)
			(3
				(malia dispose:)
				(gCast eachElementDo: #hide)
				(self setScript: (ScriptID 893 0) self) ; sCutPanel3
			)
			(4
				(gCurRoom newRoom: 670)
			)
		)
	)
)

(instance sGraceDies of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(malia setCel: 0 setLoop: 2 1 setCycle: End self)
			)
			(1
				(malia view: 8921 setCel: 0 setLoop: 0 1 setCycle: 0)
				(= seconds 2)
			)
			(2
				(malia setCycle: CT 7 1 self)
			)
			(3
				(gMessager say: 13 0 18 2 self 900) ; "(RRCC. DYING SCREAM--STABBED IN STOMACH)Ahhhhhh!"
				(grace view: 8921 setCel: 0 setLoop: 3 1)
				(malia setCycle: End)
			)
			(4
				(gEgo view: 8931 setCel: 0 setLoop: 0 1 setCycle: End self)
				(gMessager say: 13 0 18 1 self 900) ; "(WATCHING GRACE BEING KILLED)GRACE, NO!"
			)
			(5 0)
			(6
				(malia view: 893 setCel: 0 setLoop: 0 1 setCycle: End self)
			)
			(7
				(malia setCel: 0 setLoop: 1 1 setCycle: End)
				(gMessager say: 13 0 18 3 self 900) ; "(ENRAGED)It's the Witch-hunter! Get him, Dr. John!"
			)
			(8
				(if (IsFlag 351)
					(gEgo setScript: sKillMosely)
				else
					(= cycles 1)
				)
			)
			(9
				(Face drJohn gEgo self)
			)
			(10
				(drJohn
					setCel: 0
					setLoop: 5 1
					setCycle: Fwd
					setMotion: PolyPath 109 138 self
				)
			)
			(11
				(gGkMusic1
					number: 901
					setLoop: 1
					stop:
					setVol: (gGkMusic1 musicVolume:)
					play:
				)
				(drJohn hide:)
				(gEgo view: 8971 setCel: 0 setLoop: 1 1 setCycle: End self)
				(UpdateScreenItem gEgo)
			)
			(12
				(gCurRoom newRoom: 770) ; deathRm
			)
		)
	)
)

(instance sKillMosely of Script
	(properties)

	(method (changeState newState &tmp temp0)
		(switch (= state newState)
			(0
				(Face gEgo mosely)
				(= cycles 2)
			)
			(1
				(drJohn
					view: 8972
					setCel: 0
					setLoop: 0 1
					posn: 98 113
					setCycle: CT 4 1 self
				)
			)
			(2
				(drJohn setCel: 5 setCycle: End self)
				(UpdateScreenItem drJohn)
				(mosely hide:)
				(gEgo
					view: 901
					setCel: 0
					setLoop: 1 1
					setCycle: Rev
					setMotion: MoveTo 108 126 self
				)
			)
			(3 0)
			(4
				(gGkMusic1
					number: 901
					setLoop: 1
					stop:
					setVol: (gGkMusic1 musicVolume:)
					play:
				)
				(gEgo hide:)
				(mosely view: 8972 setCel: 0 setLoop: 1 1 posn: 44 135 show:)
				(drJohn
					view: 8971
					setCel: 0
					setLoop: 0 1
					posn: 110 126
					setCycle: End self
				)
			)
			(5
				(gCurRoom newRoom: 770) ; deathRm
			)
		)
	)
)

(instance sKillGabe of Script
	(properties)

	(method (changeState newState &tmp temp0)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo view: 8931 setCel: 0 setLoop: 0 1 setCycle: End self)
				(gMessager say: 9 11 23 1 self 900) ; "Uh...STOP!"
			)
			(1 0)
			(2
				(malia view: 893 setCel: 0 setLoop: 0 1 setCycle: End self)
				(gMessager say: 9 11 23 2 self 900) ; "It is HIM, Dr. John! Get him!"
			)
			(3 0)
			(4
				(gEgo normalize: 0 901)
				(malia setCel: 0 setLoop: 1 1 setCycle: End self)
			)
			(5
				(if (IsFlag 351)
					(gEgo setScript: sKillMosely)
				else
					(= cycles 1)
				)
			)
			(6
				(Face drJohn gEgo self)
			)
			(7
				(drJohn
					setCel: 0 1
					setLoop: 5
					setCycle: Fwd
					setMotion: PolyPath 109 138 self
				)
			)
			(8
				(gGkMusic1
					number: 901
					setLoop: 1
					stop:
					setVol: (gGkMusic1 musicVolume:)
					play:
				)
				(drJohn hide:)
				(gEgo view: 8971 setCel: 0 setLoop: 1 1 setCycle: End self)
			)
			(9
				(gCurRoom newRoom: 770) ; deathRm
			)
		)
	)
)

(instance sGraceLives of Script
	(properties)

	(method (changeState newState &tmp temp0)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(malia setCel: 0 setLoop: 2 1 setCycle: End self)
			)
			(1
				(gEgo view: 8931 setCel: 0 setLoop: 0 1 setCycle: End self)
			)
			(2
				(gMessager say: 9 124 23 1 self 900) ; "(REVEALING HIMSELF TO STOP THE KILLING OF GRACE)Tetelo, stop! I won't let you kill her!"
				(malia view: 8921 setCel: 0 setLoop: 1 1 setCycle: 0)
				(gEgo setCel: 0 setLoop: 1 1 setCycle: End self)
			)
			(3 0)
			(4
				(malia setCycle: RandCycle)
				(gMessager say: 9 124 23 2 self 900) ; "(ENRAGED)WHAT??? You bastard of a bastard!"
			)
			(5
				(gMessager say: 9 124 23 3 self 900) ; "You can't stop me! Watch your friend die!"
			)
			(6
				(malia view: 8921 setCel: 0 setLoop: 1 1 setCycle: 0)
				(gMessager say: 9 124 24 2 self 900) ; "Uh-oh! The talisman seems to have little effect at protecting Grace from this distance!"
			)
			(7
				(malia view: 8921 setCel: 0 setLoop: 2 1)
				(grace view: 8932 setCel: 0 setLoop: 0 1 setCycle: CT 4 1 self)
			)
			(8
				(gMessager say: 9 124 24 3 self 900) ; "(GETTING READY TO THRUST DAGGER INTO GRACE)Ahhhh!"
				(malia setCycle: End)
				(gGkSound1 setLoop: 1 number: 907 play:)
				(grace setCel: 5 setCycle: End self)
			)
			(9
				(Face drJohn gEgo)
			)
			(10
				(malia view: 893 setCel: 0 setLoop: 0 1 setCycle: End self)
			)
			(11
				(gMessager say: 9 124 24 4 self 900) ; "Get her, Dr. John, kill her! We must have the sacrifice!"
				(malia setCel: 0 setLoop: 1 1 setCycle: End self)
			)
			(12 0)
			(13
				(if (not (IsFlag 351))
					(self dispose:)
				else
					(= cycles 1)
				)
			)
			(14
				(drJohn setMotion: MoveTo 122 110 self)
			)
			(15
				(= local16 0)
				(Palette 2 0 255 0) ; PalIntensity
				(FrameOut)
				(gCast eachElementDo: #hide)
				((ScriptID 898 3) dispose:) ; xdrummer
				((ScriptID 898 4) dispose:) ; xc1
				((ScriptID 898 5) dispose:) ; xc2
				(if (gCast contains: (ScriptID 898 6)) ; xc3
					((ScriptID 898 6) dispose:) ; xc3
				)
				(if (gCast contains: (ScriptID 898 7)) ; xc4
					((ScriptID 898 7) dispose:) ; xc4
				)
				(if (gCast contains: (ScriptID 898 8)) ; xc5
					((ScriptID 898 8) dispose:) ; xc5
				)
				(if (gCast contains: (ScriptID 898 9)) ; xc6
					((ScriptID 898 9) dispose:) ; xc6
				)
				(if (gCast contains: (ScriptID 898 10)) ; xc7
					((ScriptID 898 10) dispose:) ; xc7
				)
				(self setScript: (ScriptID 891 0) self) ; sCutPanel1
			)
			(16
				(self dispose:)
			)
		)
	)
)

(instance sDance of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(malia
					view: 8882
					setCel: 0
					setLoop: 1 1
					setCycle: Fwd
					setMotion: PolyPath 203 55 self
				)
			)
			(1
				(malia setMotion: Orbit (ScriptID 898 18) 25 0 70) ; xfirePit
				(= cycles 1)
			)
			(2
				(= seconds (Random 3 5))
			)
			(3
				(malia setCel: 0 setLoop: (Random 0 2) 1)
				(self changeState: 2)
			)
		)
	)
)

(instance talisman of Actor
	(properties
		x 16
		y 200
		view 8951
		loop 3
	)
)

(instance mosely of Actor
	(properties
		noun 11
		modNum 900
		x 16
		y 200
		view 888
		loop 1
	)

	(method (doVerb theVerb)
		(switch theVerb
			(124 ; talisman
				(if local7
					(gEgo getPoints: -999 3)
					(gEgo put: 69) ; talisman
					(= local12 1)
					(sPart2 seconds: 0 cue:)
				)
				(return 1)
			)
			(7 ; Look
				(cond
					(local5
						(gMessager say: noun theVerb 23 0 0 900) ; "Mosely stares at Grace with a horrified expression, but the Loa possession seems to have him spellbound."
					)
					(local7
						(gMessager say: noun theVerb 25 0 0 900) ; "Mosely looks ready to defend Grace with his life."
					)
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance malia of Actor
	(properties
		noun 9
		modNum 900
		x 330
		y 108
		view 8881
		signal 4129
	)

	(method (doVerb theVerb)
		(if (not (OneOf theVerb 8 6 12 10 11 9 7 13)) ; Operate, Open, Pickup, Ask, Talk, Move, Look, Walk
			(switch theVerb
				(124 ; talisman
					(cond
						(local5
							(gGame handsOff:)
							(= local11 1)
							(gEgo getPoints: -999 3)
							(sPart1 seconds: 0 cue:)
						)
						(local7
							(gGame handsOff:)
							(= local13 1)
							(sPart2 seconds: 0 cue:)
						)
					)
					(return 1)
				)
				(101 ; knife
					(gGame handsOff:)
					(cond
						(local5
							(gMessager say: noun 12 25 0 0 900) ; "Gabriel can't even try that from across the room."
						)
						(local7
							(gEgo setScript: sDaggerOnMalia)
						)
						(local6
							(gMessager say: noun theVerb 26 0 0 900) ; "Gabriel has a knife at his throat! He can't attack with the dagger now!"
						)
						(local8
							(gEgo setScript: sDaggerOnMalia2)
						)
					)
					(return 1)
				)
				(else
					(cond
						(local6
							(gMessager say: noun 0 26 0 0 900) ; "Using that on Tetelo won't help!"
						)
						(local5
							(gMessager say: noun 0 23 0 0 900) ; "Using that on Tetelo won't save Grace!"
						)
						(local7
							(gMessager say: noun 0 25 0 0 900) ; "Using that on Tetelo won't save Grace and Mosely!"
						)
						(local8
							(gMessager say: noun 0 28 0 0 900) ; "Why would Gabriel want to use that on Tetelo now?"
						)
					)
					(return 1)
				)
			)
		else
			(switch theVerb
				(7 ; Look
					(cond
						(local6
							(gMessager say: noun theVerb 26 0 0 900) ; "Malia's body trembles, as though Malia were trying to regain control--but can't!"
						)
						(local5
							(gMessager say: noun theVerb 23 0 0 900) ; "Malia's body is totally under the control of the Loa, Tetelo!"
						)
						(local7
							(gMessager say: noun theVerb 25 0 0 900) ; "Tetelo stands between Gabriel and his friends!"
						)
						(local8
							(gMessager say: noun theVerb 28 0 0 900) ; "Malia's fingers barely grip the edge of the crevasse!"
						)
					)
					(return 1)
				)
				(9 ; Move
					(cond
						(local6
							(gMessager say: noun theVerb 26 0 0 900) ; "Gabriel is not in a position to tackle Tetelo!"
						)
						(local5
							(gMessager say: noun theVerb 23 0 0 900) ; "Gabriel can't even try that from across the room."
						)
						(local7
							(gMessager say: noun theVerb 25 0 0 900) ; "Gabriel can't even try that from across the room."
						)
						(local8
							(gMessager say: noun theVerb 28 0 0 900) ; "Malia will fall soon enough without a push!"
						)
					)
					(return 1)
				)
				(12 ; Pickup
					(cond
						(local8
							(gGame handsOff:)
							(gEgo getPoints: -999 10)
							(= local9 1)
							(sPart4 seconds: 0 cue:)
						)
						(local6
							(gMessager say: noun theVerb 26 0 0 900) ; "Gabriel is not in a position to tackle Tetelo!"
						)
						(local5
							(gMessager say: noun theVerb 23 0 0 900) ; "Gabriel can't even try that from across the room."
						)
						(local7
							(gMessager say: noun theVerb 25 0 0 900) ; "Gabriel can't even try that from across the room."
						)
					)
					(return 1)
				)
				(11 ; Talk
					(cond
						(local8
							(sPart4 seconds: 0)
							(gMessager say: noun theVerb 28 0 sPart4 900) ; "(MALIA IS HANGING OVER EDGE OF CLIFF)Malia!"
						)
						(local6
							(gMessager say: noun theVerb 26 0 0 900) ; "(STRANGLING)Malia...help me!"
						)
						(local5
							(gGame handsOff:)
							(gEgo setScript: sKillGabe)
						)
						(local7
							(sPart2 seconds: 0)
							(gMessager say: noun theVerb 25 0 sPart2 900) ; "Don't hurt them, Tetelo! Your quarrel is with me!"
						)
					)
					(return 1)
				)
				(else
					(super doVerb: theVerb)
				)
			)
		)
	)
)

(instance drJohn of Actor
	(properties
		noun 8
		modNum 900
		x -30
		y 138
		view 8911
	)

	(method (doVerb theVerb)
		(if (== noun 8)
			(super doVerb: theVerb)
		else
			(gMessager say: 8 0 46 0 0 900) ; "There's no time for that now!"
			(return 1)
		)
	)
)

(instance grace of Actor
	(properties
		noun 10
		modNum 900
		x 151
		y 101
		z 22
		view 8911
		loop 2
		signal 16417
	)

	(method (doVerb theVerb)
		(switch theVerb
			(7 ; Look
				(cond
					(local5
						(gMessager say: noun theVerb 24 0 0 900) ; "Grace is pretending unconsciousness on the stone table!"
					)
					(local7
						(gMessager say: noun theVerb 25 0 0 900) ; "Grace looks injured."
					)
				)
				(return 1)
			)
			(9 ; Move
				(cond
					(local5
						(gMessager say: noun theVerb 23 0 0 900) ; "Gabriel would never make it up there in time!"
					)
					(local7
						(gMessager say: noun theVerb 25 0 0 900) ; "Tetelo stands between Gabriel and his friends!"
					)
				)
				(return 1)
			)
			(12 ; Pickup
				(cond
					(local5
						(gMessager say: noun theVerb 23 0 0 900) ; "Gabriel would never make it up there in time!"
					)
					(local7
						(gMessager say: noun theVerb 25 0 0 900) ; "Tetelo stands between Gabriel and his friends!"
					)
				)
				(return 1)
			)
			(11 ; Talk
				(cond
					(local5
						(gMessager say: noun theVerb 23 0 0 900) ; "Grace can't advise Gabriel now!"
					)
					(local7
						(gMessager say: noun theVerb 25 0 0 900) ; "Grace, are you okay?"
					)
				)
				(return 1)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance idol of View
	(properties
		noun 7
		modNum 900
		x 153
		y 181
		z 100
		priority 107
		fixPriority 1
		view 8942
		loop 2
	)

	(method (doVerb theVerb)
		(switch theVerb
			(12 ; Pickup
				(if local6
					(gGame handsOff:)
					(gEgo getPoints: -999 5)
					(= local10 1)
					(sPart3 seconds: 0 cue:)
				else
					(gMessager say: noun theVerb 22 0 0 900) ; "Gabriel's not close enough to grab the idol."
				)
				(return 1)
			)
			(9 ; Move
				(if local6
					(gGame handsOff:)
					(gEgo getPoints: -999 5)
					(= local10 1)
					(sPart3 seconds: 0 cue:)
				else
					(gMessager say: noun theVerb 22 0 0 900) ; "Gabriel's not close enough to move the idol."
				)
				(return 1)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance forRepeat of Fwd
	(properties)

	(method (cycleDone)
		(client cel: (- (client cel:) 1))
	)
)

(instance endGameNarrator of Narrator
	(properties
		x 0
		y 157
		talkWidth 314
		modeless 2
	)

	(method (init)
		(self fore: global220 back: global214 font: gUserFont)
		(super init: &rest)
	)

	(method (display param1 &tmp [temp0 2])
		(= fore
			(switch global180
				(1 54)
				(2 21)
				(99 7)
				(8 30)
				(25 25)
				(else global220)
			)
		)
		(switch global180
			(1
				(gEgo
					oldView: (gEgo view:)
					oldLoop: (gEgo loop:)
					oldCel: (gEgo cel:)
					talking: 1
					oldSig: (gEgo signal:)
					view: 858
					setCel: 0
					setLoop: 0 1
					posn: (gEgo x:) (gEgo y:)
					ignoreActors: 1
					cycleSpeed: 14
					setCycle: RandCycle (* (param1 size:) 3) 0 1
				)
			)
			(8
				(= local4 1)
				(= local0 (mosely view:))
				(= local1 (mosely cel:))
				(= local2 (mosely loop:))
				(mosely
					view: 858
					setCel: 0
					setLoop: 2 1
					setCycle: RandCycle (* (param1 size:) 3) 0 1
				)
			)
		)
		(if (& gMsgType $0001)
			(super display: param1)
		)
	)

	(method (dispose)
		(if local4
			(= local4 0)
			(mosely
				view: local0
				setCel: 0
				setLoop: local2
				setCel: local1
				setCycle: 0
			)
		)
		(if (gEgo talking:)
			(gEgo
				view: (gEgo oldView:)
				setCel: 0
				setLoop: (gEgo oldLoop:)
				setCel: (gEgo oldCel:)
				signal: (gEgo oldSig:)
				cycleSpeed: local3
				setCycle: StopWalk -1
				talking: 0
			)
		)
		(super dispose:)
	)
)

(instance gabeActions of Actions
	(properties)

	(method (doVerb theVerb)
		(if (not (OneOf theVerb 8 6 12 10 11 9 7 13)) ; Operate, Open, Pickup, Ask, Talk, Move, Look, Walk
			(gMessager say: 17 0 0 0 0 900) ; "There's no time for that now!"
			(return 1)
		else
			(return 0)
		)
	)
)

