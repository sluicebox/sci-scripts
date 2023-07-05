;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 552)
(include sci.sh)
(use Main)
(use GloryRm)
(use TargFeature)
(use Teller)
(use forest)
(use PChase)
(use PolyPath)
(use Polygon)
(use Sound)
(use Motion)
(use User)
(use System)

(public
	rm552 0
)

(local
	local0
)

(instance rm552 of GloryRm
	(properties
		picture 410
		horizon 70
		north 600
		east 557
		south 553
		topX 181
		rightY 131
	)

	(method (init)
		(if gDebugging
			(= gNight 1)
			(SetFlag 34)
		)
		(self setRegions: 50) ; forest
		(if (and gNight (IsFlag 34) (not (IsFlag 110)) (not gCombatMonsterNum))
			(SetFlag 35)
			(self setRegions: 51) ; theHunt
			(adAvis init: setScale: 140 approachVerbs: 4) ; Do
			(adTeller init: adAvis 51 4 160 2)
			(egoTeller init: gEgo 51 4 128 2)
			((ScriptID 50 1) caller: adAvis) ; enterRoomScr
			(gCurRoom
				addObstacle:
					((Polygon new:)
						type: PBarredAccess
						init: 66 155 49 160 103 189 0 189 0 0 319 0 319 118 247 118 201 90 163 90 99 105 111 134 54 134
						yourself:
					)
					((Polygon new:)
						type: PBarredAccess
						init: 215 143 319 143 319 189 240 189 200 167
						yourself:
					)
			)
			(SetFlag 380)
		else
			(gCurRoom
				addObstacle:
					((Polygon new:)
						type: PBarredAccess
						init: 66 155 49 160 103 189 0 189 0 0 127 0 127 72 164 90 99 105 111 134 54 134
						yourself:
					)
					((Polygon new:)
						type: PBarredAccess
						init: 215 143 319 143 319 189 240 189 200 167
						yourself:
					)
					((Polygon new:)
						type: PBarredAccess
						init: 240 72 240 0 319 0 319 120 254 120 199 93
						yourself:
					)
			)
		)
		(super init: &rest)
		(gCurRoom
			addPoly:
				((Polygon new:)
					init: 90 116 140 116 158 129 130 140 82 128
					yourself:
				)
				60
				((Polygon new:)
					init: 88 189 68 170 161 130 149 118 164 117 203 155 135 176 176 189
					yourself:
				)
				130
				((Polygon new:) init: 185 189 147 174 218 153 278 189 yourself:)
				60
		)
		(atp0 init:)
		(atp1 init:)
		(atp3 init: setPri: 169)
		(atp4 init:)
		(if gNight
			(atp5 init:)
		)
		(path init:)
		(if (IsFlag 380)
			(gGlory save: 1)
		)
	)

	(method (cue)
		(if (== (sSummoning state:) 6)
			(sSummoning cue:)
		else
			(adAvis getHurt:)
		)
	)

	(method (notify param1)
		(if (and (== param1 1) (!= (gCurRoom script:) (ScriptID 51 4))) ; sBlackOut
			(gCurRoom setScript: (ScriptID 51 4)) ; sBlackOut
		)
	)

	(method (doit)
		(super doit: &rest)
		(cond
			(script)
			((and (IsFlag 35) (<= (gEgo y:) 92))
				(gCurRoom setScript: sSummoning)
			)
		)
	)
)

(instance adTeller of Teller
	(properties
		title 1
	)

	(method (init)
		(super init: &rest)
		(= talker (ScriptID 74)) ; avisTalker
	)

	(method (respond)
		(if (== (++ local0) 4)
			(self clean:)
			(gCurRoom setScript: sSummoning)
		else
			(super respond: &rest)
			(return 1)
		)
	)
)

(instance egoTeller of Teller
	(properties
		loopMenu 0
	)

	(method (doVerb theVerb)
		(if (== (++ local0) 4)
			(= loopMenu 0)
			(gCurRoom setScript: sSummoning)
		else
			(super doVerb: theVerb)
		)
		(return 1)
	)

	(method (respond)
		(super respond: &rest)
		(if (== iconValue -999)
			((User curEvent:) claimed: 1)
		)
		(return 1)
	)
)

(instance sControlEgo of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(SetFlag 36)
				(gEgo setMotion: 0)
				(gMessager say: 1 6 8 0 self 51) ; "As you approach Ad Avis, he stares deep into your eyes."
			)
			(1
				(gCurRoom setScript: (ScriptID 51 4)) ; sBlackOut
			)
		)
	)
)

