;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 320)
(include sci.sh)
(use Main)
(use n010)
(use goGet)
(use PolyPath)
(use Polygon)
(use Feature)
(use StopWalk)
(use Sound)
(use Motion)
(use Actor)

(public
	Room320 0
)

(local
	local0
	local1
	[local2 200]
)

(procedure (localproc_0)
	(tree init:)
	(rock init:)
	(road init:)
	(wall init:)
	(plant init:)
	(branch init:)
)

(instance Room320 of FRoom
	(properties
		lookStr {You are now far south of the town.}
		picture 320
		style 0
		horizon 85
		north 270
		east 330
		west 310
		northX 175
		northY 100
		eastX 311
		eastY 134
		westX 10
		westY 147
	)

	(method (init)
		(if (> global225 0)
			(Load rsSOUND global225)
		)
		(Load rsSOUND 53)
		(Load rsSOUND 158)
		(if (== (gBeautyStory state:) 4)
			(= local0 ((gInventory at: 8) regActor:))
			(self defeatEntrance: 1)
		)
		(super init:)
		(proc10_29)
		(gTheIconBar enable: show:)
		(gCurRoom
			addObstacle:
				((Polygon new:)
					type: PBarredAccess
					init: 0 199 0 171 319 170 319 199
					yourself:
				)
				((Polygon new:)
					type: PBarredAccess
					init: 0 -26 319 -26 319 129 271 131 253 129 236 128 207 128 197 111 199 106 191 98 200 86 217 77 203 12 139 10 168 84 159 89 152 91 124 86 128 111 162 118 163 126 136 129 136 138 113 137 107 145 96 149 42 142 34 133 0 132
					yourself:
				)
		)
		(localproc_0)
		(mushroom stopUpd: init:)
		(if (and (== global145 5) (== global144 gBeautyStory))
			(= global140 2)
			(= local1 2)
			(self setRegions: 400) ; endGame
		)
		(forestSound play:)
	)

	(method (cue)
		(super cue:)
		(if (== local1 2)
			(self setScript: (ScriptID 400 1)) ; wyrmScript
		)
	)

	(method (dispose)
		(if defeatEntrance
			(self defeatEntrance: 0)
		)
		(super dispose: &rest)
	)

	(method (enterSpecial)
		(gCurRoom setScript: enterWithBeauty)
	)
)

(instance forestSound of Sound
	(properties
		flags 1
		number 153
		loop -1
	)
)

(instance enterWithBeauty of HandsOffScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(if (gGlobalMusic2 handle:)
					(gGlobalMusic2 fade: 0 15 12 0)
				)
				(local0
					setCycle: StopWalk
					posn: (gCurRoom northX:) (+ (gCurRoom northY:) 5)
					init:
					setMotion: PolyPath (gCurRoom northX:) 130 self
				)
				(gEgo
					normal: 1
					init:
					posn: (gCurRoom northX:) (gCurRoom northY:)
					setCycle: StopWalk
					setMotion: NPFollow local0 40
				)
			)
			(1
				(gGlobalMusic number: 53 play:)
				(gBookEnd
					view: 759
					setPri: 11
					loop: 0
					cel: 0
					posn: 252 133
					setCycle: End self
					init:
				)
			)
			(2
				(gBookEnd loop: 1 cel: 0 setCycle: End self)
			)
			(3
				(proc10_13 1 gBookEnd local0 self 1 320 0)
			)
			(4
				(proc10_13 0 local0 gBookEnd self 0 320 1)
			)
			(5
				(proc10_13
					0
					local0
					gBookEnd
					self
					1
					(Format @local2 320 2 @global110) ; "%s is here to help me get back to Beast."
				)
			)
			(6
				(gBookEnd cel: 0 setCycle: End self)
			)
			(7
				(proc10_13 1 gBookEnd local0 self 1 320 3)
			)
			(8
				(proc10_13
					2
					local0
					gEgo
					self
					1
					(Format @local2 320 4 @global110) ; "%s, are you afraid of Bookend?"
				)
			)
			(9
				(proc10_13 0 gEgo local0 self 1 320 5)
			)
			(10
				(proc10_13 0 local0 gBookEnd self 1 320 6)
			)
			(11
				(gBookEnd cel: 0 setCycle: End self)
			)
			(12
				(proc10_13 1 gBookEnd local0 self 1 320 7)
			)
			(13
				(proc10_13 0 local0 gBookEnd self 1 320 8)
			)
			(14
				(local0 setMotion: PolyPath 208 138 self)
			)
			(15
				(gBookEnd view: 762 loop: 4 cel: 3 posn: 226 147)
				(local0 setMotion: PolyPath 272 138 self)
			)
			(16
				(if (gGlobalMusic handle:)
					(gGlobalMusic fade: 0 15 12 1)
				)
				(gBookEnd view: 759 loop: 2 cel: 0 posn: 199 133 setCycle: Fwd)
				(proc10_13 3 gBookEnd 0 self 1 320 9)
			)
			(17
				(if (gGlobalMusic2 handle:)
					(gGlobalMusic2 fade: 127 15 12 0)
				)
				(local0 setMotion: PolyPath (+ (gCurRoom eastX:) 20) 138 self)
			)
			(18
				(gCurRoom newRoom: 330)
				(self dispose:)
			)
		)
	)
)

(instance mushroomSound of Sound
	(properties
		flags 1
		number 158
	)
)

(instance mushDance of HandsOffScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(mushroomSound play:)
				(mushroom setCycle: End self)
			)
			(1
				(mushroom loop: 1 cel: 0 setCycle: End self)
			)
			(2
				(mushroomSound stop:)
				(mushroom stopUpd: loop: 0 cel: 0)
				(self dispose:)
			)
		)
	)
)

(instance mushroom of Prop
	(properties
		x 91
		y 134
		description {Mushroom}
		lookStr {A mushroom grows here.}
		view 320
	)

	(method (doVerb theVerb)
		(switch theVerb
			(5 ; Do
				(mushroom setScript: mushDance)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance tree of Feature
	(properties
		x 103
		y 57
		description {Tree}
		sightAngle 90
		onMeCheck 2
		lookStr {The tree trunk is big.}
	)
)

(instance rock of Feature
	(properties
		x 125
		y 118
		description {Rock}
		sightAngle 90
		onMeCheck 4
		lookStr {The rock is warm to the touch.}
	)
)

(instance wall of Feature
	(properties
		x 305
		y 100
		description {Wall}
		sightAngle 90
		onMeCheck 8
		lookStr {This wall is very tall here.}
	)
)

(instance plant of Feature
	(properties
		x 198
		y 160
		description {Plant}
		sightAngle 90
		onMeCheck 16
		lookStr {This plant blocks your way.}
	)
)

(instance branch of Feature
	(properties
		x 151
		y 65
		description {Branch}
		sightAngle 90
		onMeCheck 32
		lookStr {The branch of the tree has no leaves.}
	)
)

(instance road of Feature
	(properties
		x 173
		y 125
		description {Road}
		sightAngle 90
		onMeCheck 128
		lookStr {The road goes north, east, and west from here.}
	)
)

