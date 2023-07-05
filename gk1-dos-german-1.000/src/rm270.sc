;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 270)
(include sci.sh)
(use Main)
(use n013)
(use GKTeller)
(use Osc)
(use RandCycle)
(use Polygon)
(use Feature)
(use StopWalk)
(use Cursor)
(use Motion)
(use Game)
(use Actor)
(use System)

(public
	rm270 0
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
)

(instance rm270 of Room
	(properties
		noun 10
		picture 270
		style 14
		exitStyle 13
	)

	(method (init)
		(super init:)
		(Load rsMESSAGE 270)
		(Load rsMESSAGE 920)
		(Load rsMESSAGE 51)
		(Load rsVIEW 271)
		(gEgo
			view: 900
			setLoop: 3
			cel: 0
			init:
			setCycle: StopWalk -1
			state: 2
			ignoreActors: 1
			signal: (| (gEgo signal:) $1000)
			actions: getEgoMessages
			posn: 154 190
			hide:
		)
		(if (!= gPrevRoomNum 280)
			(gGkMusic1
				number: 270
				setLoop: -1
				play:
				setVol: 0
				fade: (gGkMusic1 musicVolume:) 25 10 0
			)
		)
		(cazDoor init:)
		(doorFrame init:)
		(whatKnockers init:)
		(steps init:)
		(iron init:)
		(leftWindow init:)
		(rightWindow init:)
		(leftShutter init:)
		(rightShutter init:)
		(gWalkHandler add: steps)
		(gWalkHandler add: self)
		(Load rsVIEW 271)
		(Load rsVIEW 270)
		(Load rsVIEW 964)
		(if (== gPrevRoomNum 280)
			(= local0 1)
			(= local5 1)
			(= local6 1)
			(gEgo setScript: walkOut)
		else
			(gEgo setScript: egoEnters)
		)
	)

	(method (handleEvent event)
		(if (== (event message:) KEY_RETURN)
			(= local8 (event x:))
			(= local9 (event y:))
		)
		(super handleEvent: event &rest)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(13 ; Walk
				(Face gEgo local8 local9 0)
				(gMessager say: noun theVerb 29 0) ; "There's not much of interest over that way."
				(return 1)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)

	(method (doit)
		(super doit:)
		(cond
			((steps onMe: gMouseX (- gMouseY 10))
				(if (== gTheCursor ((gTheIconBar at: 0) cursorView:))
					(gGame setCursor: cazExitCursor 1)
					(= local7 1)
				)
			)
			(local7
				(gGame setCursor: ((gTheIconBar at: 0) cursorView:) 1)
				(= local7 0)
			)
		)
	)

	(method (dispose)
		(if (!= gNewRoomNum 280)
			(gGkMusic1 fade:)
		)
		(gWalkHandler delete: steps)
		(gWalkHandler delete: self)
		(DisposeScript 920)
		(DisposeScript 51)
		(DisposeScript 64939)
		(super dispose:)
	)
)

(instance egoEnters of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo show: setMotion: MoveTo 164 147 self)
			)
			(1
				(gEgo view: 270 setCel: 0 setLoop: 0 setCycle: End self)
			)
			(2
				(gEgo posn: 165 129 normalize: 3 900)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance knockOnDoor of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(egoHead
					setCel: (if local5 1 else 0)
					x: (gEgo x:)
					y: (- (gEgo y:) 48)
					setPri: 122
					init:
				)
				(= cycles 1)
			)
			(1
				(gEgo
					view: (if local6 2711 else 271)
					setCel: 0
					setLoop: 1
					setCycle: End self
				)
			)
			(2
				(gGkSound1 number: 219 setLoop: 1 play:)
				(gEgo setCel: 0 setLoop: 2 setCycle: Osc 4 self)
			)
			(3
				(gEgo setCel: 2 setLoop: 1 setCycle: Beg self)
			)
			(4
				(if (>= gDay 4)
					(= seconds 3)
				else
					(cazDoor setCel: 1)
					(gMessager say: 2 8 0 0) ; "(ANSWERING DOOR)Yes? Who is it?"
					(madam
						posn: 141 120
						init:
						view: 272
						ignoreActors: 1
						setCel: 0
						setLoop: 0
						setCycle: End self
					)
				)
			)
			(5
				(if (>= gDay 4)
					(gMessager say: 2 8 30 0) ; "(RRCC)There's no answer. Perhaps Cazaunoux got even more paranoid than usual and decided to get out of town."
					(gEgo normalize: 3 900)
					(egoHead dispose:)
					(gGame handsOn:)
					(self dispose:)
				else
					(madam loop: 1 cel: 0 setCycle: End self)
				)
			)
			(6
				(madam loop: 2 cel: 0 setCycle: End self)
			)
			(7
				(madamTeller doVerb: 11)
			)
			(8
				(if local4
					(madam view: 274 loop: 0 cel: 0 setCycle: End self)
					(gEgo getPoints: 138 1)
				else
					(madam view: 273 loop: 0 cel: 0 setCycle: End self)
				)
			)
			(9
				(if local4
					(gCurRoom newRoom: 280)
				else
					(madam loop: 1 cel: 0 setCycle: End self)
				)
			)
			(10
				(if local4
					(madam loop: 1 cel: 0 setCycle: End self)
				else
					(madam loop: 2 cel: 0 setCycle: End self)
				)
			)
			(11
				(if local4
					(gEgo getPoints: 138 1)
					(gCurRoom newRoom: 280)
				else
					(madam dispose:)
					(cazDoor init: loop: 3 cel: 0)
					(= cycles 10)
				)
			)
			(12
				(egoHead dispose:)
				(cond
					(local0
						(gEgo normalize: 3 278)
					)
					(local5
						(gEgo normalize: 3 276)
					)
					(local6
						(gEgo normalize: 3 279)
					)
					(else
						(gEgo normalize: 3 900)
					)
				)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance leaveTheRoom of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(if (gCast contains: egoHead)
					(egoHead dispose:)
				)
				(= cycles 1)
			)
			(1
				(cond
					((and (not local0) (not local5) (not local6))
						(self changeState: 5)
					)
					(local0
						(gEgo get: 48) ; disguise
						(gEgo view: 2711 loop: 3 cel: 12 setCycle: Beg self)
						(gMessager say: 10 13 28 0 self) ; "(TO PLAYER. EMBARRASED)I'm not going back on the street looking like this."
					)
					(local5
						(gEgo view: 270 loop: 1 cel: 0 setCycle: End self)
						(gMessager say: 10 13 28 0) ; "(TO PLAYER. EMBARRASED)I'm not going back on the street looking like this."
					)
					(local6
						(gEgo get: 48) ; disguise
						(= cycles 1)
					)
				)
			)
			(2
				(if (and local6 (not local0))
					(= cycles 1)
				)
				(if (and local5 (not local0))
					(self changeState: 5)
				)
			)
			(3
				(gMessager say: 10 13 26 0 self) ; "!!!Blank msg"
			)
			(4
				(if (gTalkers size:)
					(gMessager cue: 1)
				)
				(for ((= local10 100)) (>= local10 0) ((-= local10 5))
					(Palette 2 0 255 local10) ; PalIntensity
				)
				(= cycles 15)
			)
			(5
				(if (and (not local0) (not local6))
					(= cycles 1)
				else
					(= seconds 3)
				)
				(gEgo normalize:)
			)
			(6
				(if (and (not local0) (not local6))
					(self cue:)
				else
					(for ((= local10 0)) (<= local10 100) ((+= local10 5))
						(Palette 2 0 255 local10) ; PalIntensity
					)
					(= cycles 1)
				)
			)
			(7
				(if (and (not local0) (not local6))
					(gEgo setMotion: MoveTo 160 160 self)
				else
					(gEgo normalize: 3 900 setMotion: MoveTo 160 160 self)
				)
			)
			(8
				(gCurRoom newRoom: 200)
			)
		)
	)
)