(instance sSummoning of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= cycles 3)
			)
			(1
				(gMessager say: 2 6 4 0 self 51) ; "Ha! You have no power against one such as I! Let's play a little game of Fox and Hound, shall we?"
			)
			(2
				(adAvis signal: (| (adAvis signal:) $0001) setCycle: End self)
			)
			(3
				(soundFX number: 131 setLoop: 1 play:)
				(gMessager say: 2 6 5 0 self 51) ; "I have summoned the Hounds of Death. Now we shall see whether you've kept up with your running lessons!"
				(adAvis setCel: 0 signal: (& (adAvis signal:) $fffe))
			)
			(4
				(gLongSong number: 103 setLoop: -1 play:)
				((ScriptID 51 1) ; nec1
					init:
					x: 181
					y: 60
					approachDist: 1
					setMotion:
						PolyPath
						(+ (adAvis x:) 30)
						(- (adAvis y:) 10)
						self
				)
				((ScriptID 51 2) init: x: 350 y: 100) ; nec2
			)
			(5
				((ScriptID 51 1) setHeading: 180) ; nec1
				((ScriptID 51 2) setMotion: PolyPath 285 100 self) ; nec2
			)
			(6
				(gMessager say: 2 6 6 0 0 51) ; "Run, fool! Run while you can! Soon enough my creatures shall catch you and then I shall have my revenge!"
				(= seconds 5)
			)
			(7
				(gMessager say: 2 6 7 0 0 51) ; "Get him!"
				((ScriptID 51 1) setMotion: PChase gEgo 25 (ScriptID 51 1)) ; nec1, nec1
				((ScriptID 51 2) setMotion: PChase gEgo 25 (ScriptID 51 2)) ; nec2, nec2
			)
		)
	)
)

(instance moveFarther of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo
					setMotion: PolyPath (- (gEgo x:) 50) (gEgo y:) self
				)
			)
			(1
				(if (IsFlag 20)
					(gMessager say: 1 6 1 0 self 51) ; "Suddenly you have a terrible feeling of peril! You recognize Ad Avis, the evil Wizard whom you thought you had killed in Raseir. Somehow, he has returned to life!"
				else
					(self cue:)
				)
			)
			(2
				(gMessager say: 2 6 2 0 self 51) ; "How nice of you to come. I'm afraid I accidentally signed the wrong name to your note."
			)
			(3
				(gGlory handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance adAvis of TargProp
	(properties
		noun 2
		modNum 51
		x 117
		y 113
		view 677
		signal 16384
	)

	(method (doit)
		(super doit: &rest)
		(if
			(and
				(!= (gCurRoom script:) sControlEgo)
				(!= (gCurRoom script:) (ScriptID 51 4)) ; sBlackOut
				(< (gEgo distanceTo: self) 40)
			)
			(gGlory handsOff:)
			(self setScript: 0)
			(gCurRoom setScript: sControlEgo)
		)
	)

	(method (doVerb theVerb)
		(if
			(OneOf
				theVerb
				36 ; theSword
				20 ; ???
				21 ; theRocks
				85 ; calmSpell
				83 ; dazzleSpell
				81 ; detectMagicSpell
				87 ; fetchSpell
				86 ; flameDartSpell
				88 ; forceBoltSpell
				79 ; frostSpell
				102 ; healingSpell
				91 ; jugglingLightsSpell
				89 ; levitateSpell
				93 ; lightningBallSpell
				80 ; openSpell
				90 ; reversalSpell
				94 ; ritualSpell
				92 ; summonStaffSpell
				82 ; triggerSpell
				84 ; zapSpell
				95 ; invisibleSpell
				96 ; auraSpell
				97 ; protectionSpell
				98 ; resistanceSpell
				11 ; glideSpell
			)
			((ScriptID 51) doVerb: theVerb) ; theHunt
		else
			(super doVerb: theVerb)
		)
	)

	(method (cue)
		(gGlory handsOff:)
		(if (== gPrevRoomNum 557)
			(moveFarther start: 0)
		else
			(moveFarther start: 1)
		)
		(gCurRoom setScript: moveFarther)
	)

	(method (getHurt)
		(if (not script)
			(self setScript: sSummoning)
		)
	)
)

(instance atp0 of ForestView
	(properties
		x 94
		y 49
		view 413
		cel 1
		signal 16385
	)
)

(instance atp1 of ForestView
	(properties
		y 108
		view 413
		signal 16385
	)
)

(instance atp3 of ForestView
	(properties
		x 210
		y 119
		priority 12
		view 414
		cel 3
		signal 16385
	)
)

(instance atp4 of ForestView
	(properties
		x 155
		y 91
		view 415
		cel 5
		signal 16385
	)
)

(instance atp5 of ForestView
	(properties
		x 61
		y 189
		view 418
		cel 1
		signal 16385
	)
)

(instance path of ForestView
	(properties
		x 172
		y 73
		priority 1
		fixPriority 1
		view 410
		loop 2
		signal 16385
	)
)

(instance soundFX of Sound
	(properties)
)