(instance gelHair of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(Face gEgo 160 200 self)
			)
			(1
				(= cycles 1)
			)
			(2
				(gEgo
					view: (if local6 2791 else 1912)
					setCel: 0
					setLoop: (if local6 0 else 2)
					cycleSpeed: 14
					setCycle: RandCycle
				)
				(gMessager say: 6 72 5 0 self) ; "The things I do for my art!"
			)
			(3
				(gEgo
					view: (if local6 2711 else 271)
					setCel: 0
					setLoop: 3
					cycleSpeed: 6
					setCycle: End self
				)
			)
			(4
				(gEgo getPoints: 137 1)
				(if local6
					(gEgo normalize: 0 278)
				else
					(gEgo normalize: 0 276)
				)
				(gGame handsOn:)
				(= local5 1)
				(if local6
					(= local0 1)
				)
				(self dispose:)
			)
		)
	)
)

(instance walkOut of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(madam
					view: 277
					loop: 0
					cel: 0
					posn: 175 121
					init:
					setCycle: CT 10 1 self
				)
			)
			(1
				(madam cel: 11 setCycle: End self)
				(gEgo view: 275 loop: 4 posn: 162 128 init: show:)
			)
			(2
				(madam dispose:)
				(cazDoor init:)
				(= local0 1)
				(gEgo normalize: 2 278)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance putTheDisguiseOn of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(Face gEgo 160 200 self)
			)
			(1
				(if local5
					(gEgo
						view: 2761
						setCel: 0
						setLoop: 0
						setCycle: RandCycle
					)
					(gMessager say: 6 73 7 1 self) ; "(RELUCTANT)All right, but this is private."
				else
					(= cycles 2)
				)
			)
			(2
				(if local5
					(gEgo setCycle: 0)
					(= cycles 1)
				else
					(gMessager say: 6 73 7 1 self) ; "(RELUCTANT)All right, but this is private."
				)
			)
			(3
				(if (gTalkers size:)
					(gMessager cue: 1)
				)
				(for ((= local10 100)) (>= local10 0) ((-= local10 5))
					(Palette 2 0 255 local10) ; PalIntensity
				)
				(= cycles 15)
			)
			(4
				(if local5
					(gEgo normalize: 2 278)
				else
					(gEgo normalize: 2 279)
				)
				(= cycles 1)
			)
			(5
				(for ((= local10 0)) (<= local10 100) ((+= local10 5))
					(Palette 2 0 255 local10) ; PalIntensity
				)
				(= cycles 1)
			)
			(6
				(gMessager say: 6 73 7 2 self) ; "!!!Blank msg"
			)
			(7
				(gEgo getPoints: 136 1)
				(gEgo put: 48) ; disguise
				(= local6 1)
				(if local5
					(= local0 1)
				)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance madamTeller of GKTeller
	(properties
		curNoun 11
		sayNoun 12
		verb 71
	)

	(method (cue)
		(cond
			((== iconValue 11) ; It's Father MacLaughlin ta see ye.
				(if local0
					(if (IsFlag 214)
						(= iconValue 13) ; "(NICER)I see you've taken my advice, Father! I didn't mean to be harsh, but the Church is the Church."
					else
						(= iconValue 14) ; "(POLITE)Father MacLaughlin, you say?"
					)
					(= local4 1)
				else
					(SetFlag 214)
					(= iconValue 12) ; "(ADMONISHING)Well, Father, you should be ashamed of yourself, being so ill-groomed!"
				)
				(self sayMessage:)
			)
			((== iconValue 15) ; It's Father MacLaughlin, back again.
				(if local0
					(= iconValue 17) ; "(POLITE)Yes, Father. Come on in."
					(= local4 1)
				else
					(= iconValue 16) ; "(RRCC. ADMONISHING)Well, Father, I'm ashamed of you! Last time you came to see me, you were so well-groomed! Now look at that mop of hair!"
				)
				(self sayMessage:)
			)
			((== iconValue 19) ; I'm writing an article on Voodoo.
				(if (IsFlag 215)
					(= iconValue 24) ; "(ANGRY/FEARFUL)I told you NO! This house is under the protection of the saints! Now go AWAY!"
				else
					(SetFlag 215)
					(= iconValue 23) ; "(HORRIFIED)I'm a good Catholic, young man! Take your evil influence elsewhere!"
				)
				(self sayMessage:)
			)
			((OneOf iconValue 23 24 12 13 14 22 16 17 4) ; "(HORRIFIED)I'm a good Catholic, young man! Take your evil influence elsewhere!", "(ANGRY/FEARFUL)I told you NO! This house is under the protection of the saints! Now go AWAY!", "(ADMONISHING)Well, Father, you should be ashamed of yourself, being so ill-groomed!", "(NICER)I see you've taken my advice, Father! I didn't mean to be harsh, but the Church is the Church.", "(POLITE)Father MacLaughlin, you say?", Wrong house. Never mind., "(RRCC. ADMONISHING)Well, Father, I'm ashamed of you! Last time you came to see me, you were so well-groomed! Now look at that mop of hair!", "(POLITE)Yes, Father. Come on in.", Please let me talk to you, Madame Cazaunoux.
				(knockOnDoor cue:)
			)
			(else
				(self doVerb: 11)
			)
		)
	)

	(method (showCases)
		(super
			showCases:
				11 ; It's Father MacLaughlin ta see ye.
				(and (or local0 local6) (not (IsFlag 213)))
				15 ; It's Father MacLaughlin, back again.
				(and (or local0 local6) (IsFlag 213))
				18 ; Magazine subscriptions for sale.
				(and (not local0) (not local2) (not local1) (not local3))
				20 ; I'm selling pet supplies.
				(and (not local0) local2 (not local1) (not local3))
				21 ; Land shark.
				(and (not local0) local2 local1 (not local3))
				4 ; Please let me talk to you, Madame Cazaunoux.
				(and (not local0) local2 local1 local3)
				19 ; I'm writing an article on Voodoo.
				(not local0)
		)
	)

	(method (sayMessage)
		(if (== iconValue 18) ; Magazine subscriptions for sale.
			(= local2 1)
		)
		(if (== iconValue 20) ; I'm selling pet supplies.
			(= local1 1)
		)
		(if (== iconValue 21) ; Land shark.
			(= local3 1)
		)
		(super sayMessage:)
	)
)

(instance madam of Prop
	(properties
		x 144
		y 122
		view 272
	)

	(method (init)
		(super init:)
		(madamTeller init: self)
	)
)

(instance cazDoor of Prop
	(properties
		noun 1
		x 174
		y 121
		view 272
		loop 3
	)

	(method (init)
		(super init:)
		(self setPri: 5)
	)
)

(instance egoHead of Prop
	(properties
		view 271
	)

	(method (init)
		(super init:)
		(self setPri: 122)
	)
)

(instance doorFrame of Feature
	(properties
		noun 4
		sightAngle 20
		x 158
		y 49
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 186 133 185 127 174 127 174 60 135 60 135 127 123 127 120 129 120 133 108 133 109 48 117 36 134 24 163 22 186 31 199 48 199 133
					yourself:
				)
		)
		(super init:)
	)
)

(instance whatKnockers of Feature
	(properties
		noun 2
		sightAngle 20
		x 153
		y 122
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 150 76 159 76 158 85 150 85
					yourself:
				)
		)
		(super init:)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(8 ; Operate
				(gEgo setScript: knockOnDoor)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance steps of Feature
	(properties
		noun 7
		nsLeft 119
		nsTop 127
		nsRight 194
		nsBottom 148
		sightAngle 20
		x 157
		y 149
	)

	(method (doVerb theVerb)
		(switch theVerb
			(13 ; Walk
				(gEgo setScript: leaveTheRoom)
				(return 1)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance iron of Feature
	(properties
		noun 3
		sightAngle 20
		x 157
		y 160
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 208 51 188 32 167 24 140 24 110 39 99 55 99 144 84 144 84 50 49 20 271 20 222 49 222 144 209 144
					yourself:
				)
		)
		(super init:)
	)
)

(instance getEgoMessages of Feature
	(properties
		noun 6
	)

	(method (doVerb theVerb)
		(switch theVerb
			(7 ; Look
				(cond
					(local0
						(gMessager say: noun theVerb 10 0) ; "It's Father Gabriel."
						(return 1)
					)
					(local5
						(gMessager say: noun theVerb 8 0) ; "(TO PLAYER. EMBARRASED)Don't look at my hair."
						(return 1)
					)
					(local6
						(gMessager say: noun theVerb 9 0) ; "(TO PLAYER--PARITALLY DISGUISED)Is this convincing enough?"
						(return 1)
					)
				)
			)
			(72 ; hair_gel
				(if local5
					(gMessager say: noun theVerb 6 0) ; "(SPEAKING OF HAIR GEL)I've used plenty of that stuff, thanks!"
					(return 1)
				else
					(gEgo setScript: gelHair)
					(return 1)
				)
			)
			(73 ; disguise
				(if (>= gDay 4)
					(gMessager say: noun theVerb 30 0) ; "(RRCC)Gabriel won't be needing that disguise today."
				else
					(gEgo setScript: putTheDisguiseOn)
				)
				(return 1)
			)
			(74 ; shirt
				(gMessager say: noun theVerb 0 0) ; "The black shirt won't do Gabriel much good the way it is."
			)
			(64 ; collar_
				(gMessager say: noun theVerb 0 0) ; "Gabriel has no way to keep that collar on his T-shirt."
			)
			(else
				(return 0)
			)
		)
	)
)

(instance leftWindow of Feature
	(properties
		noun 8
		nsLeft 15
		nsTop 41
		nsRight 60
		nsBottom 111
		sightAngle 20
		x 40
		y 79
	)
)

(instance rightWindow of Feature
	(properties
		noun 8
		nsLeft 247
		nsTop 41
		nsRight 300
		nsBottom 109
		sightAngle 20
		x 272
		y 79
	)
)

(instance leftShutter of Feature
	(properties
		noun 13
		sightAngle 20
		x 69
		y 79
	)

	(method (init)
		(super init:)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 63 50 79 50 80 109 61 109
					yourself:
				)
		)
	)
)

(instance rightShutter of Feature
	(properties
		noun 13
		sightAngle 20
		x 238
		y 89
	)

	(method (init)
		(super init:)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 229 50 246 50 247 108 231 109
					yourself:
				)
		)
	)
)

(instance cazExitCursor of Cursor
	(properties
		view 964
	)
)

